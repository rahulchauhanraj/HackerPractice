package com.rahul.interviews.sixt;

import org.springframework.util.Assert;

public class Anagram {

    public static void main(String[] s){
        Assert.isTrue(isAnagram("abc", "abc"));
        Assert.isTrue(isAnagram("abc", "bac"));
        Assert.isTrue(isAnagram("abc", "cab"));
        Assert.isTrue(!isAnagram("abc", "bc"));
        Assert.isTrue(!isAnagram("abc", "ab"));
        Assert.isTrue(!isAnagram("", "bc"));
        Assert.isTrue(!isAnagram("abc", ""));
        Assert.isTrue(isAnagram("anagram", "nagaram"));
        Assert.isTrue(isAnagram("azxa", "axaz"));
        Assert.isTrue(!isAnagram("abc", "abcd"));
    }

    private static boolean isAnagram(String lhs, String rhs){
        if(lhs == null || rhs == null){
            return false;
        }

        int[] counts = new int[26];
        int count = 0;
        for(int index=0; index<lhs.length(); index++){
            char ch = lhs.charAt(index);
            int countIndex = ch - 97;
            counts[countIndex]++;
            count++;
        }

        for(int index=0; index<rhs.length(); index++){
            char ch = rhs.charAt(index);
            int countIndex = ch - 97;
            if(counts[countIndex] == 0){
                return false;
            } else {
                counts[countIndex]--;
                count--;
            }
        }

        return count == 0;
    }
}
