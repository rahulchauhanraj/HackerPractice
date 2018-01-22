package com.rahul.hacker.ds.problems.string;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s){
        int count =0;
        int[] a = new int[26];
        int n = s.length();
        for(int i =0; i<n; i++){
            a[Integer.valueOf(s.charAt(i)-97)]++;
        }

        for(int i =0; i<n; i++){
            for(int j =i+1; j<n; j++){
                String sub = s.substring(i, j);
                int k =0;
                for(; k< sub.length(); k++){
                    if(a[Integer.valueOf(sub.charAt(k)-97)] > 1){
                        count++;
                        break;
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
    }
}
