package com.rahul.hacker.ds.problems.binaryTree;

import com.rahul.hacker.ds.binaryTree.BinaryTree;
import com.rahul.hacker.ds.binaryTree.BinaryTreeNode;
import com.rahul.hacker.util.ScannerUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by 212578960 on 8/25/2017.
 */
public class SwapNodes {
    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        BinaryTreeNode[] a = new BinaryTreeNode[n];
        a[0] = new BinaryTreeNode(1);
        for(int a_i=0; a_i < n; a_i++){
            int v1 = in.nextInt();
            BinaryTreeNode left = null;
            if(v1 != -1) {
                left = new BinaryTreeNode(v1);
                a[v1 - 1] = left;
            }
            int v2 = in.nextInt();
            BinaryTreeNode right = null;
            if(v2 != -1) {
                right = new BinaryTreeNode(v2);
                a[v2 - 1] = right;
            }
            BinaryTreeNode parent = a[a_i];
            parent.setLeft(left);
            parent.setRight(right);
        }

        int q = in.nextInt();
        BinaryTreeNode root = a[0];
        for(int i = 0; i<q; i++){
            int d = in.nextInt();
            swapNodes(root, d);
            inOrder(root);
            System.out.println();
        }

        in.close();
    }

    static void swapNodes(BinaryTreeNode root, int d){
        int depth = 1;
        int nextDepth = 1;
        int depthForSwap = d;
        if(root == null){
            return;
        }

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            BinaryTreeNode node = q.remove();

            if(node == null){
                if(!q.isEmpty()){
                    if(depthForSwap == depth){
                        nextDepth++;
                        depthForSwap = d * nextDepth;
                    }
                    depth++;
                    q.add(null);
                    continue;
                }
                break;
            }

            BinaryTreeNode left = node.getLeft();
            if(left != null){
                q.add(left);
            }
            BinaryTreeNode right = node.getRight();
            if(right != null){
                q.add(right);
            }

            if(depthForSwap == depth){
                BinaryTreeNode temp = left;
                node.setLeft(right);
                node.setRight(temp);
            }
        }

    }

    static void inOrder(BinaryTreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrder(root.getRight());
    }
}
