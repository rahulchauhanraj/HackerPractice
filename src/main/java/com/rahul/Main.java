package com.rahul;

public class Main {


    public static void main(String[] a){
        int s1 = 3;
        int s2 = 3;
        int s3 = 4;
        int max = s1;

        if(s2 > s1) {
            max = s2;
        }

        if(s3> s1){
            max = s3;
        }
        System.out.println(max);
    }
}
