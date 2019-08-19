package com.rahul.hacker.ds.bst;

public class DLLToBST {

    public static void main (String[] args) {

        BSTNode head = getDLL();
        head.getLeft().setRight(null);
        head.setLeft(null);
        BSTNode root = dllToBst(head);
        BSTree.printTree(root);
    }

    public static BSTNode dllToBst(BSTNode head) {
        return convertDLLToBST(head);
    }

    private static BSTNode convertDLLToBST(BSTNode head) {

        if(head == null) {
            return null;
        }

        if(head.getRight() == null){
            return head;
        }

        BSTNode root = getRightMidNode(head);

        if(root.getLeft() != null)
            root.getLeft().setRight(null);
        if(root.getRight() != null)
            root.getRight().setLeft(null);

        BSTNode rightHead = getRightMidNode(root.getRight());
        BSTNode leftHead = getRightMidNode(head);

        root.setLeft(convertDLLToBST(leftHead));
        root.setRight(convertDLLToBST(rightHead));

        return root;
    }

    private static BSTNode getRightMidNode(BSTNode head) {

        if(head == null) {
            return null;
        }

        BSTNode p1 = head;
        BSTNode p2 = head;
        while(p2 != null && p2.getRight() != head) {
            p2 = p2.getRight();

            if (p2 == null){
                break;
            }
            p1 = p1.getRight();
            p2 = p2.getRight();
        }

        return p1;
    }

    private static BSTNode getDLL() {

        BSTNode head = new BSTNode(2);
        head.setLeft(head);
        head.setRight(head);

        addNode(head, 6);
        addNode(head, 8);
        addNode(head, 10);
        addNode(head, 12);
        addNode(head, 14);
        addNode(head, 16);
        addNode(head, 18);


        return head;
    }

    private static void addNode(BSTNode head, int v) {

        BSTNode p1 = new BSTNode(v);
        BSTNode left = head.getLeft();

        left.setRight(p1);
        p1.setLeft(left);
        p1.setRight(head);
        head.setLeft(p1);
    }

}
