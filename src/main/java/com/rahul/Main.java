package com.rahul;

import com.rahul.hacker.util.ScannerUtil;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = ScannerUtil.getScanner();
        int ad = sc.nextInt();
        int am = sc.nextInt();
        int ay = sc.nextInt();

        int ed = sc.nextInt();
        int em = sc.nextInt();
        int ey = sc.nextInt();

        if(ay-ey > 0){
            System.out.print(10000);
        } else if(ay-ey < 0){
            System.out.print(0);
        } else if(am-em > 0){
            System.out.print(500 * (am-em));
        } else if(am-em < 0) {
            System.out.print(0);
        }else if(ad-ed > 0){
            System.out.print(15 * (ad-ed));
        } else {
            System.out.print(0);
        }

    }
}
