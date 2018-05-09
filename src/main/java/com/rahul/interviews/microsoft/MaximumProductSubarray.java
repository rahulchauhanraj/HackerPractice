package com.rahul.interviews.microsoft;

import org.springframework.util.Assert;

public class MaximumProductSubarray {
    public static void main (String[] args) {

        int arr[] = {1, -2, -3, 0, 7, -8, -2};
        long val = maxSubarrayProduct(arr);
        System.out.println("Maximum Sub array product is " + val);
        Assert.isTrue(val == 112);

        int[] arr1 = {6, -3, -10, 0, 2};
        val = maxSubarrayProduct(arr1);
        System.out.println("Maximum Sub array product is " + val);
        Assert.isTrue(val == 180);

        int[] arr2 = {-1, -3, -10, 0, 60};
        val = maxSubarrayProduct(arr2);
        System.out.println("Maximum Sub array product is " + val);
        Assert.isTrue(val == 60);

        int[] arr3 = {-2, -3, 0, -2, -40};
        val = maxSubarrayProduct(arr3);
        System.out.println("Maximum Sub array product is " + val);
        Assert.isTrue(val == 80);

        int[] arr4 = {0, 0, -20, 0};
        val = maxSubarrayProduct(arr4);
        System.out.println("Maximum Sub array product is " + val);
        Assert.isTrue(val == -20);

        int[] arr5 = {0, 0, 0};
        val = maxSubarrayProduct(arr5);
        System.out.println("Maximum Sub array product is " + val);
        Assert.isTrue(val == 0);

        int[] arr6 = {0, 1, 0};
        val = maxSubarrayProduct(arr6);
        System.out.println("Maximum Sub array product is " + val);
        Assert.isTrue(val == 1);

        int[] arr7 = {0, 0, -20};
        val = maxSubarrayProduct(arr7);
        System.out.println("Maximum Sub array product is " + val);
        Assert.isTrue(val == -20);

        int[] arr8 = {0, 1};
        val = maxSubarrayProduct(arr8);
        System.out.println("Maximum Sub array product is " + val);
        Assert.isTrue(val == 1);
    }

    private static long maxSubarrayProduct(int[] a){
        int maxSoFar = 1;
        int i = 0;
        int l = a.length;
        int currentMax = 1;
        int lastResult = 1;
        boolean allZero = true;
        int singleValueResult = 0;
        int nonZero = 0;
        while(i<l){
            int v = a[i];

            if(v != 0){
                allZero = false;
                nonZero++;
                lastResult *= v;
                if(lastResult > currentMax) {
                    currentMax = lastResult;
                }
                if(nonZero == 1){
                    singleValueResult = lastResult;
                }
                if(maxSoFar < currentMax) {
                    maxSoFar = currentMax;
                }
            }else {
                lastResult = 1;
                currentMax = 1  ;
            }
            i++;
        }

        if(allZero) {
            return 0;
        }else if(nonZero == 1){
            return singleValueResult;
        }
        return maxSoFar;
    }

}
