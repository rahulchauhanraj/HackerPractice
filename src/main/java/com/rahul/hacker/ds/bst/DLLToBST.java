package com.rahul.hacker.ds.bst;

import static com.rahul.hacker.ds.bst.BSTToDLL.convertBstToDLL;

public class DLLToBST {

    public static void main (String args[]) {
        BSTNode head = convertBstToDLL(BSTree.getTreeRoot());
        BSTNode root = dllToBst(head);
        BSTree.printTree(root);
    }

    public static BSTNode dllToBst(BSTNode head) {
        BSTNode root = getRightMidNode(head);
        convertDLLToBST(root);
        return root;
    }

    private static void convertDLLToBST(BSTNode root) {
        if(root == null) {
            return;
        }
        BSTNode rightHead = getRightMidNode(root.getRight());
        BSTNode leftHead = getLeftMidNode(root.getLeft());

        if(root.getLeft() != null)
            root.getLeft().setRight(null);
        if(root.getRight() != null)
            root.getRight().setLeft(null);

        root.setLeft(leftHead);
        root.setRight(rightHead);

        convertDLLToBST(leftHead);
        convertDLLToBST(rightHead);
    }

    private static BSTNode getRightMidNode(BSTNode head) {
        if(head == null) {
            return null;
        }
        BSTNode p1 = head;
        BSTNode p2 = head.getRight();
        while(p2 != null) {
            p2 = p2.getRight();

            if (p2 == null){
                break;
            }

            p1 = p1.getRight();
            p2 = p2.getRight();
        }

        return p1;
    }

    private static BSTNode getLeftMidNode(BSTNode head) {
        if(head == null) {
            return null;
        }
        BSTNode p1 = head;
        BSTNode p2 = head.getLeft();
        while(p2 != null) {
            p2 = p2.getLeft();

            if (p2 == null){
                break;
            }

            p1 = p1.getLeft();
            p2 = p2.getLeft();
        }

        return p1;
    }
}
