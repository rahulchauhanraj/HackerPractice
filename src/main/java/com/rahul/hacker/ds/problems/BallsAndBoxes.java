package com.rahul.hacker.ds.problems;

import java.util.Scanner;

/**
 * Created by 212578960 on 5/20/2017.
 */
public class BallsAndBoxes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] A = new int[n];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int[] C = new int[m];
        for(int C_i=0; C_i < m; C_i++){
            C[C_i] = in.nextInt();
        }
        int[][] B = new int[n][m];
        for(int B_i=0; B_i < n; B_i++){
            for(int B_j=0; B_j < m; B_j++){
                B[B_i][B_j] = in.nextInt();
            }
        }
        int val = getMaxEarnedCandies(n, m, A, C, B);
        System.out.print(val);
    }

    static int getMaxEarnedCandies(int n, int m, int[] a, int[] c, int[][] b) {
        int max = 0;
        
        return max;
    }
}
