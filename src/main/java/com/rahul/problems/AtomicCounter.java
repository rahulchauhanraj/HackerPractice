package com.rahul.problems;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class AtomicCounter {

    private AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        AtomicCounter atomicCounter = new AtomicCounter();
        //FileHandler fh = new FileHandler("C:/temp/test/counter.txt");
        for(int i=0; i < 10000000;i++) {
            executor.submit(() -> {
                //fh.publish(new LogRecord(Level.INFO, "" + 1));
                atomicCounter.increment();
            });
        }
        Thread.sleep(3000);
        System.out.println(atomicCounter.counter);
        executor.shutdown();
    }

    public void increment (){
        counter.incrementAndGet();
    }
}
