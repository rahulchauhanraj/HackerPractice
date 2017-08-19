package com.rahul.hacker;

import com.rahul.hacker.util.ScannerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 212578960 on 5/24/2017.
 */
public class SummingThePathWeightsBetweenNodes {

    static Map<Integer, Node>   graph       = new HashMap<>();

    static class Node {
        private int value;
        private boolean isRed;
        private List<Node> adjacents = new ArrayList<>();

        public Node(int value, boolean isRed){
            this.value = value;
            this.isRed = isRed;
        }

        public void addAdjacent(Node node){
            adjacents.add(node);
        }

        public Map<Integer, Integer> weights = new HashMap<>();

        public List<Node> getAdjacents(){
            return adjacents;
        }

        public boolean isRed(){
            return isRed;
        }

        public int getValue(){
            return value;
        }

        public int getWeight(int i) {
            return weights.get(i);
        }

        public void addWeights(int value, int weight){
            weights.put(value, weight);
        }
    }

    private static long getTotalPathWeights(int n, int count){
        long sum = 0;
        long sum2 = 0;
        int dif = n - count;

        boolean color = dif > count ? true : false;
        for(int i=1; i<=n; i++){
            Node node = graph.get(i);
            if(node.isRed() == color){
                long[] total = new long[]{0,0};
                totalPathsWeight(null, node, 0, node.isRed(), total, new int[n], 0);
                sum += total[0];
                sum2 += total[1];
            }
        }
        System.out.println("Iteration : " + sum2);
        return sum;
    }

    private static void totalPathsWeight(Node preNode, Node curNode, long pathSum, boolean color, long[] total, int[] visited, int weight){
        total[1] += 1;
        int value = curNode.getValue();
        visited[value - 1] = 1;
        if(preNode != null){
            pathSum += weight;
            if(curNode.isRed() != color){
                total[0] += pathSum;
            }
        }

        List<Node> nodes = curNode.getAdjacents();
        int size = nodes.size();
        for(int i=0; i< size; i++){
            Node node = nodes.get(i);
            int thisValue = node.getValue();
            if(visited[thisValue - 1] == 0){
                int nodeWeight = curNode.getWeight(thisValue);
                totalPathsWeight(curNode, node, pathSum, color, total, visited, nodeWeight);
            }
        }
    }

    private static void addAdjacent(int u, int v, int w){
        Node nu = graph.get(u);
        Node nv = graph.get(v);
        nu.addWeights(v, w);
        nv.addWeights(u, w);
        nu.addAdjacent(nv);
        nv.addAdjacent(nu);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();

        int count = 0;
        for(int i=0; i < n; i++){
            int val = in.nextInt();
            boolean color = val == 0 ? true : false;
            if(color) {
                count++;
            }
            int value = i + 1;
            Node node = new Node(value, color);
            graph.put(value, node);
        }

        for(int a0 = 0; a0 < n-1; a0++){
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            addAdjacent(u, v, w);
        }

        long total = getTotalPathWeights(n, count);
        System.out.println(total);
        System.out.println("TotalTime : " + (System.currentTimeMillis() - start));
    }
}
