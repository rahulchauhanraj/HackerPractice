package com.rahul.hacker.ds.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class PrintBottomView {
    public void bottomView(Node root)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] left = new int[1];
        bottomView(root, 0, map, left);
        while(map.containsKey(left[0])){
            System.out.print(map.get(left[0]) + " ");
            left[0]++;
        }
    }

    private void bottomView(Node root, int index, Map<Integer, Integer> map, int[] left)
    {
        if(root == null){
            return;
        }
        if(index < left[0]){
            left[0] = index;
        }
        bottomView(root.left, index-1, map, left);
        map.put(index, root.data);
        bottomView(root.right, index+1, map, left);
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

