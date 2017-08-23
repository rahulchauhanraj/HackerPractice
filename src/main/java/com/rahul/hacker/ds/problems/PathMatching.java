package com.rahul.hacker.ds.problems;

import com.rahul.hacker.util.ScannerUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 212578960 on 6/17/2017.
 */
public class PathMatching {

    static Node[] graph;

    static class Node {
        char name;
        private List<Integer> adjacent = new ArrayList<>(2);
        Node(char name){
            this.name = name;
        }
        public char getName() {
            return name;
        }
        public void addAdjacent(int node){
            adjacent.add(node);
        }
        public List<Integer> getAdjacent(){
            return adjacent;
        }
    }

    private static Node getNode(int value, String s){
        Node node = graph[value];
        if(node != null){
            return node;
        }
        node = new Node(s.charAt(value-1));
        graph[value] = node;
        return node;
    }

    private static void addAdjacent(int u, int v, String s){
        Node nu = getNode(u, s);
        Node nv = getNode(v, s);
        nu.addAdjacent(v);
        nv.addAdjacent(u);
    }

    private static StringBuilder findPath(int u, int v, boolean[] visited, StringBuilder pattern){
        Node an = graph[u];
        pattern.append(an.getName());

        if (u == v) {
            return pattern;
        }
        visited[u] = true;
        List<Integer> adjacents = an.getAdjacent();

        for (Integer adj : adjacents) {
            if (!visited[adj]) {
                StringBuilder path = findPath(adj, v, visited, pattern);
                if (path != null) {
                    return path;
                }
            }
        }
        pattern.deleteCharAt(pattern.length() -1);
        return null;
    }

    private static void executeQuery(int u, int v, String p, int n){
        boolean[] visited = new boolean[n+1];
        StringBuilder sb = new StringBuilder();
        StringBuilder path = findPath(u, v, visited, sb);
        System.out.println(matchCount(path, p, 0));
    }

    private static int matchCount(StringBuilder s, String p, int count){
        int index = s.indexOf(p);
        if(index != -1){
            count++;
            s.delete(0, index+1);
            return matchCount(s, p, count);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        int q = in.nextInt();
        String s = in.next();
        String p = in.next();

        graph = new Node[n+1];

        for(int a0 = 0; a0 < n-1; a0++){
            int u = in.nextInt();
            int v = in.nextInt();
            addAdjacent(u, v, s);
        }

        for(int a0 = 0; a0 < q; a0++){
            int u = in.nextInt();
            int v = in.nextInt();
            executeQuery(u, v , p, n);
        }
    }
}
