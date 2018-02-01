package com.rahul.hacker.ds.problems.stack;

import com.rahul.hacker.ds.problems.BonnieAndClyde;
import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();

        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();

        for(int a0 = 0; a0 < n; a0++){
            int q = in.nextInt();

            switch(q){
                case 1 :
                    int elem = in.nextInt();
                    s1.push(elem);

                    if(s2.isEmpty() || elem >= s2.peek()){
                        s2.push(elem);
                    }
                    break;
                case 2 :
                    int top = s1.pop();
                    if(top == s2.peek()){
                        s2.pop();
                    }
                    break;
                case 3 :
                    System.out.println(s2.peek());
                    break;
            }
        }

        in.close();
    }
}
