package com.rahul.hacker.algo.dynamic.programming;

import java.util.Arrays;

/**
 * Longest Increasing Sub-Sequence (LIS) problem can be solved using Dynamic Programming.
 * The Longest Increasing Sub-Sequence (LIS) problem is to find the length of the longest sub-sequence of a given sequence such that all elements of the
 * sub-sequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * Solution with O(n*n) complexity.
 */
public class LongestIncreasingSubSequence {

    static int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int lis[] = new int[n];
        int i,j,max = 0;

        Arrays.fill(lis, 1);

        for ( i = 1; i < n; i++ ) {
            for ( j = 0; j < i; j++ ) {
                if ( arr[i] > arr[j] && lis[i] < lis[j] + 1){
                    lis[i] = lis[j] + 1;
                }
            }
        }

        /* Pick maximum of all LIS values */
        for ( i = 0; i < n; i++ )
            if ( max < lis[i] )
                max = lis[i];

        return max;
    }


    private static int lis(int a[])
    {
        int maxVal = 0;
        int n = a.length;
        int lcs[] = new int[n];
        Arrays.fill(lcs, 1);
        for (int i = n-2; i >= 0; i--) {
            int max = 1;
            for (int j = i+1; j < n; j++) {
                if (a[j] > a[i] ) {
                    int newLcs = lcs[j] + 1;
                    if(newLcs > max) {
                        max = newLcs;
                        if(maxVal < max) {
                            maxVal = max;
                        }
                    }
                }
            }
            lcs[i] = max;
        }

        return maxVal;
    }

    static int LongestIncreasingSubsequenceLength(int A[])
    {
        // Add boundary case, when array size is one
        int size = A.length;
        int[] tailTable   = new int[size];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];

            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[ceilIndex(tailTable, 0, len-1, A[i])] = A[i];
        }

        return len;
    }

    // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    private static int ceilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 0)
        {
            int m = l + (r - l)/2;

            if(A[m] == key) {
                return m;
            }else if(A[m] < key && A[m+1] >= key) {
                return m+1;
            }

            if (A[m] > key) {
                r = m;
            } else {
                l = m;
            }
        }

        return r;
    }

    public static void main(String args[])
    {
        int[] arr = {10, 20, 15, 19, 21, 50, 5, 41, 20, 80};
        //int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        //int arr[] = { 2, 5, 3, 10, 6, 8};
        System.out.println("Length of lis is " + lis( arr) );
        System.out.println("Length of lis is " + longestIncreasingSubsequence( arr) );
        System.out.println("Length of lis is " + LongestIncreasingSubsequenceLength( arr) );
    }
}
