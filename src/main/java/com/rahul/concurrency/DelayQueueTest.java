package com.rahul.concurrency;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {
	public static void main(String... args) throws InterruptedException {
		BlockingQueue dq = new DelayQueue();
		DeleyedTest ob1 = new DeleyedTest(10000);
		DeleyedTest ob2 = new DeleyedTest(50000);
		DeleyedTest ob3 = new DeleyedTest(100000);
		dq.offer(ob1);
		System.out.println("obj 1 offer");
		dq.offer(ob2);
		System.out.println("obj 2 offer");
		dq.offer(ob3);
		System.out.println("obj 3 offer");
		/*Iterator itr = dq.iterator();
		while (itr.hasNext()) {
			DeleyedTest dt = (DeleyedTest) itr.next();
			System.out.println(dt.deleyTime);
		}*/
		for (int i = 1; i <= 3; i++) {
			System.out.println("before");
			System.out.println(dq.take());
			System.out.println("after");
		}
		System.out.println("main over");
	}
}

class DeleyedTest implements Delayed {
	public long deleyTime = 0;
	long time = System.currentTimeMillis();

	DeleyedTest(long deleyTime) {
		this.deleyTime = deleyTime;
	}

	@Override
	public int compareTo(Delayed ob) {
		if (this.deleyTime < ((DeleyedTest) ob).deleyTime) {
			return -1;
		} else if (this.deleyTime > ((DeleyedTest) ob).deleyTime) {
			return 1;
		}
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long val = unit.convert(
				deleyTime - (time - System.currentTimeMillis()),
				TimeUnit.MILLISECONDS);
		System.out.println("val " + val);
		return val;
	}

}
