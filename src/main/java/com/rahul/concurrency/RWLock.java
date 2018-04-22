package com.rahul.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLock {

	ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

	class Read implements Callable<Integer> {
		Integer i;

		Read(Integer i) {
			this.i = i;
		}

		public Integer call() throws Exception {
			try {
				readWriteLock.readLock().lock();
				System.out.println("Thread " + i + " is reading...");
				Thread.sleep(3000);
			} finally {
				System.out.println("Thread " + i + " ends reading...");
				readWriteLock.readLock().unlock();
			}
			return null;
		}
	}

	class Write implements Callable<Integer> {
		Integer i;

		Write(Integer i) {
			this.i = i;
		}

		public Integer call() throws Exception {
			// try{
			readWriteLock.writeLock().lock();
			/*
			 * if(i == 2){ throw new Exception("my exception"); }
			 */
			System.out.println("Thread " + i + " is writing...");
			 Thread.sleep(2000);
			// }
			// finally {

			System.out.println("Thread " + i + " ends writing...");
			readWriteLock.writeLock().unlock();
			//if (i == 2)
				//throw new Exception("my exception");
			// }
			return null;
		}
	}

	public static void main(String[] args) {
		ExecutorService obj = Executors.newFixedThreadPool(2);
		/*Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				try {
					
					Thread.sleep(5000);
					//throw new RuntimeException("i am exception");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
		};
		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		Runnable r3 = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		Runnable r4 = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());

			}
		};
		Runnable r5 = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};*/
		
		//obj.submit();
		

		RWLock rwLock = new RWLock(); 
		rwLock.exec();
		
	}

	void exec() {
		ExecutorService ser = Executors.newFixedThreadPool(20);
		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0) {
				ser.submit(new Write(i));
			} else {
				ser.submit(new Read(i));
			}
		}
		ser.shutdown();
	}

}
