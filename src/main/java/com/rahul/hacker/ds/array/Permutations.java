package com.rahul.hacker.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static void main(String[] args) {

        int[] a = {2,3,6,7};
        List<List<Integer>> res = new Permutations().permute(a);
        System.out.println(res);
    }

    public List<List<Integer>> permute(int[] n) {
        int l = n.length;
        List<List<Integer>> res = new ArrayList<>();
        int[] p = new int[l];
        int[] c = new int[l];
        Arrays.fill(c, 1);

        permutations(n, p, c, l, 0, res);

        return res;
    }


    private void permutations(int[] n, int[] p, int[] c, int l, int depth, List<List<Integer>> res) {

        if(depth == l) {
            res.add(Arrays.stream(p).boxed().collect(Collectors.toList()));
            return;
        }

        for(int i = 0; i< n.length; i++) {

            if(c[i] != 0) {
                p[depth] = n[i];
                c[i]--;
                permutations(n, p , c, l, depth+1, res);
                c[i]++;
            }
        }

    }
}
