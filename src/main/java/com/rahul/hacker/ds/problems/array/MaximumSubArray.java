package com.rahul.hacker.ds.problems.array;

public class MaximumSubArray {

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubArray().maxSubArray(a));
    }

    public int maxSubArray(int[] n) {

        int max = Integer.MIN_VALUE;
        int current = 0;

        for(int v : n){

            current += v;

            if(current > max) {
                max = current;
            }

            if(current < 0){
                current = 0;
            }
        }

        return max;
    }
}
