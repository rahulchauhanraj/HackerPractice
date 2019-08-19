package com.rahul.hacker.problems;

public class StreamException {

    public static void main(String[] args) {

        Runnable task = () -> {

            int i = 1;

            while (i < 1000) {
                System.out.println(i);
                i++;
            }
            System.out.println("Test");
            //throw new RuntimeException();
        };

        Thread t = new Thread(task);
        t.run();
        System.out.println("Completed");
    }
}

