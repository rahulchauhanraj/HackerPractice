package com.rahul.hacker.ds.problems.array;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;

/**
 * Created by 212578960 on 8/25/2017.
 */
public class ArrayLeftRotation {
    static int[] leftRotation(int[] a, int d) {
        int ind = 0;
        int index = d;
        int[] a1 = new int[a.length];
        while(index < a.length){
            a1[ind] = a[index];
            index++;
            ind++;
        }
        index = 0;
        while(index < d){
            a1[ind] = a[index];
            index++;
            ind++;
        }
        return a1;
    }

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
