package com.rahul.hacker;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;

/**
 * Created by 212578960 on 5/26/2017.
 */
public class NonDivisibleSubset {

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        printNonDivisibleSubset(n, a, k);
    }

    private static void printNonDivisibleSubset(int n, int[] a, int k) {
        int nonDivisibleCount = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if ((a[i] + a[j]) % k == 0) {
                        count++;
                    }
                }
            }

            if(count < n-1){
                nonDivisibleCount++;
            }
        }

        System.out.println(nonDivisibleCount);
    }
}
