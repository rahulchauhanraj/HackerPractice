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
 * 4 5 6 7 2 3 1
 *
 */
public class BinaryTreeReversal {
    public static void main(String arg[]) {
        BinaryTreeNode root = getTreeRoot();
        binaryTreeReversal(root);
    }

    private static void binaryTreeReversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        Stack<BinaryTreeNode> s = new Stack<>();

        while (!q.isEmpty()) {
            BinaryTreeNode node = q.remove();
            s.push(node);

            BinaryTreeNode right = node.getRight();
            if(right != null) {
                q.add(right);
            }

            BinaryTreeNode left = node.getLeft();
            if(left != null) {
                q.add(left);
            }
        }

        while (!s.empty()) {
            System.out.println(s.pop().getData());
        }
    }

}
