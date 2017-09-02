package com.rahul.hacker.ds.problems;

import com.rahul.hacker.util.ScannerUtil;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by 212578960 on 5/27/2017.
 */
public class BestMask {

    static int solve(int[] a){
        int max = 0;
        Integer last = null;
        for(int val : a){
            int len = Integer.toBinaryString(val).length();
            if(len > max){
                max = len;
            }
            if(last == null){
                last = val;
            }else{
                last = last & val;
            }
        }
        if(last != 0){
            StringBuilder sb = new StringBuilder(Integer.toBinaryString(last));
            int len = sb.length();
            boolean first = true;
            for(int i= len-1; i>=0; i--){
                char c = sb.charAt(i);
                if(c == '1') {
                    if (!first) {
                        sb.setCharAt(i, '0');
                    } else {
                        first = false;
                    }
                }
            }
            return Integer.parseInt(sb.toString(), 2);
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<max; i++){
            sb.append(1);
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        //Double val = Math.pow(2, 26);
        //System.out.println(val);
        //System.out.println(val.intValue());
        //solve(a);
        //int result = solve(a);
        //System.out.println(Integer.toBinaryString(result));
        //System.out.println(result);
        solveTest(a);
        in.close();
    }

    static void solveTest(int[] a){
        int max = 0;
        Integer last = null;
        for(int val : a){
            String str =  Integer.toBinaryString(val);
            System.out.println(str);
            int len = str.length();
            if(len > max){
                max = len;
            }
            if(last == null){
                last = val;
            }else{
                last = last & val;
            }
        }
        System.out.println(last&1067);
    }

}
