package com.rahul.interviews.Amazon;

import java.util.Stack;

public class BSTIterator {

    private Stack<Node> stack = new Stack<>();
    private Node current;

    private BSTIterator(Node argRoot) {
        current = argRoot;
    }

    public static void main(String[] s){
        Node root = new Node(50);

        root.left = new Node(20);
        root.right = new Node(80);
        root.left.left = new Node(10);
        root.left.right = new Node(30);
        root.right.left = new Node(60);
        root.right.right = new Node(100);

        BSTIterator iterator = new BSTIterator(root);
        while(iterator.hasNext()){
            System.out.print(iterator.next().data + "  ");
        }
    }

    private Node next() {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        current = stack.pop();
        Node node = current;
        current = current.right;

        return node;
    }

    private boolean hasNext() {
        return (!stack.isEmpty() || current != null);
    }

    public static BSTIterator iterator(Node root) {
        return new BSTIterator(root);
    }

    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

}
