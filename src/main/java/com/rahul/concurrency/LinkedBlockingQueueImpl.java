package com.rahul.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueImpl {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(2);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}

}

class LBQProducer implements Runnable {

	protected BlockingQueue queue = null;

	public LBQProducer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				queue.put(i);
				//System.out.println("produced : " + i);
				Thread.sleep(1000);
			}
			//queue.put(null);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class LBQConsumer implements Runnable {

	protected BlockingQueue queue = null;

	public LBQConsumer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			// while (true)
			for (int i = 0; i < 9; i++) {
				System.out.println("Consumed " + queue.take());
				//if (i == 2)
					//Thread.sleep(8000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
