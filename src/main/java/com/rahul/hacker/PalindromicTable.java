package com.rahul.hacker;

import com.rahul.hacker.util.ScannerUtil;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * Created by 212578960 on 6/16/2017.
 */
public class PalindromicTable {
    private static void beautifulRectangle(int[][] table, int x, int y){
        int maxArea = 1;
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        for(int l=0; l<x; l++){
            for(int m=0; m<y; m++){
                int x21 = l;
                int y21 = m;
                Set<Integer> remaining = new HashSet<>();
                remaining.add(table[l][m]);
                int[] ar = new int[]{0,0};

                while(true){
                    if(x21+1 < x){
                        Set<Integer> remainingDown = new HashSet<>(remaining);
                        int[] newAr = new int[2];
                        newAr[0] = ar[0];
                        newAr[1] = ar[1];
                        for(int i = x21+1; i< x; i++) {
                            for (int j = m; j <= y21; j++) {
                                int num = table[i][j];
                                addRemaining(newAr, remainingDown, num);
                            }

                            boolean palindrom = isPalindrom(newAr, remainingDown);

                            if(palindrom){
                                int area = calculateArea(newAr, remainingDown);
                                if(area > maxArea){
                                    maxArea = area;
                                    x1 = l;
                                    y1 = m;
                                    x2 = i;
                                    y2 = y21;
                                }
                            }
                        }
                    }
                    if(y21+1 < y) {
                        Set<Integer> remainingRight = new HashSet<>(remaining);
                        int[] newAr = new int[2];
                        newAr[0] = ar[0];
                        newAr[1] = ar[1];
                        for (int j = y21+1; j < y; j++) {
                            for(int i = l; i<= x21; i++) {
                                int num = table[i][j];
                                addRemaining(newAr, remainingRight, num);
                            }

                            boolean palindrom = isPalindrom(newAr, remainingRight);
                            if (palindrom) {
                                int area = calculateArea(newAr, remainingRight);
                                if (area > maxArea) {
                                    maxArea = area;
                                    x1 = l;
                                    y1 = m;
                                    x2 = x21;
                                    y2 = j;
                                }
                            }
                        }
                    }

                    if(x21+1 < x && y21+1 < y) {
                        x21++;
                        y21++;

                        for(int i = l; i< x21; i++){
                            int num = table[i][y21];
                            addRemaining(ar, remaining, num);
                        }

                        for(int i = m; i< y21; i++){
                            int num = table[x21][i];
                            addRemaining(ar, remaining, num);
                        }
                        int num = table[x21][y21];
                        addRemaining(ar, remaining, num);
                        boolean palindrom = isPalindrom(ar, remaining);
                        if (palindrom) {
                            int area = calculateArea(ar, remaining);
                            if (area > maxArea) {
                                maxArea = area;
                                x1 = l;
                                y1 = m;
                                x2 = x21;
                                y2 = y21;
                            }
                        }
                    }
                    else{
                        break;
                    }
                }

            }
        }

        System.out.println(maxArea);
        System.out.println("" + x1 + " " + y1 + " " + x2 + " " + y2);
    }

    private static void addRemaining(int[] ar, Set<Integer> remaining, int num){
        if(remaining.contains(num)){
            remaining.remove(num);
            if(num == 0){
                ar[0] += 1;
            }else{
                ar[1] += 1;
            }
        }else{
            remaining.add(num);
        }
    }

    private static boolean isPalindrom(int ar[], Set<Integer> remaining){
        int size = remaining.size();
        if(size > 1){
            return false;
        } else{
            if(ar[1] == 0 && ar[0] > 0){
                return false;
            }else{
                return true;
            }
        }
    }

    private static int calculateArea(int ar[], Set<Integer> remaining){
        return (ar[0] + ar[1])*2 + remaining.size();
    }

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int x = in.nextInt();
        int y = in.nextInt();
        int[][] table = new int[x][y];
        for(int table_i = 0; table_i < x; table_i++){
            for(int table_j = 0; table_j < y; table_j++){
                table[table_i][table_j] = in.nextInt();
            }
        }

        beautifulRectangle(table, x, y);

    }
}

