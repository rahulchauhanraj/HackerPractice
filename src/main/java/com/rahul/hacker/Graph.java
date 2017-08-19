package com.rahul.hacker;

import com.rahul.hacker.util.ScannerUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 212578960 on 6/16/2017.
 */
public class Graph {
    static Map<Integer, Node> graph = new HashMap<>();

    static class Node {
        int value;
        private Set<Integer> adjacent = new HashSet<>();

        Node(int value){
            this.value = value;
        }

        public void addAdjacent(int node){
            adjacent.add(node);
        }

        public Set<Integer> getAdjacent(){
            return adjacent;
        }
    }

    private static Node getNode(int value){
        Node node = graph.get(value);
        if(node == null){
            node = new Node(value);
            graph.put(value, node);
        }
        return node;
    }


    private static void addAdjacent(int u, int v){
        Node nu = getNode(u);
        Node nv = getNode(v);
        nu.addAdjacent(v);
        nv.addAdjacent(u);
    }


    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        int m = in.nextInt();
        for(int a0 = 0; a0 < m; a0++){
            int u = in.nextInt();
            int v = in.nextInt();
            addAdjacent(u, v);
        }

        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int a = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

        }
    }
}
