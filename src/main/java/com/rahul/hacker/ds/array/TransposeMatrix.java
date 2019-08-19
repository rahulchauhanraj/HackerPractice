package com.rahul.hacker.ds.array;

import java.util.Arrays;

public class TransposeMatrix {

    public static void main(String[] args) {

        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] b = new TransposeMatrix().transpose(a);
        System.out.println(Arrays.toString(b));
    }

    public int[][] transpose(int[][] a) {
        int i = a.length;
        int j = a[0].length;

        int[][] b = new int[i][j];

        for (int p=0;p<i;p++){
            for(int q=0;q<j;q++){
                b[q][p] = a[p][q];
            }
        }

        return b;
    }
}
