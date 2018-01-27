package com.rahul.hacker.ds.bst;

public class IsBST {

    public static void main (String args[]) {
        BSTNode node = BSTree.getTreeRoot();
        System.out.println(isBst(node, new BSTNode(0)));
    }

    private static boolean isBst(BSTNode node, BSTNode last) {
        return (node == null || (isBst(node.getLeft(), last)&& isInOrder(node, last) && isBst(node.getRight(), last)));
    }

    private static boolean isInOrder(BSTNode node, BSTNode last) {
        boolean inOrder = last.getData() < node.getData();
        if(inOrder) {
            last.setData(node.getData());
        }
        return inOrder;
    }


}
