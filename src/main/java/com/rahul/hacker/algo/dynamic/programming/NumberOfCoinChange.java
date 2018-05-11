package com.rahul.hacker.algo.dynamic.programming;

import java.util.Arrays;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
 * The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6},
 * there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class NumberOfCoinChange {
    public static void main(String[] a) {
        int n = 4;
        int[] s = {1,2,3};
        //System.out.println(getChange(n, s));
        System.out.println(countWays(s, s.length, n));
    }


    // Time Complexity: O(mn)
    private static long countWays(int S[], int m, int n)
    {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n+1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];

        return table[n];
    }

    // Exponential complexity.
    private static int count( int S[], int m, int n )
    {
        // If n is 0 then there is 1 solution (do not include any coin).
        if (n == 0)
            return 1;

        // If n is less than 0 then no solution exists.
        if (n < 0)
            return 0;

        // If there are no coins and n is greater than 0, then no solution exist.
        if (m <= 0)
            return 0;

        // count is sum of solutions
        // (i) including S[m-1]
        // (ii) excluding S[m-1]
        return count(S, m - 1, n) + count(S, m, n-S[m-1]);
    }

    private static int getChange(int n, int[] s) {
        int count = 0;

        return count;
    }
}
