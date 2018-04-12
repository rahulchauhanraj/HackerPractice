package com.rahul.hacker.ds.searching;

public class ArrayRotationSearch {

    public static void main (String args[]) {
        int[] a = {15, 16, 19, 20, 25, 1, 5, 7, 10};
        int index = search(a, 1);
        System.out.println(index);
    }

    private static int search(int[] a, int data) {
        if(a == null) {
            return -1;
        }
        int pivotIndex = findPivot(a);
        if(a[pivotIndex] == data) {
            return pivotIndex;
        }
        int start;
        int end;
        if(data > a[0] && data < a[pivotIndex]) {
            start = 0;
            end = pivotIndex-1;
        } else {
            start = pivotIndex+1;
            end = a.length - 1;
        }
        return searchBinary(a, start, end, data);
    }

    private static int searchBinary(int[] a, int start, int end, int data) {
        if(start<=end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == data) {
                return mid;
            }

            if (a[mid] > data) {
                return searchBinary(a, start, mid-1, data);
            } else {
                return searchBinary(a, mid+1, end, data);
            }
        }
        return -1;
    }

    private static int findPivot(int[] a) {
        int start = 0;
        int end = a.length;

        while (start <= end) {
            if(start == end){
                return start;
            } else if(start == end -1) {
                if(a[start] > a[end]) {
                    return start;
                } else {
                    return end;
                }
            }
            int mid = start + (end - start)/2;

            if(a[start] >= a[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1;
    }

}
