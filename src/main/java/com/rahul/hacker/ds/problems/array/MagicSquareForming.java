package com.rahul.hacker.ds.problems.array;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;

/**
 * Created by 212578960 on 6/29/2017.
 */
public class MagicSquareForming {
    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int [][][] setup = new int [][] []
                {
                        {
                                {8, 1, 6}, {3, 5, 7}, {4, 9, 2}
                        },
                        {
                                {6, 1, 8}, {7, 5, 3}, {2, 9, 4}
                        },
                        {
                                {4, 9, 2}, {3, 5, 7}, {8, 1, 6}
                        },
                        {
                                {2, 9, 4}, {7, 5, 3}, {6, 1, 8}
                        },
                        {
                                {8, 3, 4}, {1, 5, 9}, {6, 7, 2}
                        },
                        {
                                {4, 3, 8}, {9, 5, 1}, {2, 7, 6}
                        },
                        {
                                {6, 7, 2}, {1, 5, 9}, {8, 3, 4}
                        },
                        {
                                {2, 7, 6}, {9, 5, 1}, {4, 3, 8}
                        }
                };

        int[][] s = new int[3][3];
        int cost = Integer.MAX_VALUE;
        int sum = 0;
        for(int s_i=0; s_i < 3; s_i++){
            for(int s_j=0; s_j < 3; s_j++){
                int val = in.nextInt();
                s[s_i][s_j] = val;
                sum += val;
            }
        }

        for(int i = 0; i < setup.length; i++){
            sum = 0;
            for(int j = 0; j < s.length; j++){
                for(int k = 0; k < s[j].length; k++){
                    int left = s[j][k];
                    int right = setup[i][j][k];
                    if(left != right){
                        sum += Math.abs(left - right);
                    }
                }
            }

            if(sum < cost){
                cost = sum;
            }
        }

        System.out.println(cost);
        in.close();
    }
}
