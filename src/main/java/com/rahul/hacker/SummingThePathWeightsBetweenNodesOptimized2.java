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
public class SummingThePathWeightsBetweenNodesOptimized2 {

    static Map<Integer, Node>   graph       = new HashMap<>();

    static class Node {
        private int value;
        private boolean isRed;
        private List<Node> adjacents = new ArrayList<>();
        private long redWeights   = 0;
        private long blackWeights = 0;

        private long redWeightsSize   = 0;
        private long blackWeightsSize = 0;

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

        public int getValue(){
            return value;
        }

        public int getWeight(int i) {
            return weights.get(i);
        }

        public void addWeights(int value, int weight){
            weights.put(value, weight);
        }

        public long getRedWeights() {
            return redWeights;
        }

        public long getBlackWeights() {
            return blackWeights;
        }

        public void addRedWeight(long redWeight) {
            redWeights += redWeight;
        }

        public void addBlackWeight(long blackWeight) {
            blackWeights += blackWeight;
        }

        public long getRedWeightsSize() {
            return redWeightsSize;
        }

        public long getBlackWeightsSize() {
            return blackWeightsSize;
        }

        public void addRedWeightsSize(long redWeightsSize) {
            this.redWeightsSize += redWeightsSize;
        }

        public void addBlackWeightsSize(long blackWeightsSize) {
            this.blackWeightsSize += blackWeightsSize;
        }
    }

    private static long getTotalPathWeights(int n, int count){
        long[] sum = new long[]{0};
        totalPathsWeight(null, graph.get(1), sum);
        return sum[0];
    }

    private static void totalPathsWeight(Node prevNode, Node curNode, long[] sum){
        List<Node> nodes = curNode.getAdjacents();
        for(Node node : nodes){
            int thisValue = node.getValue();
            if(prevNode == null || thisValue != prevNode.getValue()){
                totalPathsWeight(curNode, node, sum);
            }
        }

        for(Node node : nodes){
            int thisValue = node.getValue();
            if(prevNode == null || thisValue != prevNode.getValue()){
                int nodeWeight = curNode.getWeight(thisValue);
                if(curNode.isRed != node.isRed){
                    sum[0] += nodeWeight;
                }

                long bWSize = node.getBlackWeightsSize();
                node.addBlackWeight(nodeWeight*bWSize);

                long rWSize = node.getRedWeightsSize();
                node.addRedWeight(nodeWeight*rWSize);

                if(curNode.isRed){
                    sum[0] += node.getBlackWeights();
                }else{
                    sum[0] += node.getRedWeights();
                }

                if(node.isRed){
                    node.addRedWeight(nodeWeight);
                    node.addRedWeightsSize(1);
                }else{
                    node.addBlackWeight(nodeWeight);
                    node.addBlackWeightsSize(1);
                }

                curNode.addBlackWeight(node.getBlackWeights());
                curNode.addBlackWeightsSize(node.getBlackWeightsSize());
                curNode.addRedWeight(node.getRedWeights());
                curNode.addRedWeightsSize(node.getRedWeightsSize());
            }
        }

        int adjSize = nodes.size();
        for(int i=0;i<adjSize;i++){
            for(int j=i+1;j<adjSize;j++){
                Node iNode = nodes.get(i);
                Node jNode = nodes.get(j);
                int iValue = iNode.getValue();
                int jValue = jNode.getValue();

                if(prevNode== null || (iValue != prevNode.getValue() && jValue != prevNode.getValue())){
                    long irListSize = iNode.getRedWeightsSize();
                    long ibListSize = iNode.getBlackWeightsSize();
                    long jrListSize = jNode.getRedWeightsSize();
                    long jbListSize = jNode.getBlackWeightsSize();

                    long irListSum = iNode.getRedWeights();
                    long ibListSum = iNode.getBlackWeights();
                    long jrListSum = jNode.getRedWeights();
                    long jbListSum = jNode.getBlackWeights();

                    sum[0] += irListSum * jbListSize;
                    sum[0] += ibListSum * jrListSize;
                    sum[0] += jrListSum * ibListSize;
                    sum[0] += jbListSum * irListSize;
                }
            }
        }
        System.out.println("Current value : " + curNode.getValue() + " Sum : " + sum[0]);
        //System.out.println();
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
