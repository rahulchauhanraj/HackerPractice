package com.rahul.hacker.ds.problems.string;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;

public class SmallStepTowardCalculators {
    static int solve(String opr) {
        int a = Integer.parseInt("" + opr.charAt(0));
        char ch = opr.charAt(1);
        int b = Integer.parseInt("" + opr.charAt(2));

        switch(ch){
            case '+' :
                return a + b;
            case '-' :
                return a - b;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        String opr = in.next();
        int result = solve(opr);
        System.out.println(result);
        in.close();
    }
}
