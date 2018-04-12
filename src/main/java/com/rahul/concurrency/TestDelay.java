package com.rahul.concurrency;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TestDelay {

	static class DD implements Delayed {
		final static long NANO_ORIGIN = System.nanoTime();
		long nano;
		int sec;

		DD(long nano) {
			this.sec = (int) nano;
			this.nano = nano * 1000000000;
		}

		@Override
		public int compareTo(Delayed o) {
			DD other = (DD) o;
			return sec - other.sec;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			long d = unit.convert(nano - now(), TimeUnit.NANOSECONDS);			
//			System.out.println( unit );
//			long d = nano - now();
			return d;
		}

		@Override
		public String toString() {
			return "DD [sec=" + sec + "]";
		}

		long now() {
			return System.nanoTime() - NANO_ORIGIN;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		DelayQueue<TestDelay.DD> d = new DelayQueue<TestDelay.DD>();
		d.add(new DD(10));
		d.add(new DD(20));
		d.add(new DD(30));
		System.out.println(d.take());
		System.out.println(d.take());
		System.out.println(d.take());
		System.out.println(d.size());
	}

}
