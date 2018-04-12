package com.rahul.concurrency;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.WeakHashMap;

public class WeakRef {

	public static void main(String[] args) throws Exception {
		/*Scanner sc = new Scanner(System.in);
		String str  = sc.next();System.out.println("i got" + str);
		String str1  = sc.next();System.out.println("i got" + str1);*/
		Map<String, String> m = new WeakHashMap<String, String>();
		//Map<String, String> m = new HashMap<String, String>();
		String str1 = new String("abc");
		//soft reference
		SoftReference<String> sstr1 = new SoftReference<String>(str1);
		m.put(str1, "abc");
		String str2 = new String("xyz");
		m.put(str2, "abc");
		System.out.println(m.size());
		str1 = null;
		Thread.sleep(5000);
		System.gc();
		System.out.println(m.size());
		
		
		/*for(int i=1; i<=1000000; i++) {
			m.put(""+i, ""+i);
		}*/
		System.out.println(m);
		int i = 0;
		//System.gc();
		//Thread.sleep(5000);
		System.out.println(m);
		
		/*WeakReference<String>[] arr = new WeakReference[1000000];
		for(int j=0; j<=1000000-1; j++) {
			arr[j] = new WeakReference<String>("AAAAAAAAAAAAAAAAAA"+j);
		}
		System.out.println(Arrays.toString(arr));*/
		/*while(true) {
			System.out.println(m);
			i++;
			if(i == 3) {
				System.gc();
				System.out.println("garbage collection initiated....");
			}
			Thread.sleep(2000);
		}*/
	}

}
