package com.rahul.hacker.ds.problems.stack;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    static String isBalanced(String s) {
        if(s == null || s.trim().length() == 0){
            return "YES";
        }
        s = s.trim();
        int len = s.length();
        Stack<Character> stack = new Stack();
        for(int i = 0; i<len; i++){
            char ch = s.charAt(i);
            switch(ch){
                case '{' : case '(' : case '[' :
                    stack.push(ch);
                    break;
                case '}' : case ')' : case ']':
                    if(stack.isEmpty()){
                        return "NO";
                    }
                    int top = Integer.valueOf(stack.pop());

                    if(top != Integer.valueOf(ch) -1 &&
                            top != Integer.valueOf(ch) -2){
                        return "NO";
                    }
                    break;
            }
        }
        if(stack.isEmpty()) {
            return "YES";
        }else{
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
}
