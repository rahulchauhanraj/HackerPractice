package com.rahul.concurrency;

import java.util.PriorityQueue;

public class PriorityQueueTest1 {
	public static void main(String... args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("A");
		pq.add("B");
		pq.add("C");
		pq.add("D");
		pq.add("E");
		pq.add("F");
		pq.add("G");
		pq.add("H");
		System.out.println("After Using add method.");
		for (String s : pq) {
			System.out.println(s);
		}
		pq.remove();
		pq.remove();
		System.out.println("After Using remove method.");
		for (String s : pq) {
			System.out.println(s);
		}
		/*pq.add("E");
		pq.add("F");*/
		System.out.println("After 2 more add method.");
		/*pq.remove();
		pq.remove();*/
		/*
		 * pq.poll(); pq.poll(); pq.poll();pq.poll();
		 */
		/*pq.add("G");
		for (String s : pq) {
			System.out.println(s);
		}*/
		// System.out.println("peek: "+pq.peek());

		/*
		 * System.out.println("After Using poll method."); pq.poll(); for
		 * (String s : pq) { System.out.println("p: " + s); }
		 * System.out.println("peek: "+pq.peek());
		 * System.out.println("After Using remove method."); pq.remove("D"); for
		 * (String s : pq) { System.out.println(s); }
		 * System.out.println("peek: "+pq.peek()); pq.remove("B");
		 * System.out.println("After Using remove B method."); for (String s :
		 * pq) { System.out.println(s); }
		 * System.out.println("peek: "+pq.peek());
		 */
	}
}