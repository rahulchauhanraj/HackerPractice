package com.rahul.hacker.ds.problems.array;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;

public class ThreeDSurfaceArea {
    static int surfaceArea(int[][] a) {
        int x = a.length;
        int y = a[0].length;
        int totalAr = 0;
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                int h = a[i][j];
                int ar = 2*(1 + h + h);
                if(j > 0) {
                    int leftH = a[i][j-1];
                    int cH = leftH < h ? leftH : h;
                    ar -= 2 * cH;
                }
                if(i > 0) {
                    int upH = a[i-1][j];
                    int cH = upH < h ? upH : h;
                    ar -= 2 * cH;
                }
                totalAr += ar;
            }
        }
        return totalAr;
    }

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int H = in.nextInt();
        int W = in.nextInt();
        int[][] A = new int[H][W];
        for(int A_i = 0; A_i < H; A_i++){
            for(int A_j = 0; A_j < W; A_j++){
                A[A_i][A_j] = in.nextInt();
            }
        }
        int result = surfaceArea(A);
        System.out.println(result);
        in.close();
    }
}
