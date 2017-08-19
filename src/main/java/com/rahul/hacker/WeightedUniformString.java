package com.rahul.hacker;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 212578960 on 5/22/2017.
 */
public class WeightedUniformString {

    public static void main(String[] args) {
        String str = "abccddde";

        int[] a = new int[]{1, 3, 12, 5, 9, 10};
        int n = a.length;

        Set<Integer> weights = getAllWeights(str);
        for(int i=0; i<n; i++){
            if(weights.contains(a[i])){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

        }
    }

    private static Set<Integer> getAllWeights(String s){
        Set<Integer> weights = new HashSet<>();

        int n = s.length();
        Character lastChar = null;
        int count = 0;
        for (int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(lastChar == null){
                weights.add(Integer.valueOf(ch) - 96);
                count = 1;
            }else {
                if(lastChar == ch ){
                    count++;
                    weights.add((Integer.valueOf(ch) - 96) * count);
                }else{
                    weights.add(Integer.valueOf(ch) - 96);
                    count = 1;
                }
            }
            lastChar = ch;
        }

        return weights;
    }

}
