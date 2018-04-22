package com.rahul.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RLock {

	Lock lock = new ReentrantLock();
	Condition cond = lock.newCondition();
	Condition cond1 = lock.newCondition();
	public static void main(String[] args) {
		new RLock().exec();
	}

	void exec() {
		ExecutorService ser = Executors.newCachedThreadPool();
		ser.execute(new A("1"));
		ser.execute(new A("2"));
		ser.execute(new A("3"));
		ser.execute(new A("4"));
		ser.execute(new A("5"));
		ser.execute(new A("6"));
		ser.execute(new A("7"));
		ser.execute(new A("8"));
		ser.execute(new A("9"));
		ser.shutdown();
		ScheduledExecutorService sser = Executors
				.newSingleThreadScheduledExecutor();
		sser.schedule(new Runnable() {
			public void run() {
				lock.lock();
				// lock.lockInterruptibly()
				System.out.println("wake threads...........");
				// cond.signalAll();
				cond.signalAll();
				lock.unlock();
			}

		}, 10, TimeUnit.SECONDS);
		sser.shutdown();
	}

	class A implements Runnable {
		String nm;

		A(String nm) {
			this.nm = nm;
		}

		public void run() {
			lock.lock();
			try {
				System.out.println("Thread " + nm + " acquired lock");
				Thread.sleep(2000);
				cond.await();
				System.out.println(Thread.currentThread().getState());
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				System.out.println("Thread " + nm + " released lock");
				lock.unlock();
			}
		}

	}

}
