package com.rahul.hacker.problems;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] s) {

       String s1 = "Hello this is Rahul";

        System.out.println(reverse(s1));

    }

    private static char[] reverse (String s) {

        char[] c = s.toCharArray();

        for (int i=0; i<c.length/2; i++) {
            char t = c[i];
            int b = c.length - i -1;
            c[i] = c[b];
            c[b] = t;
        }

        return c;
    }
}
