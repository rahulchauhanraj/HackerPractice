package com.rahul.concurrency;

import java.util.Scanner;

class A1 {
	int z;
	public void before(){
		System.out.println("before");
	}
	public void div(int x, int y,int v)   {
		try {
			z = x / y;
			int [] arr = new int[5];
			
			arr[v] = 33;
			return;
			
		} catch (ArithmeticException ae) {
			// TODO: handle exception
			ae.printStackTrace();
			//throw new ArithmeticException("gooooo");
		}
		catch (ArrayIndexOutOfBoundsException ae) {
			// TODO: handle exception
			ae.printStackTrace();
		}
		catch (Exception ae) {
			// TODO: handle exception
			ae.printStackTrace();
		}
		finally{System.out.println("finally 11111");}
		System.out.println("is this finally");
	}
	public void after(){
		System.out.println("after");
	}
}
class A2 extends A1 {
	public void callit(int x, int y,int v) throws Exception {
		try{div(x, y,v);}
		finally{System.out.println("finally 222222");}
	}
}
public class MainClass {
	public static void main(String[] args) throws Exception {
		A2 obj = new A2();
		//Scanner sc = new Scanner(System.in);
		//int val = sc.nextInt();
		obj.before();
		obj.callit(5, 0,4);
		obj.after();
	}
}
