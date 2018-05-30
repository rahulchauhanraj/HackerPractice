package com.rahul.hacker.ds.graph;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;

public class DFSConnectedCellInAGrid {
    private static final Scanner scanner = ScannerUtil.getScanner();

    private static class Node {
        int value;
        boolean visited;
        Node(int v){
            value = v;
        }
    }
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Node[][] grid = new Node[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                Node gridItem = new Node(Integer.parseInt(gridRowItems[j]));
                grid[i][j] = gridItem;
            }
        }
        int largestRegion = largestRegion(grid, n, m);
        System.out.println(largestRegion);
        scanner.close();
    }

    private static int largestRegion(Node[][] a, int m, int n){
        int max = 0;
        for(int i = 0; i<m; i++){
            for(int j =0; j<n; j++){
                int[] count = {0};
                calculateLargestRegion(a, m, n, i, j, count);
                max = count[0] > max ? count[0] : max;
            }
        }
        return max;
    }

    private static void calculateLargestRegion(Node[][] a, int m, int n, int i, int j, int[] count){
        Node node = a[i][j];
        if(node.visited) {
            return;
        }
        if(node.value == 1) {
            count[0]++;
        }
        node.visited = true;

        for(int p = i-1; p<= i+1; p++){
            int r = p;
            int c = j-1;

            if(isValidIndex(m, n, r, c)){
                Node adj = a[r][c];
                if(!adj.visited && adj.value == 1){
                    calculateLargestRegion(a, m, n, r, c, count);
                }
            }
        }

        for(int p = i-1; p<= i+1; p++){
            int r = p;
            int c = j+1;

            if(isValidIndex(m, n, r, c)){
                Node adj = a[r][c];
                if(!adj.visited && adj.value == 1){
                    calculateLargestRegion(a, m, n, r, c, count);
                }
            }
        }

        int r = i-1;
        int c = j;
        if(isValidIndex(m, n, r, c)){
            Node adj = a[r][c];
            if(!adj.visited && adj.value == 1){
                calculateLargestRegion(a, m, n, r, c, count);
            }
        }

        r = i+1;
        if(isValidIndex(m, n, r, c)){
            Node adj = a[r][c];
            if(!adj.visited && adj.value == 1){
                calculateLargestRegion(a, m, n, r, c, count);
            }
        }

        if(isValidIndex(m, n, r, c)){
            Node adj = a[r][c];
            if(!adj.visited && adj.value == 1){
                calculateLargestRegion(a, m, n, r, c, count);
            }
        }
    }

    private static boolean isValidIndex(int m, int n, int i, int j){
        if(i>=0 && i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }
}
