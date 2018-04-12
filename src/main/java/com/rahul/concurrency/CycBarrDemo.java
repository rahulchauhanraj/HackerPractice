package com.rahul.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CycBarrDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		System.out.println(1 << 16);
		ExecutorService ser = Executors.newFixedThreadPool(3);
		CyclicBarrier b = new CyclicBarrier(3, new Runnable() {
			public void run() {
				System.out.println("end thread exec barrirer");
			}
			
		});
		ser.submit(new A(1000, "1st one", b));
		ser.submit(new A(2000, "2nd two", b));
		ser.submit(new A(4000, "3rd three", b));
		ser.submit(new A(3000, "4st four", b));
		ser.submit(new A(4000, "5nd five", b));
		ser.submit(new A(5000, "6rd six", b));
		ser.submit(new A(2000, "4th fourth", b));
		//Future<String> f = ser.submit(new A(3000, "third one", b));
		ser.shutdown();
		if(ser.awaitTermination(20, TimeUnit.SECONDS)) {
			System.out.println("hihihi: "+ser.isTerminated());
			//System.out.println("*** "+ f.get()+" ***");
		}
		else {
			//b.
			//b.reset();
			//b.
			//System.out.println("hihihi 2: "+ser.isTerminated());
			//System.out.println("*** "+ f.get()+" ***");
		}
		System.out.println("main over");
	}
	
	static class A implements Callable<String> {
		CyclicBarrier b;
		String nm;
		long millis;
		A(long millis, String nm, CyclicBarrier b) {
			this.b = b;
			this.nm = nm; 
			this.millis = millis;
		}
		@Override
		public String call() throws Exception {
			Thread.sleep(millis);
			System.out.println(nm);
			b.await();
			//System.out.println(nm+" ending...");
			//b.await();
			//System.out.println(nm+" ending 2...");
			//b.await();
			//System.out.println(nm+" ending 3...");
//			b.await();
//			System.out.println(nm+" ending 4...");
			return nm;
		}
		
	}
}
