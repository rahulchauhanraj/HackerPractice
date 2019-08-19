package com.rahul.hacker.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] a, int k) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(a);
        int l = a.length;

        for (int i =0; i<l; i++){
            combinationSum(a, l, k, res, 0, i, new ArrayList<>());
        }

        return res;
    }

    private void combinationSum(int[] a, int l, int k, List<List<Integer>> res, int sumSoFar, int i, List<Integer> comb) {

        if (sumSoFar + a[i] > k){
            return;
        }

        if (sumSoFar + a[i] == k){
            List<Integer> combination = new ArrayList<>(comb);
            combination.add(a[i]);
            res.add(combination);
            return;
        } else {
            comb.add(a[i]);
            combinationSum(a, l, k, res, sumSoFar + a[i], i, comb);
            comb.remove(comb.size()-1);
        }

        if(comb.isEmpty()) {
            return;
        }

        i++;
        if(i < l) {
            combinationSum(a, l, k, res, sumSoFar, i, comb);
        }
    }

    public static void main(String[] args) {

        int[] a = {2,3,6,7};
        int k = 10;
        List<List<Integer>> res = new CombinationSum().combinationSum(a, k);
        System.out.println(res);
    }

}
