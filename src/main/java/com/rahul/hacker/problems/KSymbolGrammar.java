package com.rahul.hacker.problems;

import java.util.Collections;
import java.util.List;

public class KSymbolGrammar {


    public static void main(String[] args) {
        System.out.println(kthGrammar(2, 2));
    }

    public static int kthGrammar(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");

        "sjshkc".substring(1,3);



        for (int i=1; i<n; i++) {

            for (int j=0; j<sb.length(); j = j+2) {

                if (sb.charAt(j) == '0') {
                    sb.insert(j+1, '1');
                } else {
                    sb.insert(j+1, '0');
                }
            }
            System.out.println(sb);
        }

        return Integer.parseInt(String.valueOf(sb.charAt(k-1)));
    }

}
