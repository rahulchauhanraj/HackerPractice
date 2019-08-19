package com.rahul.hacker.problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0;i < nums.length; i++) {

            map.put(target - nums[i], i);
        }

        for (int i=0;i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                int v = map.get(nums[i]);
                if (v != i) {
                    int[] val = {i, v};
                    return val;
                }
            }
        }
        return null;
    }
}
