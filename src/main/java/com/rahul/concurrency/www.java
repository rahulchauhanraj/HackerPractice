package com.rahul.concurrency;

import java.util.ArrayList;

public class www {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//List<String> data = new ArrayList<String>();
		ArrayList<String> data = new ArrayList<String>(100);
		data.add("aa");
		data.add("aa");
		data.add("aa");
		data.add("aa");
		data.add("aa");
		data.add("aa");
		data.add("aa");
		data.add("aa");
		data.add("aa");
		data.add("aa");
		data.add("aa");
		//data.add("aa");
		data.add(12,"11th element");
		System.out.println("data" + data);
	}

}
