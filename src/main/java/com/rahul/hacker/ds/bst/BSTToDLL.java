package com.rahul.hacker.ds.bst;

public class BSTToDLL {

    public static void main (String args[]) {
        BSTNode root = BSTree.getTreeRoot();
        BSTNode head = convertBstToDLL(root);
        printDLL(head);
    }

    public static BSTNode convertBstToDLL(BSTNode root) {
        BSTNode temp = root;
        BSTNode head = null;
        while (root != null) {
            head = root;
            root = root.getLeft();
        }
        convertBstToDLL(temp, new BSTNode[1]);
        return head;
    }

    public static void convertBstToDLL(BSTNode node, BSTNode[] lastVisited) {
        if(node == null) {
            return;
        }

        convertBstToDLL(node.getLeft(), lastVisited);
        convert(node, lastVisited);
        convertBstToDLL(node.getRight(), lastVisited);
    }

    private static void convert(BSTNode node, BSTNode[] lastVisited) {
        BSTNode lastNode = lastVisited[0];
        if (lastNode != null) {
            lastNode.setRight(node);
        }
        node.setLeft(lastNode);
        lastVisited[0] = node;
    }

    private static void printDLL(BSTNode head) {
        while (head != null) {
            System.out.println(head.getData());
            head = head.getRight();
        }
    }
}
