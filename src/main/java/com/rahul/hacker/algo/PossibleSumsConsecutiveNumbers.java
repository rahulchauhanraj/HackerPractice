package com.rahul.hacker.algo;

/**
 *  One important fact is we can not find consecutive numbers above N/2 that adds up to N, because N/2 + (N/2 + 1) would be more than N.
 *  So we start from start = 1 till end = N/2 and check for every consecutive sequence whether it adds up to N or not.
 *  If it is then we print that sequence and start looking for the next sequence by incrementing start point.
 *  Just keep track of the sum you have so far and adjusting it depending on how it compares to the desired sum.
 */
public class PossibleSumsConsecutiveNumbers {

    public static void main(String[] args)
    {
        printSums(15);
    }

    private static void printSums(int n)
    {
        int start = 1;
        int end = 1;
        int sum = 1;

        while (start <= n/2)
        {
            if (sum < n)
            {
                end += 1;
                sum += end;
            }
            else if (sum > n)
            {
                sum -= start;
                start += 1;
            }
            else
            {
                for (int i = start; i <= end; ++i) {
                    System.out.print(i + " ");
                }

                System.out.println();
                sum -= start;
                start += 1;
            }
        }
    }
}
