package com.rahul.interviews.atlassian;

import java.util.ArrayList;

public class ConvertBase10ToBase7 {

    public static void main(String[] args){
        Long l = 7792875L;
        System.out.println(convert(l));
        System.out.println(convert1(l));
    }

    static String convert1(Long l){
        char[] a = {'0', 'a', 't', 'l', 's', 'i', 'n'};
        String s = Long.toString(Long.parseLong(l.toString(), 10), 7);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            sb.append(a[Integer.parseInt("" + s.charAt(i))]);
        }
        return sb.toString();
    }


    static String convert(long input) {
        char[] c = {'0', 'a', 't', 'l', 's', 'i', 'n'};
        ArrayList<Long> list = new ArrayList<>();

        while(input>0){
            long d = input % 7;
            list.add(d);
            input /= 7;
        }

        if(list.isEmpty()){
            list.add(0L);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = list.size() -1; i>=0; i--){
            sb.append(c[list.get(i).intValue()]);
        }
        return sb.toString();
    }
}
