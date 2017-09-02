package com.rahul.hacker.ds.problems.binaryTree;

import com.rahul.hacker.ds.binaryTree.BinaryTree;
import com.rahul.hacker.ds.binaryTree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 212578960 on 8/24/2017.
 */
public class HeightOfBinaryTree {

    public static void main(String[] args){
        BinaryTreeNode root = BinaryTree.getTreeRoot();
        System.out.println(height(root));
    }

    static int height(BinaryTreeNode root) {
        if(root == null){
            return -1;
        }
        int h = 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            BinaryTreeNode node = q.remove();

            if(node == null){
                if(q.isEmpty()){
                    return h;
                }
                h++;
                q.add(null);
                continue;
            }

            BinaryTreeNode left = node.getLeft();
            if(left != null){
                q.add(left);
            }

            BinaryTreeNode right = node.getRight();
            if(right != null){
                q.add(right);
            }
        }
        return h;
    }
}
