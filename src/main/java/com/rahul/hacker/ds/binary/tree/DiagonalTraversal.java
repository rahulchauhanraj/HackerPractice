package com.rahul.hacker.ds.binary.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DiagonalTraversal {

    public void diagonalPrint(TreeNode root)
    {
        int index = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        diagonalPrint(root, map, index);
        while(map.containsKey(index)) {
            List<Integer> list = map.get(index);
            for(int v : list){
                System.out.print(v + " ");
            }
            index--;
        }
    }

    private void diagonalPrint(TreeNode root, Map<Integer, List<Integer>> map, int index)
    {
        if(root == null){
            return;
        }
        if(map.containsKey(index)){
            map.get(index).add(root.data);
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(index, list);
        }
        diagonalPrint(root.left, map, index-1);
        diagonalPrint(root.right, map, index);
    }

    class TreeNode
    {
        int data; //node data
        TreeNode left, right; //left and right child's reference
        // Tree node constructor
        public TreeNode(int data)
        {
            this.data = data;
            left = right = null;
        }
    }
}
