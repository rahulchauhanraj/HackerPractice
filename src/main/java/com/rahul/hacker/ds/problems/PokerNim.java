package com.rahul.hacker.ds.problems;

/**
 * Created by 212578960 on 5/23/2017.
 */
public class PokerNim {
    public static void main(String[] args) {
        long n = 12;
        printDisplayedValue(n);
    }

    static void printDisplayedValue(long n){
        long val = 3;
        long lastVal = 0;
        while(val < n){
            long newVal = val + 2 * (val - lastVal);
            lastVal = val;
            val = newVal;
        }

        System.out.println(val - n + 1 );
    }
}
