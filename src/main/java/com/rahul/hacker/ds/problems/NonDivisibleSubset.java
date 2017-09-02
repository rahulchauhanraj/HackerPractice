package com.rahul.hacker.ds.problems;

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
        int[] a = new int[k];
        for(int i=0;i<n;i++){
            int val = in.nextInt();
            int ind = val % k;
            a[ind]++;
        }

        int result=0;

        if(k%2==0 && a[k/2] > 0) {
            result++;
        }

        result=result+Math.min(a[0],1);

        for(int j=1;j<=k/2;j++) {
            if (j != k - j) {
                result += Math.max(a[j], a[k - j]);
            }
        }
        System.out.println(result);
        in.close();
    }
}
