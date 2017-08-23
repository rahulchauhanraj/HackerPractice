package com.rahul.hacker.ds.problems.graph;

import com.rahul.hacker.util.ScannerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 212578960 on 5/24/2017.
 */
public class SummingThePathWeightsBetweenNodesOptimized {

    static Map<Integer, Node>   graph       = new HashMap<>();

    static class Node {
        private int value;
        private boolean isRed;
        public Map<Integer, Integer> weights = new HashMap<>();
        private List<Node> adjacent     = new ArrayList<>();
        private long       redWeights   = 0;
        private long       blackWeights = 0;

        private long redWeightsSize   = 0;
        private long blackWeightsSize = 0;

        public Node(int value, boolean isRed){
            this.value = value;
            this.isRed = isRed;
        }

        public void addAdjacent(Node node){
            adjacent.add(node);
        }

        public List<Node> getAdjacent(){
            return adjacent;
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

    private static void totalPathsWeight(Node prevNode, Node curNode, long[] sum){
        List<Node> nodes = curNode.getAdjacent();

        for(Node node : nodes){
            int thisValue = node.getValue();
            if(prevNode == null || thisValue != prevNode.getValue()){
                totalPathsWeight(curNode, node, sum);
            }
        }

        long bWSizeSum = 0;
        long rWSizeSum = 0;

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

                bWSize = node.getBlackWeightsSize();
                rWSize = node.getRedWeightsSize();

                curNode.addBlackWeight(node.getBlackWeights());
                curNode.addBlackWeightsSize(bWSize);
                curNode.addRedWeight(node.getRedWeights());
                curNode.addRedWeightsSize(rWSize);

                bWSizeSum += bWSize;
                rWSizeSum += rWSize;
            }
        }

        int adjSize = nodes.size();
        for(int i = 0; i < adjSize; i++){
            Node iNode = nodes.get(i);
            int iValue = iNode.getValue();
            if(prevNode== null || iValue != prevNode.getValue()) {
                long irWeights = iNode.getRedWeights();
                long ibWeights = iNode.getBlackWeights();
                long bWSize = iNode.getBlackWeightsSize();
                long rWSize = iNode.getRedWeightsSize();

                sum[0] += irWeights * (bWSizeSum - bWSize);
                sum[0] += ibWeights * (rWSizeSum - rWSize);
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

        long[] sum = new long[]{0};
        totalPathsWeight(null, graph.get(1), sum);
        System.out.println(sum[0]);
        System.out.println("TotalTime : " + (System.currentTimeMillis() - start));
    }
}
