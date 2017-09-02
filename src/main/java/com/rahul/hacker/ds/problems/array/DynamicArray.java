package com.rahul.hacker.ds.problems.array;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 212578960 on 8/25/2017.
 */
public class DynamicArray {

    public static int solveQuery(int[][] a, int t, int x, int y, int lastAnswer){
        int n = a.length;
        int seq = (x ^ lastAnswer) % n;
        if(t == 1){
            int newLength = a[seq].length + 1;
            a[seq] = Arrays.copyOf(a[seq], newLength);
            a[seq][newLength - 1] = y;
        }else{
            lastAnswer = a[seq][y % a[seq].length];
            System.out.println(lastAnswer);
        }
        return lastAnswer;
    }

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        int q = in.nextInt();
        int[][] a = new int[n][0];
        int lastAnswer = 0;
        for(int a_i = 0; a_i < q; a_i++){
            int t = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            lastAnswer = solveQuery(a, t, x, y, lastAnswer);
        }
        in.close();
    }
}
