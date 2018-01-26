package com.rahul.hacker.ds.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static com.rahul.hacker.ds.binaryTree.BinaryTree.getTreeRoot;

/**
 * Input :
 *                          1
 *                  2              3
 *              4       5      6       7
 *
 * Output :
 *
 * 1 3 2 4 5 6 7
 * 
 */
public class BinaryTreeZigZagTraversal {
    public static void main(String arg[]) {
        BinaryTreeNode root = getTreeRoot();
        zigZagTraversal(root);
    }

    private static void zigZagTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode> q1 = new LinkedList<>();
        Stack<BinaryTreeNode> s1 = new Stack<>();
        q1.add(root);
        q1.add(null);

        boolean even = true;

        while (!q1.isEmpty()) {
            BinaryTreeNode node = q1.remove();
            if(node != null) {
                if (even) {
                    System.out.println(node.getData());
                } else {
                    s1.push(node);
                }

                BinaryTreeNode left = node.getLeft();
                if (left != null) {
                    q1.add(left);
                }

                BinaryTreeNode right = node.getRight();
                if (right != null) {
                    q1.add(right);
                }
            } else {
                if(!q1.isEmpty()) {
                    q1.add(null);
                    even = !even;
                }
                while (!s1.isEmpty()) {
                    System.out.println(s1.pop().getData());
                }
            }
        }
    }
}
