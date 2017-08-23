package com.rahul.hacker.ds.problems.array;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;

/**
 * Created by 212578960 on 5/26/2017.
 */
public class BiggerArrays {

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        int q = in.nextInt();
        int[] A = new int[n];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < q; a0++){
            // Write Your Code Here
        }
    }

    private static long getBiggerArrayCount(int [] a){
        long count = 0;

        int s = 1;
        /*int e = l > r ? l : r;
        count += e;*/


        return count;
    }
}
