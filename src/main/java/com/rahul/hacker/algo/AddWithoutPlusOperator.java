package com.rahul.hacker.algo;

public class AddWithoutPlusOperator {
    public static int addIterative(int a, int b){
        while (b != 0){
            int carry = (a & b) ; //CARRY is AND of two bits

            a = a ^b; //SUM of two bits is A XOR B

            b = carry << 1; //shifts carry to 1 bit to calculate sum
        }
        return a;
    }

    public static void main(String[] args) {


        int a = 10;
        int b = 15;
        int res = new AddWithoutPlusOperator().addIterative(a, b);
        System.out.println(res);
    }
}
