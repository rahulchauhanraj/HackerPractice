package com.rahul.concurrency;

import java.util.ArrayList;

public class Maiclass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("aa");
		System.out.println(list);
		list.ensureCapacity(40);
		list.add(25, "aaa");

	}

}
