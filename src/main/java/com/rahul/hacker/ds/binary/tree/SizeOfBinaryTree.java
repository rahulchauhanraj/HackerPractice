package com.rahul.hacker.ds.binary.tree;


public class SizeOfBinaryTree {

    public static void main(String arg[]) {
        BinaryTreeNode root = BinaryTree.getTreeRoot();
        System.out.println(sizeOfBinaryTree(root));
    }

    private static int sizeOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        return (sizeOfBinaryTree(root.getLeft()) + 1 + sizeOfBinaryTree(root.getRight()));
    }
}
