package com.rahul.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	public static void main(String[] args) throws Exception {

		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1024);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		System.out.println("Main thread completed.");
		//Thread.sleep(4000);
	}
}

class Producer implements Runnable {

	protected BlockingQueue queue = null;

	public Producer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				queue.put(i);
				System.out.println("Producing " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {

	protected BlockingQueue queue = null;

	public Consumer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			// while (true)
			for (int i = 0; i < 10; i++) {
				System.out.println("Consuming " + queue.take());
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
