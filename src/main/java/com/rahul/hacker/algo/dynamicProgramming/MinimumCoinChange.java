package com.rahul.hacker.algo.dynamicProgramming;

/**
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?

 Examples:

 Input: coins[] = {25, 10, 5}, V = 30
 Output: Minimum 2 coins required
 We can use one coin of 25 cents and one of 5 cents

 Input: coins[] = {9, 6, 5, 1}, V = 11
 Output: Minimum 2 coins required
 We can use one coin of 6 cents and 1 coin of 5 cents
 */
public class MinimumCoinChange {

    public static void main(String[] a) {
        int n = 4;
        int[] s = {1,2,3};
        //System.out.println(getChange(n, s));
        System.out.println(minCoins(s, s.length, n));
    }

    // Time Complexity: O(mn)
    static int minCoins(int coins[], int m, int V)
    {
        // table[i] will be storing
        // the minimum number of coins
        // required for i value. So
        // table[V] will have result
        int table[] = new int[V + 1];

        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= V; i++) {
            table[i] = Integer.MAX_VALUE;
        }

        // Compute minimum coins required for all
        // values from 1 to V
        for (int i = 1; i <= V; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++)
                if (coins[j] <= i)
                {
                    int subResult = table[i - coins[j]];
                    int thisResult = subResult + 1;

                    if (thisResult < table[i]) {
                        table[i] = thisResult;
                    }
                }

        }
        return table[V];

    }

}
