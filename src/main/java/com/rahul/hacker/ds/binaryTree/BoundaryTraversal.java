package com.rahul.hacker.ds.binaryTree;

public class BoundaryTraversal {

    void printBoundary(Node node)
    {
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        printLeftView(node.left);
        printLeafView(node.left);
        printLeafView(node.right);
        printRightView(node.right);
    }

    void printLeftView(Node node) {
        if(node == null){
            return;
        }
        if(node.left != null) {
            System.out.print(node.data + " ");
            printLeftView(node.left);
        } else if(node.right != null){
            System.out.print(node.data + " ");
            printLeftView(node.right);
        }
    }

    void printLeafView(Node node) {
        if(node == null){
            return;
        }
        printLeafView(node.left);
        if(node.left == null && node.right == null){
            System.out.print(node.data + " ");
        }
        printLeafView(node.right);
    }

    void printRightView(Node node) {
        if(node == null){
            return;
        }
        if(node.right != null){
            printRightView(node.right);
            System.out.print(node.data + " ");
        } else if(node.left != null){
            printRightView(node.left);
            System.out.print(node.data + " ");
        }
    }

    class Node
    {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
}
