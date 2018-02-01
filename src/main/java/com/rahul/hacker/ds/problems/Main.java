package com.rahul.hacker.ds.problems;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    static long minimumTime(int[] b, int m, int k, int t) {
        if(m > t){
            return -1;
        }

        int n = b.length;
        int[]  a = new int[t];
        int j = 0;
        for(int i = 0; i<n; i++ ){
            if(b[i] == 1){
                a[j] = i;
                j++;
            }
        }
        int pivot = getPivotElement(a, m);
        return getTime(b, m, k, t, pivot);
    }

    static int getPivotElement(int[] a, int m) {
        if(a.length == 1){
            return 0;
        }
        int minDiff = 0;
        int minDifIndex = 0;
        int start =1;
        int end = m;

        int n = a.length;
        int startDiff = a[start] - a[start-1];
        int endDiff = a[end-1] - a[end - 2];
        int diff = 0;
        for(int i=start; i<end; i++){
            diff += a[i] - a[i-1];
        }

        minDiff = diff;
        start++;
        end++;

        while(end <= n){
            diff -= startDiff;
            startDiff = a[start] - a[start-1];
            diff += a[end-1] - a[end - 2];
            if(diff < minDiff){
                minDiff = diff;
                minDifIndex = start-1;
            }
            start++;
            end++;
        }

        return minDifIndex;
    }

    static long getTime(int[] b, int m, int k, int t, int start) {
        int n = b.length;
        long dis = 0;
        int c = 0;
        for (int i = 1; i < n; i++) {
            int elem = b[i];
            if (start > 0) {
                if (elem == 1) {
                    start--;
                }
                dis++;
                continue;
            }

            if (c != 0) {
                dis += c * k;
            } else {
                dis++;
            }
            if (elem == 1) {
                c++;
            }
            if (c == m) {
                break;
            }
        }
        return dis;
    }


    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] b = new int[n];
        int t = 0;
        for(int b_i = 0; b_i < n; b_i++){
            int val = in.nextInt();
            if(val == 1){
                t++;
            }
            b[b_i] = val;
        }
        long result = minimumTime(b, m, k, t);
        System.out.println(result);
        in.close();
    }


}
