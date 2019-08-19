package com.rahul.hacker.ds.array;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        /* for k = 0 */
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(k != 0) {
                sum = sum % k;
            }
            if(map.containsKey(sum)) {
                if(i - map.get(sum) > 1) return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;

    }

    public static void main(String[] args) {

        int[] a = {4, 0, 0, 3, 7};
        boolean b = new ContinuousSubarraySum().checkSubarraySum(a, 6);
        System.out.println(b);
    }

}
