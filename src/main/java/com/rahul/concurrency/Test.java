package com.rahul.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

	private static Object mutex = new Object();
	// List<String> list = new ArrayList<String>();

	static Lock lock = new ReentrantLock();

	public  void get() {
		 lock.lock();
		// synchronized (mutex) {

		System.out.println("get()");
		// }

		 lock.unlock();
	}

	public static   void m1() {
		lock.lock();
		// synchronized (mutex) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m1");
		lock.unlock();
		// }
		/*
		 * lock.lock(); lock.unlock();
		 */
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Test obj = new Test();
		Runnable r = new Runnable() {

			@Override
			public void run() {
				Test.m1();
			}
		};
		Thread t = new Thread(r);
		t.start();
		

		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				obj.get();
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();

	}

}
