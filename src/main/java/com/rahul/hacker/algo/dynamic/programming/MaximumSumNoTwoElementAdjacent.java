package com.rahul.hacker.algo.dynamic.programming;

/**
 * Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array.
 * So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.
 */
public class MaximumSumNoTwoElementAdjacent {

    public static void main(String[] a) {
        int[] ar = {1, 20, 3};
        System.out.println(findMaximumSumNoTwoElementAdjacent(ar));
    }

    private static int findMaximumSumNoTwoElementAdjacent(int[] a) {
        int l = a.length;
        int[] maxSums = new int[l];

        if(l == 1) {
            return a[0];
        }

        if(l == 2){
            return Math.max(a[0], a[1]);
        }

        maxSums[0] = a[0];
        maxSums[1] = Math.max(a[0], a[1]);

        int p = 2;
        while(p < l){
            maxSums[p] = Math.max(a[p] + maxSums[p-2], maxSums[p-1]);
            p++;
        }

        return maxSums[l-1];
    }
}
