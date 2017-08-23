package com.rahul.hacker.ds.problems;

import com.rahul.hacker.util.ScannerUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 212578960 on 6/16/2017.
 */
public class TransformToPalindrome {
    private static Map<Integer, Set<Integer>> transformations = new HashMap<>();

    private static void addTransformation(int a, int b){
        add(a,b);
        add(b,a);
    }

    private static void add(int a, int b){
        if(transformations.containsKey(a)){
            transformations.get(a).add(b);
        }else{
            Set<Integer> set = new HashSet();
            set.add(b);
            transformations.put(a, set);
        }
    }

    private static void updateTransformations(Set<Integer> visited, int a, Set<Integer> transformation){
        if(visited.contains(a)){
            return;
        }
        visited.add(a);
        Set<Integer> values = transformations.get(a);
        for(Integer val : values){
            transformation.add(val);
            updateTransformations(visited, val, transformation);
        }
    }

    private static void updateTransformations(){
        Set<Integer> visited = new HashSet<>();

        for(Integer key : transformations.keySet()){
            Set<Integer> transformation = new HashSet<>();
            updateTransformations(visited, key, transformation);
            if (!transformation.isEmpty()){
                for(Integer val : transformation){
                    Set<Integer> tOld = transformations.get(val);
                    tOld.addAll(transformation);
                    tOld.remove(val);
                }
            }
        }
    }

    static int longestPossiblePalindrom(int[] seq)
    {
        int n = seq.length;
        int i, j, cl;
        int L[][] = new int[n][n];

        for (i = 0; i < n; i++)
            L[i][i] = 1;

        for (cl=2; cl<=n; cl++)
        {
            for (i=0; i<n-cl+1; i++)
            {
                j = i+cl-1;
                boolean transformable = isTransformable(seq[i], seq[j]);
                if (transformable && cl == 2)
                    L[i][j] = 2;
                else if (transformable)
                    L[i][j] = L[i+1][j-1] + 2;
                else
                    L[i][j] = max(L[i][j-1], L[i+1][j]);
            }
        }

        return L[0][n-1];
    }

    static int max (int x, int y) { return (x > y)? x : y; }

    private static boolean isTransformable(int x, int y){
        if(x == y){
            return true;
        }
        Set<Integer> set = transformations.get(x);
        if(set != null && set.contains(y)){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();
        for(int a0 = 0; a0 < k; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            addTransformation(x, y);
        }
        int[] a = new int[m];
        for(int a_i=0; a_i < m; a_i++){
            a[a_i] = in.nextInt();
        }

        updateTransformations();
        System.out.println(longestPossiblePalindrom(a));
    }
}
