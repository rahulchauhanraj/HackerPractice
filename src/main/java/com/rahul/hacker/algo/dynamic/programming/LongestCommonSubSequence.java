package com.rahul.hacker.algo.dynamic.programming;

import java.util.Arrays;

//  Java implementation of finding length of longest
// Common substring using Dynamic Programming
public class LongestCommonSubSequence
{
    /*
       Returns length of longest common substring
       of X[0..m-1] and Y[0..n-1]
    */
    private static int LCSubStr(char X[], char Y[], int m, int n)
    {
        // Create a table to store lengths of longest common suffixes of
        // substrings. Note that LCSuff[i][j] contains length of longest
        // common suffix of X[0..i-1] and Y[0..j-1]. The first row and
        // first column entries have no logical meaning, they are used only
        // for simplicity of program
        int LCStuff[][] = new int[m + 1][n + 1];
        int result = 0;  // To store length of the longest common substring
        int lastIndex = 0;
        // Following steps build LCSuff[m+1][n+1] in bottom up fashion
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i == 0 || j == 0) {
                    LCStuff[i][j] = 0;
                } else if (X[i - 1] == Y[j - 1]) {
                    LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
                    if(LCStuff[i][j] > result){
                        result = LCStuff[i][j];
                        lastIndex = j;
                    }
                } else {
                    LCStuff[i][j] = 0;
                }
            }
        }
        int start = lastIndex-result;
        int end = lastIndex;
        System.out.print("LCS String : ");

        for(int i = start; i< end; i++){
            System.out.print(Y[i]);
        }
        System.out.println();
        return result;
    }

    // Driver Program to test above function
    public static void main(String[] args)
    {
        String X = "OldSite:GeeksforGeeks.com";
        String Y = "NewSite:GeeksQuiz.com";

        int m = X.length();
        int n = Y.length();

        System.out.println("Length of Longest Common Substring is " + LCSubStr(X.toCharArray(), Y.toCharArray(), m, n));
    }
}
