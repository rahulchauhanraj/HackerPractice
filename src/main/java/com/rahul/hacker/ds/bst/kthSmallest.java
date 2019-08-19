package com.rahul.hacker.ds.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class kthSmallest {

    public static void main(String arg[]) {

        Stack<Integer> q = new Stack<>();

        BSTNode root = new BSTNode(150);
        BSTNode b1 = new BSTNode(100);
        BSTNode b2 = new BSTNode(200);
        root.setLeft(b1);
        root.setRight(b2);

        BSTNode c1 = new BSTNode(50);
        BSTNode c2 = new BSTNode(250);
        b1.setLeft(c1);
        b2.setRight(c2);

        System.out.println(kthSmallest(root, 1));
    }


    public static int kthSmallest(BSTNode root, int k) {

        int l[] = {k};
        return kthSmallest(root, l);
    }

    public static int kthSmallest(BSTNode root, int[] l) {

        if(root == null) {
            return 0;
        }

        int left = kthSmallest(root.getLeft(), l);

        if(left != 0){
            return left;
        }

        l[0] -= 1;

        if(l[0] == 0) {
            return root.getData();
        }

        return kthSmallest(root.getRight(), l);
    }

}
