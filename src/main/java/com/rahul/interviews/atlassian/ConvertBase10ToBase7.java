package com.rahul.interviews.atlassian;

public class ConvertBase10ToBase7 {

    public static void main(String[] args){
        char[] a = {'0', 'a', 't', 'l', 's', 'i', 'n'};
        String s = convert("7792875", 10, 7);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            sb.append(a[Integer.parseInt("" + s.charAt(i))]);
        }
        System.out.println(sb);
    }

    private static String convert(String number, int base1, int base2) {
        return Integer.toString(Integer.parseInt(number, base1), base2);
    }
}
