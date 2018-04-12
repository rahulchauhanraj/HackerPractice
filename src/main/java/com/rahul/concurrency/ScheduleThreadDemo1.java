package com.rahul.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadDemo1 {

	static class A implements Runnable {
		String s;
		A(String s) { this.s = s; }
		@Override
		public void run() {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		ScheduledExecutorService sc = Executors.newScheduledThreadPool(3);
		sc.scheduleWithFixedDelay(new A("5 sec"), 5, 5, TimeUnit.SECONDS);
		sc.schedule(new A("10 sec"), 10, TimeUnit.SECONDS);
		sc.schedule(new A("15 sec"), 15, TimeUnit.SECONDS);
		//sc.shutdown();
	}

}
