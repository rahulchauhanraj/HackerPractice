package com.rahul.hacker.ds.problems.string;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;

public class CharacterInString {

    public static void main (String[] args) {
        Scanner sc = ScannerUtil.getScanner();
        Integer q = sc.nextInt();

        for(int i =0; i<q; i++){
            Integer m = sc.nextInt();
            Integer k = sc.nextInt();
            Integer n = sc.nextInt();
            characterInString(m,n,k);
        }
    }

    private static void characterInString(int m, int n, int k){
        String binaryValue = Integer.toBinaryString(m);

        for(int i = 0; i< n; i++){
            int ind = 0;
            StringBuilder sb = new StringBuilder(binaryValue);
            for(int j =0; j< sb.length() && ind < sb.length(); j++){
                char ch = sb.charAt(ind);
                if(ch == '0'){
                    sb.insert(ind+1, '1');
                }else{
                    sb.insert(ind+1, '0');
                }
                ind+=2;
            }
            binaryValue = sb.toString();
        }
        System.out.println(binaryValue.charAt(k));
    }
}
