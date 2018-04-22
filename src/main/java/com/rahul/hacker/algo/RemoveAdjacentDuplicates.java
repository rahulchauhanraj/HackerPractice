package com.rahul.hacker.algo;

import java.util.Arrays;

public class RemoveAdjacentDuplicates {

    // This function recursively removes duplicates
// and returns modified string
    static char[] removeDup(char[] str, int n)
    {
        int len = str.length;
        int k = 0; // To store index of result

        // Start from second character and add
        // unique ones
        for (int i=1; i< len; i++)
        {
            // If different, increment k and add
            // previous character
            if (str[i-1] != str[i]) {
                str[k++] = str[i - 1];
            }
            else {
                // Keep skipping (removing) characters
                // while they are same.
                while (i < len && str[i - 1] == str[i]) {
                    i++;
                }
            }
        }

        // Add last character and terminator
        str[k++] = str[len-1];
        str[k] =  '\0';

        // Recur for string if there were some removed
        // character
        if (k != n) {
            removeDup(str, k);
        }// Shlemial Painter's Algorithm

            // If all characters were unique
        System.out.println(String.copyValueOf(str));
        System.out.println(String.copyValueOf(str).substring(0,k));
        return str;
    }

    public static void main(String[] s)
    {
        String str1 = "geeksforgeeg";
        System.out.println(removeDup(str1.toCharArray(), str1.length()));
    }
}
