package com.rahul.hacker.ds.dynamicProgramming;

/**
 * Longest Increasing Sub-Sequence (LIS) problem can be solved using Dynamic Programming.
 * The Longest Increasing Sub-Sequence (LIS) problem is to find the length of the longest sub-sequence of a given sequence such that all elements of the
 * sub-sequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * Solution with O(n*n) complexity.
 */
public class LongestIncreasingSubSequence {

    private static int lis(int a[],int n)
    {
        int maxVal = 0;

        int lcs[] = new int[a.length];

        // For each element in the array from right side, search for all other elements in the right which are greater and select the max value from lcs.
        // Update the current element value in lcs with adding 1 in the max value.
        for (int i = a.length-1; i >= 0; i--) {
            int max = 0;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] > a[i] && lcs[j] > max) {
                    max = lcs[j];
                }
            }
            lcs[i] = max+1;
        }

        for (int i =  0; i < a.length; i++){
            if (maxVal < lcs[i]) {
                maxVal = lcs[i];
            }
        }
        return maxVal;
    }

    public static void main(String args[])
    {
        //int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int arr[] = { 2, 5, 3, 10, 6, 8};
        int n = arr.length;
        System.out.println("Length of lis is " + lis( arr, n ) );
    }
}
