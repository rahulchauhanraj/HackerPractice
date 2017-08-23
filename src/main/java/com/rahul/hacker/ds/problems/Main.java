package com.rahul.hacker.ds.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static class Node implements Comparable<Node>{
        Integer value;
        Integer index;

        Node(Integer value, Integer index){
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(value, o.value);
        }
    }

    static long buyMaximumProducts(int n, long k, Integer[] a) {
        long count = 0l;
        long sum = 0l;
        Map<Integer, Integer> map = new HashMap();
        List<Node> sortedNodes = new ArrayList<>();
        for(int i = 0; i<n; i++){
            Node node = new Node(a[i], i+1);
            sortedNodes.add(node);
        }

        Collections.sort(sortedNodes);

        for(Node node : sortedNodes){

            if(sum == k){
                return count;
            }

            Integer elem = node.value;

            long maxBuy = node.index;
            long oldSum = sum;
            sum += maxBuy * elem;

            if(sum > k){
                long diff = k-oldSum;
                long remCount = diff / elem;
                count += remCount;
                return count;
            }else{
                count += maxBuy;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        long vl = 130/12;
        Integer[] ar = new Integer[]{100, 55, 98, 97, 95, 96, 96, 92, 55, 28};
        //int[] ar = new int[]{10,7,19};
        long count = buyMaximumProducts(10, 4000L, ar);
        //long count = buyMaximumProducts(3, 45L, ar);
        System.out.println(count);
    }

}
