package com.rahul.hacker.ds.binary.tree;

import java.util.*;

public class PrintVerticalOrder {
    public void verticalOrder(Node root)
    {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[] left = new int[1];
        verticalOrder(root, 0, map, left);
        while(map.containsKey(left[0])){
            for(int v : map.get(left[0])){
                System.out.print(v + " ");
            }
            left[0]++;

            System.out.print("$");
        }
    }

    private void verticalOrder(Node root, int index, Map<Integer, List<Integer>> map, int[] left)
    {
        if(root == null){
            return;
        }
        if(index < left[0]){
            left[0] = index;
        }
        if(map.containsKey(index)){
            map.get(index).add(root.data);
        }else{
            map.put(index, new ArrayList<>(Collections.singletonList(root.data)));
        }
        verticalOrder(root.left, index-1, map, left);
        verticalOrder(root.right, index+1, map, left);
    }

    class Node {
        int data; //data of the node
        int hd; //horizontal distance of the node
        Node left, right; //left and right references
        public Node(int key)
        {
            data = key;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }
}
