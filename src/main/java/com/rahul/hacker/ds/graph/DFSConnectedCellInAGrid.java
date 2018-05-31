package com.rahul.hacker.ds.graph;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;

/**
 * Consider a matrix with  rows and  columns, where each cell contains either a  or a  and any cell containing a is called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally; in other words, cell  is connected to cells , , , , , , , and , provided that the location exists in the matrix for that .

 If one or more filled cells are also connected, they form a region. Note that each cell in a region is connected to at least one other cell in the region but is not necessarily directly connected to all the other cells in the region.

 Task
 Given an  matrix, find and print the number of cells in the largest region in the matrix. Note that there may be more than one region in the matrix.

 Input Format

 The first line contains an integer, , denoting the number of rows in the matrix.
 The second line contains an integer, , denoting the number of columns in the matrix.
 Each line  of the  subsequent lines contains  space-separated integers describing the respective values filling each row in the matrix.

 Constraints

 Output Format

 Print the number of cells in the largest region in the given matrix.

 Sample Input

 4
 4
 1 1 0 0
 0 1 1 0
 0 0 1 0
 1 0 0 0
 Sample Output

 5
 Explanation

 The diagram below depicts two regions of the matrix; for each region, the component cells forming the region are marked with an X:

 X X 0 0     1 1 0 0
 0 X X 0     0 1 1 0
 0 0 X 0     0 0 1 0
 1 0 0 0     X 0 0 0
 The first region has five cells and the second region has one cell. Because we want to print the number of cells in the largest region of the matrix, we print .
 */
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
