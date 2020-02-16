package com.rahul.hacker.ds.problems.array;


public class SearchInsertPosition {


    public static void main(String[] args) {
        int[] a = {1,3,5,7};
        int t = 8;
        System.out.println(new SearchInsertPosition().searchInsert(a, t));
    }

    public int searchInsert(int[] a, int t) {

        int s = 0;
        int e = a.length -1;


        while(s<e){

            int mid = s + (e-s)/2;

            if(a[mid] == t){
                return mid;
            }

            if(a[mid] < t){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }

        return  (a[s] < t) ? s+1: s;
    }
}
