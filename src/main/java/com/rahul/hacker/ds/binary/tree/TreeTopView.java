package com.rahul.hacker.ds.binary.tree;

import java.util.Stack;

public class TreeTopView {
    class Node {
        int data;
        Node left;
        Node right;
    }
    public static void topView(Node root) {
        Stack<Integer> s = new Stack<>();
        System.out.print(root.data + " ");
        leftTopView(root.left, new int[]{0}, 0);
        rightTopView(root.right, new int[]{0}, 0);
    }

    private static void leftTopView(Node root, int[] max, int current) {

        if(root == null){
            return;
        }

        if(max[0] == current){
            System.out.print(root.data + " ");
            max[0]++;
        }

        leftTopView(root.left, max, current+1);
        leftTopView(root.right, max, current-1);
    }

    private static void rightTopView(Node root, int[] max, int current) {

        if(root == null){
            return;
        }

        if(max[0] == current){
            System.out.print(root.data + " ");
            max[0]++;
        }

        rightTopView(root.right, max, current+1);
        rightTopView(root.left, max, current-1);
    }
}
