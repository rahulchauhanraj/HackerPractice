package com.rahul.hacker.problems;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedThreadPoolExecutor {

    private LinkedBlockingQueue<Runnable> q = new LinkedBlockingQueue<>();

    private boolean isShuttingDown = false;

    private int poolSize;
    AtomicInteger activeThreadCount = new AtomicInteger(0);

    private Worker[] workers;

    public FixedThreadPoolExecutor(int size) {
        this.workers = new Worker[size];
        for (int i=0; i<size; i++) {
            poolSize = size;
            Worker worker = new Worker();
            Thread thread = new Thread(worker);
            worker.setThread(thread);
            workers[i] = worker;
            thread.start();
            activeThreadCount.incrementAndGet();
        }
    }

    class Worker implements Runnable {
        Runnable task;
        boolean isIdeal;

        public Thread getThread() {
            return thread;
        }

        public void setThread(Thread thread) {
            this.thread = thread;
        }

        Thread thread;
        @Override
        public void run() {
            boolean isInterrupted= false;
            while (true) {
                try{
                    isIdeal = true;
                    task = q.take();
                    isIdeal = false;
                    task.run();
                    isIdeal = true;
                } catch (InterruptedException e) {
                    isInterrupted = true;
                    System.out.println("Exception while executing task " + Thread.currentThread().getName() + e);
                    System.out.println(Thread.currentThread().getName() + " is interrupted " + Thread.currentThread().isInterrupted());
                }
                if(q.isEmpty() && isShuttingDown) {
                    System.out.println("Exiting thread place 2");
                    activeThreadCount.decrementAndGet();
                    break;
                }
            }
        }
    }

    static class Task implements Runnable{
        private String str;

        public Task(String str) {
            this.str = str;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(str);
        }
    }

    public static void main(String[] args) throws Exception{
        FixedThreadPoolExecutor executor = new FixedThreadPoolExecutor(2);
        for (int i=0; i<10; i++) {
            Runnable task = new Task(String.format("This is a %s task", i));
            executor.submit(task);
        }

        for (int i=0; i<10; i++) {
            Runnable task = new Task(String.format("This is a 1%s task", i));
            executor.submit(task);
        }

        Thread.sleep(2000);
        System.out.println("Active thread count : " + executor.activeThreadCount);
        executor.shutdown();

        Thread.sleep(1000);

        System.out.println("Active thread count : " + executor.activeThreadCount);
    }

    public void shutdown() {
        System.out.println("Executor is shutting down");
        isShuttingDown = true;
        for(int i=0; i<this.poolSize; i++) {
            Worker worker = workers[i];
            Thread t = worker.getThread();
            if(worker.isIdeal) {
                t.interrupt();
            }
        }
        System.out.println("Shutdown value is " + isShuttingDown);
    }

    public void submit(Runnable task) throws InterruptedException{
        if (isShuttingDown) {
            throw new RuntimeException("Executor is shutting down.");
        }
        else {
            q.put(task);
        }
    }
}
