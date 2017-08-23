package com.rahul.hacker.ds.problems.string;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by 212578960 on 5/27/2017.
 */
public class NumericString {
    static long getMagicNumber(String s, int k, int b, int m){
        int n = s.length();
        int j = k;
        BigInteger rem = new BigInteger(String.valueOf(m));
        return IntStream.rangeClosed(0,n-j).parallel().mapToLong(value -> getMagicValue(s, value, j, b, rem)).sum();
    }

    private static int getMagicValue(String s, int value, int j, int b, BigInteger rem){
        String str = s.substring(value, value+j);
        baseToBase(str, b, 10);
        //System.out.println(new BigInteger(new BigInteger(str, b).toString(10)));
        //System.out.println();
        //System.out.println();
        //return new BigInteger(new BigInteger(str, b).toString(10)).remainder(rem).intValue();
        return 0;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        /*String s = "0111";
        int k = 2;
        int b = 10;
        int m = 100;*/

        int b = 9;
        Random rm = new Random();
        StringBuilder sb1 = new StringBuilder();
        for(int i=0; i< 3000000;i++){
            sb1.append(rm.nextInt(b));
        }
        String s = sb1.toString();
        int k = 32;

        int m = 995;
        long result = getMagicNumber(s, k, b, m);
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start);
    }

    static String baseToBase(String num, int base1, int base2) {
        int no = convFrmBaseToDeci(num, base1);
        return convFrmDecToBase(no, base2);
    }

    static String convFrmDecToBase(int num, int base) {

        String res = "";
        int rem;
        while (num > 0) {
            rem = num % base;
            res += rem;
            num /= base;
        }
        return new StringBuffer(res).reverse().toString();
    }

    static int convFrmBaseToDeci(String num, int base) {

        if (base < 2 || (base > 10 && base != 16))
            return -1;

        int val = 0;
        int power = 1;

        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = digitToVal(num.charAt(i));

            if (digit < 0 || digit >= base)
                return -1;

            val += digit * power;
            power = power * base;
        }

        return val;
    }

    static int digitToVal(char c) {
        if (c >= '0' && c <= '9')
            return (int) c - '0';
        else
            return (int) c - 'A' + 10;
    }
}
