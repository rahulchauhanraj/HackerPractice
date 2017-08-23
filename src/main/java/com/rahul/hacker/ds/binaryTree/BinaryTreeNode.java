package com.rahul.hacker.ds.binaryTree;

/**
 * Created by 212578960 on 7/29/2017.
 */
public class BinaryTreeNode {
    private int            data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int val){
        data = val;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "data=" + data +
                '}';
    }
}
