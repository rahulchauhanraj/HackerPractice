package com.rahul.hacker.algo;

/**
 * We maintain a boolean table[n][n] that is filled in bottom up manner. The value of table[i][j] is true, if the substring is palindrome, otherwise false.
 * To calculate table[i][j], we first check the value of table[i+1][j-1], if the value is true and str[i] is same as str[j], then we make table[i][j] true.
 * Otherwise, the value of table[i][j] is made false.
 */
public class LongestPalindromeSubstring {

    static int longestPalSubstr(String str) {
        int maxLength = 1; // The result (length of LPS)

        int start = 0;
        int len = str.length();

        int low, high;

        // One by one consider every character as center
        // point of even and length palindromes
        for (int i = 1; i < len; i++)
        {
            // Find the longest even length palindrome with
            // center points as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length palindrome with
            // center point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        System.out.println("Longest palindrome substring is: " + str.substring(start, start + maxLength));
        return maxLength;
    }

    // Driver program to test above function
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        System.out.println("Length is: " + longestPalSubstr(str));
    }

}
