package com.rahul.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableWithExceptionDemo {

	public static void main(String[] args) {
		ExecutorService ser = Executors.newSingleThreadExecutor();
		Future<String> future = ser.submit(new MyCallable());

		try {
			System.out.println(future.get());
		} catch (Exception e) {
			System.out.println("Gotcha .. " + e.getMessage());
		}
	}
}

class MyCallable implements Callable<String> {
	@Override
	public String call() throws Exception {
		return "Hellooo ";
		// throw new Exception(" Sample Exception");
	}
}
// class