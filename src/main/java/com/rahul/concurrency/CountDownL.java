package com.rahul.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class MyService implements Runnable {
	CountDownLatch cdl;
	String name;
	long delay;

	public MyService(CountDownLatch cdl, String name, long delay) {
		super();
		this.cdl = cdl;
		this.name = name;
		this.delay = delay;
	}

	@Override
	public void run() {
		System.out.println("I am running " + name);
		cdl.countDown();
		//System.out.println( "1 -- count down");
		cdl.countDown();
		//System.out.println( "2 -- last count down");
		//cdl.countDown();
		try {
			Thread.sleep( 5000 );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//cdl.countDown();
		//cdl.countDown();
		//System.out.println( " -- last count down -------- ");
		//cdl.countDown();
	}
}

public class CountDownL {

	public static void main(String[] args) {
		/*ArrayList<String> list = new ArrayList<String>();
		list.add("abc");*/
		//list.ensureCapacity(minCapacity)
		CountDownLatch cdl = new CountDownLatch(3);
		Thread t1 = new Thread(new MyService(cdl, "First Thread", 3000));
		Thread t2 = new Thread(new MyService(cdl, "Second Thread", 3000));
		Thread t3 = new Thread(new MyService(cdl, "Third Thread", 3000));
		t1.start();		
		//t2.start();
		//t3.start();
		try {
			System.out.println( "-- now waiting --");
			cdl.await();
			System.out.println( "--waiting completed --");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("all threads are running");
		new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("New ONE i m running");				
			}
		}).start();
		System.out.println("main over");
	}

}
