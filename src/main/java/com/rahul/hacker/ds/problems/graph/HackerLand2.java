package com.rahul.hacker.ds.problems.graph;

import com.rahul.hacker.util.ScannerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by 212578960 on 5/27/2017.
 */
public class HackerLand2 {

    static Map<Integer, Node> graph = new HashMap<>();

    static class Node {
        int value;
        int parent;
        private Set<Integer> adjacent = new HashSet<>();
        private Set<Integer> routes   = new HashSet<>();

        Node(int value, int parent){
            this.value = value;
            this.parent = parent;
        }

        public void addAdjacent(int node){
            adjacent.add(node);
        }

        public Set<Integer> getAdjacent(){
            return adjacent;
        }
    }

    private static void updateRoutes(int x, int y, Set<Integer> visited, List<Integer> possibleCycle){
        visited.add(y);
        Node prevNode = graph.get(x);
        Node curNode = graph.get(y);
        Set<Integer> nodes = curNode.getAdjacent();

        for(Integer value : nodes){
            curNode.routes.add(value);
            if(!visited.contains(value)) {
                updateRoutes(y, value, visited, possibleCycle);
            }else {
                possibleCycle.add(value);
            }
        }

        if(prevNode != null){
            prevNode.routes.addAll(curNode.routes);
        }
    }

    private static void updateRoutes(int y, Set<Integer> routes, Set<Integer> visited){
        visited.add(y);
        Node curNode = graph.get(y);
        Set<Integer> nodes = curNode.getAdjacent();

        for(Integer value : nodes){
            Node node = getNode(value);
            node.routes.addAll(routes.stream().parallel().filter(route -> route != value).collect(Collectors.toSet()));
            if(!visited.contains(value)) {
                updateRoutes(value, routes, visited);
            }
        }
    }

    private static Node getNode(int value){
        return getNode(value, 0);
    }

    private static Node getNode(int value, int parent){
        Node node = graph.get(value);
        if(node == null){
            node = new Node(value, parent);
            graph.put(value, node);
        }
        return node;
    }

    private static void executeQuery1(int x, int y, int n){
        Node existingNode = getNode(x);
        if(y == 0){
            getNode(n, x);
            existingNode.addAdjacent(n);
        }else{
            Node newNode = getNode(n, 0);
            newNode.addAdjacent(x);
            newNode.routes.addAll(existingNode.routes);
            newNode.routes.add(x);
        }
    }

    private static void executeQuery2(int x, int y){
        Node nx = getNode(x);
        Node ny = getNode(y);
        boolean isPathExists = nx.routes.contains(y);
        if(!isPathExists){
            int parent = ny.parent;
            int last = parent;
            while(parent != 0){
                Node parentNode = getNode(parent);
                last = parentNode.value;
                parent = parentNode.parent;
            }

            if(last != 0){
                isPathExists = nx.routes.contains(last);
            }
        }
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

        List<Integer> possibleCycles = new ArrayList<>();
        updateRoutes(0, 1, new HashSet<>(), possibleCycles);

        for(Integer possibleCycle : possibleCycles){
            Node nv = getNode(possibleCycle);
            if(nv.routes.contains(possibleCycle)){
                updateRoutes(possibleCycle, nv.routes, new HashSet<>());
            }
        }

        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int a = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            if(a == 1){
                n++;
                executeQuery1(x, y, n);
            }else{
                executeQuery2(x, y);
            }
        }
    }
}
