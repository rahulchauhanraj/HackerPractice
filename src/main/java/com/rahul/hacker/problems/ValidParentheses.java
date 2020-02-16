package com.rahul.hacker.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("(()({[]}))"));
    }

    public boolean isValid(String s) {
        Map<Character, Character> m = new HashMap<>();

        m.put('(', ')');
        m.put('{', '}');
        m.put('[', ']');

        Stack<Character> stk = new Stack<>();

        for(int i = s.length() -1; i>=0; i--){
            char c = s.charAt(i);

            if(m.containsKey(c)){
                if(stk.isEmpty()){
                    return false;
                }
                char p = stk.pop();
                if(p != m.get(c)){
                    return false;
                }
            }else{
                stk.push(c);
            }
        }

        return stk.size() == 0;
    }

}
