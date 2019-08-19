package com.rahul.hacker.problems;

public class ThreadThrowsUncaughtException {

    public static void main(String args []) throws Exception {

        Thread t = new Thread() {
            public void run () {
                throw new RuntimeException("Runtime Exception");
            }
        };

        t.start();
        Thread.sleep(100);
        System.out.println("Completed.");
    }
}
