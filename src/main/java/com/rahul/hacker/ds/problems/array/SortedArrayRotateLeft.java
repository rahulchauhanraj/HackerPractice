package com.rahul.hacker.ds.problems.array;

/**
 * Created by 212578960 on 8/23/2017.
 */
public class SortedArrayRotateLeft {

    public static int findPivotIndex(int[] a, int start, int end){
        if(end < start){
            return -1;
        }

        if(start == end){
            return end;
        }

        if(start+1 == end){
            if(a[start] < a[end]){
                return end;
            }else{
                return start;
            }
        }

        int mid = (start + end)/2;

        if(a[mid] > a[mid-1] && a[mid] > a[mid+1]){
            return mid;
        }

        if(a[mid] > a[0]){
            return findPivotIndex(a, mid+1, end);
        }else{
            return findPivotIndex(a, start, mid-1);
        }
    }

    public static int searchElement(int[] a, int start, int end, int element){
        if(end<start){
            return -1;
        }

        int mid = (start+end)/2;

        if(a[mid] == element){
            return mid;
        }

        if(a[mid] > element){
            return searchElement(a, start, mid-1, element);
        }else{
            return searchElement(a, mid+1, end, element);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{23, 25, 28, 35, 45, 52, 61, 68, 4, 6, 8, 10, 15};
        //int[] a = new int[]{1,2,3};
        //int[] a = new int[]{1,2};
        int element = 4;
        //int[] a = new int[]{2,3};
        int pivotIndex = findPivotIndex(a, 0, a.length-1);

        if(a[pivotIndex] == element){
            System.out.println(pivotIndex);
            return;
        } else {
            int start;
            int end;
            if (a[pivotIndex] > element && a[0] <= element) {
                start = 0;
                end = pivotIndex-1;
            } else {
                start = pivotIndex + 1;
                end = a.length - 1;
            }
            System.out.println(searchElement(a, start, end, element));
        }
    }
}
