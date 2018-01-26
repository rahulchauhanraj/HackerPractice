package com.rahul.hacker.ds.binaryTree;

import com.rahul.hacker.ds.bst.BSTNode;

import static com.rahul.hacker.ds.binaryTree.BinaryTree.getTreeRoot;


public class SearchInBinaryTreeRecursive {

    public static void main(String arg[]) {
        BinaryTreeNode root = getTreeRoot();
        System.out.println(searchInBinaryTree(root, 3));
    }

    private static boolean searchInBinaryTree(BinaryTreeNode root, int data) {
        if(root == null) {
            return false;
        }

        if(root.getData() == data) {
            return true;
        }

        return (searchInBinaryTree(root.getLeft(), data) || searchInBinaryTree(root.getRight(), data));
    }
}
