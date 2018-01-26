package com.rahul.hacker.ds.binaryTree;

import com.rahul.hacker.ds.bst.BSTNode;

import static com.rahul.hacker.ds.binaryTree.BinaryTree.getTreeRoot;


public class SizeOfBinaryTree {

    public static void main(String arg[]) {
        BinaryTreeNode root = getTreeRoot();
        System.out.println(sizeOfBinaryTree(root));
    }

    private static int sizeOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        return (sizeOfBinaryTree(root.getLeft()) + 1 + sizeOfBinaryTree(root.getRight()));
    }
}
