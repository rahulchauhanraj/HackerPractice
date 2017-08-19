package com.rahul.hacker;

import com.rahul.hacker.util.ScannerUtil;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by 212578960 on 6/29/2017.
 */
public class SeparateTheNumbers {
    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            System.out.println(containsIncrementalNumbers(s));
        }
        in.close();
    }

    static String containsIncrementalNumbers(String s){
        if(s.startsWith("0")){
            return "NO";
        }

        int size = 1;
        int len = s.length();
        int rem = len - size;
        BigInteger one = new BigInteger("1");
        while(rem >= size){
            int start = 0;
            int end = size;
            BigInteger initialVal = new BigInteger(s.substring(start, end));
            BigInteger nextVal = initialVal.add(one);
            boolean match = true;
            while(rem >= size){
                int nextLen = nextVal.toString().length();
                start = end;
                end = start + nextLen;
                BigInteger val = new BigInteger(s.substring(start, end));
                if(!nextVal.equals(val)){
                    match = false;
                    break;
                }
                rem -= nextLen;
                nextVal = nextVal.add(one);
            }
            if(match && rem == 0){
                return "YES " + initialVal;
            }
            size++;
            rem = len - size;
        }
        return "NO";
    }
}
