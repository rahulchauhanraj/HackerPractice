package com.rahul.hacker.ds.binaryTree;

/**
 * Created by 212578960 on 7/29/2017.
 */
public class BinaryTree {

    public static void main(String[] args){
        BinaryTreeNode root = getTreeRoot();
        printTree(root);
    }

    public static void printTree(BinaryTreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.getData() + "  ");
        printTree(root.getLeft());
        printTree(root.getRight());
    }

    public static BinaryTreeNode getTreeRoot(){
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        root.setLeft(node2);
        root.setRight(node3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        node2.setLeft(node4);
        node2.setRight(node5);

        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        node3.setLeft(node6);
        node3.setRight(node7);

        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        node4.setLeft(node8);
        node4.setRight(node9);

        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node11 = new BinaryTreeNode(11);
        node5.setLeft(node10);
        node5.setRight(node11);

        BinaryTreeNode node12 = new BinaryTreeNode(12);
        BinaryTreeNode node13 = new BinaryTreeNode(13);
        node6.setLeft(node12);
        node6.setRight(node13);

        BinaryTreeNode node14 = new BinaryTreeNode(14);
        BinaryTreeNode node15 = new BinaryTreeNode(15);
        node7.setLeft(node14);
        node7.setRight(node15);

        return root;
    }
}
