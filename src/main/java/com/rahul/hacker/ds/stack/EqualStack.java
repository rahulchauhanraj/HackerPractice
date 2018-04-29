package com.rahul.hacker.ds.stack;

public class EqualStack {

    public static void main(String[] a){
        int[] h1 = {2, 4, 3, 2};
        int[] h2 = {1, 2, 5, 3};
        int[] h3 = {2, 4, 2, 1};

        System.out.println(equalStacks(h1, h2, h3));
    }

    private static int equalStacks(int[] h1, int[] h2, int[] h3) {
        if(h1 == null || h1.length == 0 || h2 == null || h2.length == 0 || h3 == null || h3.length == 0) {
            return 0;
        }
        int s1 =0;
        int s2 =0;
        int s3 =0;

        for(int elm : h1) {
            s1 += elm;
        }
        for(int elm : h2) {
            s2 += elm;
        }
        for(int elm : h3) {
            s3 += elm;
        }

        int p1 =0;
        int p2 =0;
        int p3 =0;

        while(s1 != s2 || s2 != s3) {
            int id = 1;

            if(s2 > s1) {
                id = 2;
            }

            if(s3> s1){
                id = 3;
            }

            if(id == 1){
                s1 -= h1[p1++];
            } else if(id == 2){
                s2 -= h2[p2++];
            }else{
                s3 -= h3[p3++];
            }

        }

        return s1;
    }

}
