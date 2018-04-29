package com.rahul.hacker.algo.dynamicProgramming;

/**
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has
 * the largest sum. {-2, -3, 4, -1, -2, 1, 5, -3} Maximum contiguous sum is : sum of (4, -1, -2, 1, 5) == 7
 */
public class MaximumValueContiguousSubsequence {

    public static void main(String[] a) {
        //int[] ar = {-2, 11, -4, 13, -5, 2};
        int[] ar = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(findMaximumValueContiguousSubsequence(ar));
    }

    private static int findMaximumValueContiguousSubsequence(int[] a) {
        int maxSum = Integer.MIN_VALUE;
        int l = a.length;
        int p = 0;

        int currentSum = 0;

        while(p < l) {

            currentSum += a[p];
            if(currentSum > maxSum) {
                maxSum = currentSum;
            }

            if(currentSum < 0) {
                currentSum = 0;
            }
            p++;
        }

        return maxSum;
    }
}
