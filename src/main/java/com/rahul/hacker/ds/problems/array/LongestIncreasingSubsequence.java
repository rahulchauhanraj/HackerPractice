package com.rahul.hacker.ds.problems.array;

public class LongestIncreasingSubsequence {

    private static int lis(int a[],int n)
    {
        int maxVal = 0;

        int lcs[] = new int[a.length];

        for (int i = a.length-1; i >= 0; i--){
            int max = 0;
            for (int j = i+1; j < a.length; j++){
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
