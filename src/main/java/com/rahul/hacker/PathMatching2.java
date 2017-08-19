package com.rahul.hacker;

import com.rahul.hacker.util.ScannerUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 212578960 on 6/17/2017.
 */
public class PathMatching2 {

    static Node[] graph;

    static class Node {
        char name;
        private List<Integer> adjacent = new ArrayList<>(5);

        private StringBuilder[] paths;
        Node(char name){
            this.name = name;
        }

        public StringBuilder[] getPaths() {
            return paths;
        }

        public void setPaths(StringBuilder[] paths) {
            this.paths = paths;
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

    private static StringBuilder updatePath(int v, Integer[] visited, StringBuilder pattern, StringBuilder[] paths){
        Node an = graph[v];
        pattern.append(an.getName());
        paths[v] = new StringBuilder(pattern);
        visited[v] = v;
        List<Integer> adjacents = an.getAdjacent();

        for (int adj : adjacents) {
            if (visited[adj] == null) {
                updatePath(adj, visited, pattern, paths);
            }
        }
        pattern.deleteCharAt(pattern.length() -1);
        return null;
    }

    private static StringBuilder findPath(int u, int v){
        Node node = graph[u];
        return node.getPaths()[v];
    }

    private static void executeQuery(int u, int v, String p){
        StringBuilder path = findPath(u, v);
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

        for(int i = 1; i <= n; i++){
            Node node = graph[i];
            StringBuilder[] paths = new StringBuilder[n+1];
            node.setPaths(paths);
            Integer[] visited = new Integer[n+1];
            StringBuilder sb = new StringBuilder();
            updatePath(i, visited, sb, paths);
        }

        for(int a0 = 0; a0 < q; a0++){
            int u = in.nextInt();
            int v = in.nextInt();
            executeQuery(u, v , p);
        }
    }
}
