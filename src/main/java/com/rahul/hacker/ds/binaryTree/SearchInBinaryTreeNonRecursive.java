package com.rahul.hacker.ds.binaryTree;

import com.rahul.hacker.ds.bst.BSTNode;

import java.util.LinkedList;
import java.util.Queue;

import static com.rahul.hacker.ds.binaryTree.BinaryTree.getTreeRoot;

public class SearchInBinaryTreeNonRecursive {

    public static void main(String arg[]) {
        BinaryTreeNode root = getTreeRoot();
        System.out.println(searchInBinaryTree(root, 20));
    }

    private static boolean searchInBinaryTree(BinaryTreeNode root, int data) {
        if(root == null) {
            return false;
        }

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            BinaryTreeNode node = q.remove();
            if(node.getData() == data) {
                return true;
            }

            BinaryTreeNode left = node.getLeft();
            if(left != null) {
                q.add(left);
            }
            BinaryTreeNode right = node.getRight();
            if(right!= null){
                q.add(right);
            }
        }
        return false;
    }
}
