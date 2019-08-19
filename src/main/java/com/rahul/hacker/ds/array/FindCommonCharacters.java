package com.rahul.hacker.ds.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 *
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 */
public class FindCommonCharacters {

    public static void main(String[] args) {

        String[] s = {"bella","label","roller"};
        List<String> l = new FindCommonCharacters().commonChars(s);
        System.out.println(l);
    }

    public List<String> commonChars(String[] A) {
        List<String> res=new ArrayList<String>();
        int[] min=new int[26];
        for(int i=0;i<26;i++){
            min[i]=Integer.MAX_VALUE;
        }
        for(String s:A){
            int[] cur=new int[26];
            char[] ca=s.toCharArray();
            for(char c:ca){
                cur[c -'a']++;
            }
            for(int i=0;i<26;i++){
                min[i]=Math.min(min[i],cur[i]);
            }
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<min[i];j++){
                res.add(String.valueOf((char)(i+'a')));
            }
        }
        return res;
    }
}
