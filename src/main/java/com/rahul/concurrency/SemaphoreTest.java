package com.rahul.concurrency;

import java.util.concurrent.*;
import java.util.*;
import java.text.*;

public class SemaphoreTest {
	private static final int MAX_THREADS = 5;

	public static void main(String[] args) throws Exception {
		Semaphore semaphore = new Semaphore(0);

		System.out.println("Spawning Threads");
		int threadCount = 0;
		Random random = new Random();
		for (int i = 0; i < MAX_THREADS; i++) {
			// Threads created will not always be MAX_THREADS
			// Because Threads are created only if Random no is Even.
			// Thus the No of Threads unknown at Semaphore Initialization
			if (random.nextInt(9999) % 2 == 0) {
				Thread t = new Thread(new WorkerThread(semaphore, String
						.format("Thread-%d", i)));
				t.start();
				threadCount++;
				System.out.println(threadCount);
			}
		}
		System.out.println("Spawning Finished");
		System.out.println("Waiting All Threads to Finish");
		semaphore.acquire(threadCount);
		System.out.println("All Threads are Finished");
	}

	private static class WorkerThread implements Runnable {
		private Semaphore semaphore;

		private String name;

		public WorkerThread(Semaphore semaphore, String name) {
			this.name = name;
			this.semaphore = semaphore;
		}

		public void run() {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(
						"dd/MM/yyyy HH:mm:ss");
				System.out.printf("%s : Doing Some Work on %s\n",
						getFormattedDate(sdf), name);
				Thread.sleep(getRandomWaitTime());
				System.out.printf("%s : Doing Some more work on %s\n",
						getFormattedDate(sdf), name);
				Thread.sleep(getRandomWaitTime());
				System.out.printf("%s : Finished work on %s\n",
						getFormattedDate(sdf), name);
				semaphore.release();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private String getFormattedDate(SimpleDateFormat sdf) {
			return sdf.format(new Date());
		}

		private int getRandomWaitTime() {
			return (int) ((Math.random() + 1) * 1000);
		}

	}
}