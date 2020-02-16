package com.rahul.hacker.problems;

public class IntegerPalindrome {

    public static void main(String[] args) {
        System.out.println(new IntegerPalindrome().isPalindrome(10001));
    }
    public boolean isPalindrome(int x) {

        if(x < 0){
            return false;
        }

        int n = x;
        int mul = 1;

        while(n >= 10) {
            n = n/10;
            mul *= 10;
        }

        while(x > 0) {
            int right = x%10;
            int left = x/mul;
            x = (x%mul)/10;

            if(left != right){
                return false;
            }

            mul /= 100;
        }

        return true;
    }
}
