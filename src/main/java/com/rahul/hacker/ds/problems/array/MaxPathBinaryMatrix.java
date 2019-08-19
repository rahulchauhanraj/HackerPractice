package com.rahul.hacker.ds.problems.array;

import java.util.HashSet;
import java.util.Set;

class MaxPathBinaryMatrix {

    public static void main (String arg[]) {
        MaxPathBinaryMatrix matrix = new MaxPathBinaryMatrix();

        int[][] grid = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};

        int value = matrix.shortestPathBinaryMatrix(grid);
        System.out.println(value);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        Set<String> traversed = new HashSet<>();
        
        int r = grid.length;
        int c = grid[0].length;
        
        int maxPath = -1;
        
        for (int i = 0; i<r; i++) {
            for (int j=0; j<c; j++) {
                int path = getPath(traversed, grid, i, j);
                
                if (path != 0 && path > maxPath) {
                    maxPath = path;
                }
            }
        }
        
        return maxPath;
    }
    
    private int getPath(Set<String> traversed, int[][] grid, int r, int c) {
        String key = r + "-" + c;
        if (traversed.contains(key) || grid[r][c] == 0) {
            return 0;
        }
        traversed.add(r + "-" + c);
        
        int count = 1;
        
        if (isValidPath(grid, r-1, c-1)) {
            count += getPath(traversed, grid, r-1, c-1);
        }
        if (isValidPath(grid, r, c-1)) {
            count += getPath(traversed, grid, r, c-1);
        }
        if (isValidPath(grid, r+1, c-1)) {
            count += getPath(traversed, grid, r+1, c-1);
        }
        if (isValidPath(grid, r-1, c)) {
            count += getPath(traversed, grid, r-1, c);
        }
        if (isValidPath(grid, r+1, c)) {
            count += getPath(traversed, grid, r+1, c);
        }
        if (isValidPath(grid, r-1, c+1)) {
            count += getPath(traversed, grid, r-1, c+1);
        }
        if (isValidPath(grid, r, c+1)) {
            count += getPath(traversed, grid, r, c+1);
        }
        if (isValidPath(grid, r+1, c+1)) {
            count += getPath(traversed, grid, r+1, c+1);
        }
        
        return count;
    }
    
    private boolean isValidPath(int[][] grid, int r, int c) {
        return (r<grid.length && r>=0 && c<grid[0].length && c>=0);
    }
}
