package com.rahul.hacker.ds.bst;

public class IsBST {

    public static void main (String args[]) {
        BSTNode node = BSTree.getTreeRoot();
        System.out.println(isBst(node, new BSTNode(0)));
        int[] last = {-1};
        System.out.println(isBst1(node, last));
    }

    private static boolean isBst(BSTNode node, BSTNode last) {
        return (node == null || (isBst(node.getLeft(), last)&& isInOrder(node, last) && isBst(node.getRight(), last)));
    }

    private static boolean isInOrder(BSTNode node, BSTNode last) {
        boolean inOrder = last.getData() < node.getData();
        last.setData(node.getData());
        return inOrder;
    }

    private static boolean isBst1(BSTNode node, int[] last) {
        if(node == null){
            return true;
        }
        if(!isBst1(node.getLeft(), last)){ return false;};

        int data = node.getData();

        if(data < last[0]) {
            return false;
        }
        last[0] = data;

        return isBst1(node.getRight(), last);
    }

}
