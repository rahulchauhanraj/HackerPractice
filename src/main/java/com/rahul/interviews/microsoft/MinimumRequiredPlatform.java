package com.rahul.interviews.microsoft;


import org.springframework.util.Assert;

import java.util.*;

public class MinimumRequiredPlatform {

    public static void main(String args[]){
        Integer[] a1 = {2200, 2300};
        Integer[] b1 = {200, 300};
        int count = findMinRequiredPlatform(a1, b1);
        Assert.isTrue(count == 2, "expected 2 but found " + count);

        Integer a2[] = {904, 946, 952, 1100, 1508, 1806};
        Integer b2[] = {915, 1202, 1128, 1135, 1900, 2001};
        count = findMinRequiredPlatform(a2, b2);
        Assert.isTrue(count == 3, "expected 3 but found " + count);

        Integer[] a3 = {2200, 2300};
        Integer[] b3 = {2300, 300};
        count = findMinRequiredPlatform(a3, b3);
        Assert.isTrue(count == 2, "expected 2 but found " + count);

        Integer[] a4 = {2200, 2300, 0};
        Integer[] b4 = {300, 0, 300};
        count = findMinRequiredPlatform(a4, b4);
        Assert.isTrue(count == 3, "expected 3 but found " + count);
    }


    /**
     * Time complexity (4*n + 4*n) + (n+n) -> O(n), where n is the number of trains.
     * Space complexity O(n)
     */
    private static int findMinRequiredPlatform(Integer[] arr, Integer[] dep) {
        int count = 0;

        int n = arr.length;

        List<Integer> l1 = new ArrayList<>(Arrays.asList(arr));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(dep));

        for(int i = 0; i< n; i++){
            if (dep[i] < arr[i]) {
                l2.set(i, 2399);
                l1.add(0);
                l2.add(dep[i]);
            }
        }

        sort(l1);
        sort(l2);

        n = l1.size();
        int max = 0;
        int i = 0;
        int j = 0;
        while(i < n || j < n) {
            if(i >= n) {
                count--;
                j++;
            }
            else if (i<n && j< n) {
                if (l1.get(i) <= l2.get(j)){
                    count++;
                    i++;
                } else {
                    count--;
                    j++;
                }
            }

            if(count > max){
                max = count;
            }
        }

        return max;
    }

    // Time complexity 4*n -> O(n), space complexity O(n);
    private static void sort(List<Integer> a) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int div = 1;
        int lastDiv;
        int count = 0;
        while(count < 4) {
            lastDiv = div;
            div *= 10;
            for (int i : a) {
                int v = (i % div)/lastDiv;
                if (map.containsKey(v)) {
                    map.get(v).add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(v, list);
                }
            }
            int ind = 0;
            for (int i = 0; i < 10; i++) {
                if (map.containsKey(i)) {
                    List<Integer> l = map.remove(i);
                    for (int v : l) {
                        a.set(ind, v);
                        ind++;
                    }
                }
            }
            count++;
        }
    }

}
