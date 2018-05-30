package com.rahul.hacker.ds.binaryTree;

import com.rahul.hacker.ds.bst.BSTNode;

import static com.rahul.hacker.ds.binaryTree.BinaryTree.getTreeRoot;


public class SearchInBinaryTreeRecursive {

    public static void main(String arg[]) {
        BinaryTreeNode root = getTreeRoot();
        System.out.println(searchInBinaryTree(root, 3));
    }

    private static boolean searchInBinaryTree(BinaryTreeNode root, int data) {
        return ((root != null) && (root.getData() == data || searchInBinaryTree(root.getLeft(), data) || searchInBinaryTree(root.getRight(), data)));
    }
}
