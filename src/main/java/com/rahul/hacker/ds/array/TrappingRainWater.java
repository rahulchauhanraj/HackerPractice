package com.rahul.hacker.ds.array;

import org.springframework.util.Assert;

import java.util.Stack;

public class TrappingRainWater {

    class Node {
        int v;
        int i;
        int sum;

        Node(int v, int i) {
            this.v= v;
            this.i = i;
        }
    }
    public int trap(int[] a) {


        if(a == null || a.length == 0){
            return 0;
        }

        Stack<Node> s = new Stack<>();

        int max = 0;
        int n = a.length;

        for(int i=0; i<n; i++){

            int v = a[i];

            if(s.isEmpty()) {
                s.push(new Node(v, i));
            }else{
                Node p = s.peek();

                if(v < p.v){
                    s.push(new Node(v, i));
                }else{
                    Node last = null;

                    while(!s.isEmpty() && v >= s.peek().v) {
                        last = s.pop();
                    }

                    if(s.isEmpty() && last != null && i-last.i > 1) {
                        int current = last.v * (i-last.i);

                        for(int j = last.i; j<i; j++){
                            current -= a[j];
                        }

                        max += current;
                    }

                    s.push(new Node(v, i));
                }
            }
        }

        Node last = null;

        while(!s.isEmpty()){

            Node current = s.pop();

            if(last != null){

                max += last.v * (last.i-current.i-1);

                for(int j = current.i+1; j<last.i; j++){
                    max -= a[j];
                }
            }
            last = current;
        }

        return max;
    }

    public static void main(String[] args) {

        int[] a = {1,4,7,9,3,7,2,8,4,9,2,5,0,5,0,6,0,2,6,8,4,0,2};
        //int[] a = {1,4,7,9,3,7};
        int b = new TrappingRainWater().trap(a);
        System.out.println(b);
        Assert.isTrue(6 == b);
    }
}
