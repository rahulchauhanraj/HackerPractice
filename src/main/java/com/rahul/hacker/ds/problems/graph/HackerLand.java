package com.rahul.hacker.ds.problems.graph;

import com.rahul.hacker.util.ScannerUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 212578960 on 5/27/2017.
 */
public class HackerLand {

    static Map<Integer, Node> graph = new HashMap<>();

    static class Node {
        int value;
        private Set<Integer> adjacent = new HashSet<>();
        private Set<Integer> routes   = new HashSet<>();

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

    private static void updateRoots(int x, int y, Set<Integer> visited){
        visited.add(y);
        Node prevNode = graph.get(x);
        Node curNode = graph.get(y);
        Set<Integer> nodes = curNode.getAdjacent();

        for(Integer value : nodes){
            curNode.routes.add(value);
            if(!visited.contains(value)) {
                updateRoots(y, value, visited);
            }else{
                curNode.routes.addAll(graph.get(value).routes);
            }
        }

        if(prevNode != null){
            prevNode.routes.addAll(curNode.routes);
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

    private static void executeQuery1(int x, int y, int n){
        Node existingNode = getNode(x);
        Node newNode = getNode(n);
        if(y == 0){
            existingNode.addAdjacent(n);
        }else{
            newNode.addAdjacent(x);
        }
    }

    private static void executeQuery2(int x, int y){
        Node nx = getNode(x);
        boolean isPathExists = nx.routes.contains(y);;
        if(isPathExists){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        int m = in.nextInt();
        for(int a0 = 0; a0 < m; a0++){
            int u = in.nextInt();
            int v = in.nextInt();
            Node nu = getNode(u);
            getNode(v);
            nu.addAdjacent(v);
        }

        int start = 1;
        int q = in.nextInt();
        int[] q1 = new int[q];
        int[] q2 = new int[q];
        int index = 0;
        for(int a0 = 0; a0 < q; a0++){
            int a = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            if(a == 1){
                n++;
                if(x == start && y == 1){
                    start = n;
                }
                executeQuery1(x, y, n);
            }else{
                q1[index] = x;
                q2[index] = y;
                index++;
            }
        }

        updateRoots(0, start, new HashSet<>());

        for(int i = 0; i<index; i++){
            executeQuery2(q1[i], q2[i]);
        }
    }
}
