package com.rahul.hacker.ds.array;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {

    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        int count = 0;
        int len = a.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                map.merge(a[i] + b[j], 1, Integer::sum);
            }
        }

        for (int k = 0; k < len; k++) {
            for (int l = 0; l < len; l++) {
                int desiredSum = -(c[k] + d[l]);
                if (map.containsKey(desiredSum)) {
                    count += map.get(desiredSum);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] a = {0,1,-1};
        int[] b = {-1,1,0};
        int[] c = {0,0,1};
        int[] d = {-1,1,1};

        int res = new FourSumCount().fourSumCount(a,b,c,d);
        System.out.println(res);

    }

}
