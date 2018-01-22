package com.rahul.hacker.ds.problems.array;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;



public class EruptingVolcanoes {

    static class Node {
        int x;
        int y;
        int effect;

        Node(int x, int y, int effect){
            this.x = x;
            this.y = y;
            this.effect = effect;
        }
    }
    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        Node ar[][] = new Node[n][n];

        for(int i = 0; i<n; i++ ){
            for(int j =0; j< n; j++){
                ar[i][j] = new Node(i, j, 0);
            }
        }

        int m = in.nextInt();
        for(int a0 = 0; a0 < m; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int w = in.nextInt();
            updateEffect(ar, x, y, w);
        }

        int max = 0;
        for(int i = 0; i<n; i++ ){
            for(int j =0; j< n; j++){
                int effect = ar[i][j].effect;
                if(effect > max){
                    max = effect;
                }
            }
        }
        System.out.println(max);
        in.close();
    }

    private static void updateEffect(Node[][] ar, int x, int y, int w){
        int dis = 0;
        int nextW = w;
        while(nextW > 0) {
            if (nextW == w) {
                ar[x][y].effect+=w;
            } else {
                updateX(ar, x, y-dis, nextW, dis);
                updateX(ar, x, y+dis, nextW, dis);
                updateY(ar, x-dis, y, nextW, dis);
                updateY(ar, x+dis, y, nextW, dis);
                updateCorner(ar, x, y, nextW, dis);
            }
            dis++;
            nextW--;
        }
    }

    private static void updateX(Node[][] ar, int x, int y, int w, int dis){
        if(exists(ar, x, y)){
            ar[x][y].effect+=w;
            int curDis = dis;
            int ind = 1;
            while(curDis > 0){
                if(exists(ar,x-ind, y)){
                    ar[x-ind][y].effect+=w;
                }
                if(exists(ar,x+ind, y)){
                    ar[x+ind][y].effect+=w;
                }
                ind++;
                curDis--;
            }
        }
    }

    private static void updateY(Node[][] ar, int x, int y, int w, int dis){
        if(exists(ar, x, y)){
            ar[x][y].effect+=w;
            int curDis = dis;
            int ind = 1;
            while(curDis > 0){
                if(exists(ar,x, y-ind)){
                    ar[x][y-ind].effect+=w;
                }
                if(exists(ar,x, y+ind)){
                    ar[x][y+ind].effect+=w;
                }
                ind++;
                curDis--;
            }
        }
    }

    private static void updateCorner(Node[][] ar, int x, int y, int w, int dis){
        if(exists(ar, x+dis, y+dis)){
            ar[x+dis][y+dis].effect-=w;
        }
        if(exists(ar, x-dis, y-dis)){
            ar[x-dis][y-dis].effect-=w;
        }
        if(exists(ar, x+dis, y-dis)){
            ar[x+dis][y-dis].effect-=w;
        }
        if(exists(ar, x-dis, y+dis)){
            ar[x-dis][y+dis].effect-=w;
        }

    }

    private static boolean exists(Node[][] ar, int x, int y) {
        int arX = ar.length;
        int arY = ar[0].length;

        if((x >= 0 && x < arX) && (y >= 0 && y < arY)){
            return true;
        }

        return false;
    }
}


