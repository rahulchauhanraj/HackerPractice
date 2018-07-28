package com.rahul.oops.regex;

public class CountWords {
    public static void main(String[] args) {
        String s = "Hello! this is 1a line. It can't be hard to split into \"words\", can it?";
        String[] ss = s.split(" |\\.|!|\\?|'");
        int count = 0;
        for (String str : ss) {
            boolean match = str.matches("[a-zA-Z]+");
            if(match) {
                count++;
                System.out.println(str);
            }
        }
        System.out.println(count);
    }
}
