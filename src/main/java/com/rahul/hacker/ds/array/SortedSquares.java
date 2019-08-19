package com.rahul.hacker.ds.array;

import java.util.Arrays;

public class SortedSquares {

    public static void main (String args[]) {
        int[] a = {-7,-3,2,3,11};
        int[] b = new SortedSquares().sortedSquares(a);
        System.out.println(Arrays.toString(b));
    }


    public int[] sortedSquares(int[] a) {

        int[] b = new int[a.length];

        int i = 0;
        int j = a.length -1;
        int k = b.length -1;

        while(i<=j){
            if(Math.abs(a[i]) > Math.abs(a[j])) {
                b[k] = a[i] * a[i];
                i++;
            }else {
                b[k] = a[j] * a[j];
                j--;
            }
            k--;
        }

        return b;
    }
}
