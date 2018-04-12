package com.rahul.hacker.ds.searching;

public class BitonicSearch {

    public static void main (String args[]) {
        int[] a = {15, 16, 19, 20, 21, 22, 25, 24, 17, 8, 5, 4, 2};
        int index = search(a, 7);
        System.out.println(index);
    }

    private static int search(int[] a, int data) {
        return findPivot(a, data, 0, a.length-1);
    }

    private static int findPivot(int[] a, int data, int start, int end) {
        while(start <= end){
            if(start == end){
                return start;
            } else if(start == end -1) {
                if(a[start] > a[end]) {
                    return start;
                } else {
                    return end;
                }
            } else {
                int mid = start + (end-start)/2;

                if(a[mid] > a[mid-1] && a[mid] > a[mid+1]) {
                    return mid;
                }else if(a[mid] > a[mid-1] && a[mid] < a[mid+1]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
