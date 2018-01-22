package com.rahul.hacker.ds.problems.string;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;

public class PalindromeIndex {

    public static void main(String[] args) {
        Scanner sc = ScannerUtil.getScanner();
        int t = sc.nextInt();

        for(int i=0;i<t;i++){
            int index = -1;
            String s = sc.next();
            if(isPalindrome(s)){
                index = -1;
            }else{
                for(int j=0;j<s.length();j++){
                    StringBuilder sb = new StringBuilder();
                    int start = 0;
                    int end = s.length()-1;
                    int mid = j;

                    if(j>start){
                        sb.append(s.substring(start,j));
                    }

                    if(j<end){
                        sb.append(s.substring(j+1,end+1));
                    }
                    if(isPalindrome(sb.toString())){
                        index = j;
                        break;
                    }
                }
            }

            System.out.println(index);
        }
    }

    private static boolean isPalindrome(String s){
        int i =0;
        int j= s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
