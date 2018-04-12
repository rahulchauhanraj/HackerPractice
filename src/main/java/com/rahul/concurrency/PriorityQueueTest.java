package com.rahul.concurrency;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String... args) {
		PriorityQueueComparator pqc = new PriorityQueueComparator();
		PriorityQueue pq = new PriorityQueue(5, pqc);
		pq.add("ABC");
		pq.add("BD");
		pq.add("ABCE");
		pq.add("ABCD");

		for (Object s : pq) {
			System.out.println(s);
		}
	}
}

class PriorityQueueComparator implements Comparator {

	@Override
	public int compare(Object ss1, Object ss2) {
		String s1 = (String) ss1;
		String s2 = (String) ss2;
		if (s1.length() < s2.length()) {
			return -1;
		}
		if (s1.length() > s2.length()) {
			return 1;
		}
		return 0;		
	}

}
