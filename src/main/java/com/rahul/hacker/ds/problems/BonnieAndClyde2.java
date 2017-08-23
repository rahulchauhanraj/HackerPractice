package com.rahul.hacker.ds.problems;

import com.rahul.hacker.util.ScannerUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 212578960 on 6/16/2017.
 */
public class BonnieAndClyde2 {
    static Node[] graph;
    static Set<Integer> articulationPoints = new HashSet<>();
    static class Node {
        private Set<Integer> adjacent = new HashSet<>();

        private List<Set<Integer>> graphs = new ArrayList<>();

        private boolean articulationPoint = false;

        public void addAdjacent(int node){
            adjacent.add(node);
        }

        public Set<Integer> getAdjacent(){
            return adjacent;
        }
    }

    private static Node getNode(int value){
        Node node = graph[value];
        if(node == null){
            node = new Node();
            graph[value] = node;
        }
        return node;
    }


    private static void addAdjacent(int u, int v){
        Node nu = getNode(u);
        Node nv = getNode(v);
        nu.addAdjacent(v);
        nv.addAdjacent(u);
    }

    /*private static boolean isRoutePossible(int u, int v, int w, int w1, Set<Integer> visited, int count){
        visited.add(w1);
        if(w1 == u || w1 == v){
            count++;
            if(count == 2){
                return true;
            }
            return isRoutePossible(u, v, w, w, visited, count);
        }

        Node an = getNode(w1);
        Set<Integer> adjacents = an.getAdjacent();

        for(int adj : adjacents){
            if(!visited.contains(adj)){
                Set<Integer> newVisited = new HashSet<>(visited);
                boolean routePossible = isRoutePossible(u, v, w, adj, newVisited, count);
                if(routePossible){
                    return true;
                }
            }
        }

        return false;
    }*/

    private static void updateArticulationPoints(Node node){

    }

    private static void findArticulationPoints(){
        for(Node node :graph){
            updateArticulationPoints(node);
        }
    }

    private static boolean isRoutePossible(int u, int v, int w){
        Set<Integer> visited = new HashSet<>();
        return true;
        //return isRoutePossible(u, v, w, w, visited, 0);
    }

    private static void executeQuery(int u, int v, int w){
        if(isRoutePossible(u, v, w)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();

        graph = new Node[n+1];

        for(int a0 = 0; a0 < m; a0++){
            int u = in.nextInt();
            int v = in.nextInt();
            addAdjacent(u, v);
        }


        for(int a0 = 0; a0 < q; a0++){
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();

            executeQuery(u, v, w);
        }
    }
}
