package com.rahul.interviews.microsoft;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicateFromString {

    public static void main (String[] args) {
        System.out.println(removeDuplicates("Strings"));
        System.out.println(removeDuplicates1("Geeksforgeeks"));
        System.out.println(removeDuplicates("Strings"));
        System.out.println(removeDuplicates1("Geeksforgeeks"));
    }

    private static String removeDuplicates(String s){
        StringBuilder sb = new StringBuilder();
        char[] c = new char[200];
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(c[ch] == 0){
                c[ch] = 1;
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private static String removeDuplicates1(String s){
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new LinkedHashSet<>();
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
            }
        }
        set.forEach(sb::append);
        return sb.toString();
    }
}
