package com.rahul.hacker.problems;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(Integer.MAX_VALUE));
    }

    public int reverse(int x) {

        String s1 = String.valueOf(x);

        String rev;
        if(s1.charAt(0) == '-'){
            rev = "-" + reverse(s1.substring(1));
        }else {
            rev = reverse(s1);
        }

        int v = 0;

        try{
            v = Integer.valueOf(rev);
        } catch (NumberFormatException e){
            return v;
        }

        return v;
    }

    private String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
}
