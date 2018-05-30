package com.rahul.hacker.algo.dynamic.programming;

import java.util.Scanner;

/**
 * Davis has s staircases in his house and he likes to climb each staircase 1,2 or 3 steps at a time. Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.
 Given the respective heights for each of the s staircases in his house, find and print the number of ways he can climb each staircase on a new line.

 Input Format
 The first line contains a single integer,s, denoting the number of staircases in his house.
 Each line i of the s subsequent lines contains a single integer,n, denoting the height of staircase i.

 Constraints
 •	1<=s<=5
 •	1<=n<=36

 Output Format
 For each staircase, print the number of ways Davis can climb it in a new line.

 Sample Input
 3
 1
 3
 7

 Sample Output
 1
 4
 44

 Explanation
 Let's calculate the number of ways of climbing the first two of the Davis' s=3 staircases:
 1.	The first staircase only has n=1 step, so there is only one way for him to climb it (i.e., by jumping 1  step). Thus, we print 1 on a new line.
 2.	The second staircase has n=3 steps and he can climb it in any of the four following ways:

 1.	1->1>1
 2.	1->2
 3.	2->1
 4.	3

 Thus, we print 4 on a new line.
 */
public class ClimbStaircases {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int noOfWays = findNumberOfWays(n);
            System.out.println(noOfWays);
        }
        in.close();
    }

    private static int findNumberOfWays(int n){
        if(n < 1) {
            return 0;
        }else if(n < 3){
            return n;
        }

        int[] a = new int[n+1];
        a[0] = 1;
        a[1] = 1;
        a[2] = 2;

        for(int i = 3; i<=n; i++){
            a[i] = a[i-1] + a[i-2] + a[i-3];
        }

        return a[n];
    }
}
