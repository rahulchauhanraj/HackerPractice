package com.rahul.hacker.ds.array;

import org.springframework.util.Assert;

public class SearchInRotatedSortedArray {
    public int search(int[] n, int k) {
        int v =  findPivot(n, 0, n.length-1);

        System.out.println(v);
        int r = -1;

        if(k == n[v]) {
            return v;
        }

        if (k <= n[v] && k >= n[0]) {
            r = binarySearch(n, 0, v, k);
        }else if(v < n.length - 1) {
            r = binarySearch(n, v+1, n.length-1, k);
        }

        return r;
    }


    private int binarySearch(int[] a, int i, int j, int k) {

        if(i == j) {
            if (a[i] == k) {
                return i;
            } else {
                return -1;
            }
        }else if(i+1 == j){
            if (a[i] == k) {
                return i;
            } else if (a[j] == k) {
                return j;
            }else {
                return -1;
            }
        }

        int m = i + (j-i)/2;

        if(a[m] == k){
            return m;
        }

        if(a[m] > k) {
            return binarySearch(a, i, m-1, k);
        } else {
            return binarySearch(a, m+1, j, k);
        }
    }

    private int findPivot(int[] a, int i, int j) {

        if (i == j) {
            return i;
        }else if(i+1 == j) {

            if(a[i] > a[0] && a[j] > a[0]){
                return j;
            } else if(a[i] < a[0] && a[j] < a[0]) {
                return i;
            }else {
                return a[i] > a[j] ? i : j;
            }
        }

        int m = i + (j-i)/2;

        if(a[m] > a[m+1] && a[m] > a[m-1]) {
            return m;
        }

        if(a[m] < a[i]) {
            return findPivot(a, i, m-1);
        } else {
            return findPivot(a, m+1, j);
        }
    }

    public static void main(String[] args) {

        SearchInRotatedSortedArray searchInArray = new SearchInRotatedSortedArray();
        searchInArray.test(new int[]{1,2,3,4,5}, 1, 2);
        searchInArray.test(new int[]{6,2,3,4,5}, -1, 1);
        searchInArray.test(new int[]{3,4,5,1,2}, -1, 6);
        searchInArray.test(new int[]{2,3,4,5,1}, 4, 1);
        searchInArray.test(new int[]{6,7,1,2,3,4,5}, 1, 7);
        searchInArray.test(new int[]{3,4,5,1,2}, 0,3);
        searchInArray.test(new int[]{5,1,2}, -1,0);
    }

    private void test (int[] a, int ind, int k) {
        int v = this.search(a, k);
        Assert.isTrue(ind == v);
    }

}
