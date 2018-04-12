package com.rahul.concurrency;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueExample {

	private final SynchronousQueue<WorkItem> queue = new SynchronousQueue<WorkItem>();
	private final int consumerThreads = 5;
	private final int producerThreads = 5;

	public SynchronousQueueExample() {
		System.out.println("Starting...");

		// Start the consumers.
		for (int i = 0; i < consumerThreads; i++) {
			Consumer c = new Consumer(queue);
			c.setName("Consumer " + i);
			c.start();
		}

		// Start the producers.
		for (int i = 0; i < producerThreads; i++) {
			Producer p = new Producer(queue);
			p.setName("Producer " + i);
			p.start();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SynchronousQueueExample();
	}

	private static class Consumer extends Thread {

		private final SynchronousQueue<WorkItem> queue;

		public Consumer(SynchronousQueue<WorkItem> queue) {
			this.queue = queue;
		}

		public void run() {
			Random r = new Random();
			while (!Thread.currentThread().isInterrupted()) {
				WorkItem item = null;
				try {
					item = queue.take();
					System.out.println(Thread.currentThread().getName()
							+ " consuming: " + item);
					Thread.sleep(r.nextInt(1000));
				} catch (InterruptedException inte) {

					Thread.currentThread().interrupt();
				}
			}
		}
	}

	private static class Producer extends Thread {
		private static final String[] DATA = { "a", "b", "c", "d", "e", "f",
				"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };

		private final SynchronousQueue<WorkItem> queue;

		public Producer(SynchronousQueue<WorkItem> queue) {
			this.queue = queue;
		}

		public void run() {
			Random r = new Random();
			while (!Thread.currentThread().isInterrupted()) {
				String data = DATA[r.nextInt(DATA.length)];
				WorkItem item = new WorkItem(data + "("
						+ Thread.currentThread().getName() + ")");
				try {
					Thread.sleep(r.nextInt(5000));
					System.out.println(Thread.currentThread().getName()
							+ " queuing: " + item);
					queue.put(item);
				} catch (InterruptedException inte) {

					Thread.currentThread().interrupt();
				}
			}
		}
	}

	private static class WorkItem {

		private final String message;

		public WorkItem(String message) {
			this.message = message;
		}

		public String toString() {
			return message;
		}
	}

}