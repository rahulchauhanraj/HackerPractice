package com.rahul.concurrency;

public class Snippet {
	public static void main(String[] args) {

		Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
			public void uncaughtException(Thread th, Throwable ex) {
				System.out.println("i am catcing it Uncaught exception: " + ex);
			}
		};
		Thread t = new Thread() {
			public void run() {
				System.out.println("Sleeping ...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Interrupted.");
				}
				System.out.println("Throwing exception ...");
				throw new RuntimeException();
			}
		};
		t.setUncaughtExceptionHandler(h);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("hello");
			e.printStackTrace();
		}
		System.out.println("Main Over");
	}
}
