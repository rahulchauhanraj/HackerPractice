package com.rahul.hacker.ds.bst;

/**
 * Created by 212578960 on 7/29/2017.
 */
public class BSTNode {
    private int data;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(int val){
        data = val;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "data=" + data +
                '}';
    }
}
