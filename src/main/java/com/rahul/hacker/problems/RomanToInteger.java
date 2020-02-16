package com.rahul.hacker.problems;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("CD"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int v = 0;

        for(int i = s.length()-1; i>=0; i--){

            char c = s.charAt(i);
            int val = m.get(c);

            if(i+1 < s.length()) {
                if (val < m.get(s.charAt(i+1))) {
                    v -= m.get(s.charAt(i));
                }else{
                    v += val;
                }
            }else {
                v += val;
            }

        }
        return v;
    }
}
