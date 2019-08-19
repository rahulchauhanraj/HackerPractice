package com.rahul.hacker.ds.string;

import org.springframework.util.Assert;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {

        if(s == null && t == null){
            return true;
        }

        if(s == null || t == null){
            return false;
        }

        char c = '#';
        StringBuilder sb1 = new StringBuilder();

        for(char a : s.toCharArray()){
            if(a == c){
                sb1.deleteCharAt(sb1.length()-1);
            }else {
                sb1.append(a);
            }
        }

        StringBuilder sb2 = new StringBuilder();

        for(char a : t.toCharArray()){
            if(a == c){
                sb2.deleteCharAt(sb2.length()-1);
            }else {
                sb2.append(a);
            }
        }

        System.out.println(sb1 + ":" + sb2);
        return sb1.equals(sb2);
    }

    public static void main(String[] args) {


        boolean b = new BackspaceStringCompare().backspaceCompare("ab#c", "ad#c");
        Assert.isTrue(b);
    }
}
