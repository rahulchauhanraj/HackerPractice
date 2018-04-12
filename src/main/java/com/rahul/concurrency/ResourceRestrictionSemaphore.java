package com.rahul.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ResourceRestrictionSemaphore implements Runnable {

	public final static int COUNT = 15;
	public static int dbConnCount = 0;

	// Semaphore with 4 permits
	Semaphore handler = new Semaphore(COUNT, true);

	public static void main(String[] args) {

		ResourceRestrictionSemaphore job = new ResourceRestrictionSemaphore();
		ExecutorService worker = Executors.newFixedThreadPool(10);
		int i = 1;
		while (i < 100) {
			worker.execute(job);
			i++;
		}
		worker.shutdown();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			handler.acquire();
			dbConnCount++;
			makeDBConnection();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			dbConnCount--;
			handler.release();
		}
	}

	private void makeDBConnection() throws InterruptedException {
		Thread.currentThread().sleep(500);
		System.out.println("DB Connection  . . . . ." + dbConnCount);
	}

}
