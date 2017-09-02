package com.rahul.hacker.ds.problems.array;

import com.rahul.hacker.util.ScannerUtil;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 212578960 on 8/25/2017.
 */
public class ArrayManipulation {

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        int m = in.nextInt();

        int[] ar = new int[n];

        for(int a_i = 0; a_i < m; a_i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            ar[a-1] += k;
            if (b<n) {
                ar[b] -= k;
            }
        }

        long max=0;
        long temp=0;

        for(int i=0;i<n;i++){
            temp += ar[i];
            if(temp> max) max=temp;
        }

        System.out.println(max);
        in.close();
    }
}
