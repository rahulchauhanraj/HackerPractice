package com.rahul.hacker.ds.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallest {

    public static void main(String[] args) {

        int[][] a = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;

        int v = new Solution().kthSmallest(a, k);
        System.out.println(v);
    }
}


class Solution {
    public int kthSmallest(int[][] m, int k) {

        int n = m.length;

        PriorityQueue<Integer> q = new PriorityQueue<>(n);

        int i = 0;

        List<Integer> l = new ArrayList<>();

        while(i<n){

            int v = m[i][i];

            if(q.size()==n){
                l.add(q.poll());
            }
            q.add(v);

            if(l.size() == k){
                return l.get(k-1);
            }

            for(int x = i+1; x < n; x++){
                v = m[x][i];

                if(q.size()==n){
                    l.add(q.poll());
                }
                q.add(v);

                if(l.size() == k){
                    return l.get(k-1);
                }
            }

            for(int y = i+1; y < n; y++){
                v = m[i][y];
                if(q.size()==n){
                    l.add(q.poll());
                }
                q.add(v);

                if(l.size() == k){
                    return l.get(k-1);
                }
            }

            i++;
        }

        while(l.size()<k){
            l.add(q.poll());
        }
        System.out.println(l);
        return l.get(k-1);
    }
}
