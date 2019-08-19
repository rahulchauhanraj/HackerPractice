package com.rahul.hacker.ds.problems.binaryTree;

import com.rahul.hacker.ds.binary.tree.BinaryTree;
import com.rahul.hacker.ds.binary.tree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 212578960 on 8/23/2017.
 */
public class LevelOrderTraversal {
    public static void main(String[] args){
        BinaryTreeNode root = BinaryTree.getTreeRoot();
        //levelOrderTraversal(root);
        printByLevelOrderTraversal(root);
    }

    private static void levelOrderTraversal(BinaryTreeNode root){
        if(root == null){
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.remove();

            System.out.println(node.getData());

            BinaryTreeNode left = node.getLeft();
            if(left != null){
                queue.add(left);
            }

            BinaryTreeNode right = node.getRight();
            if(right != null){
                queue.add(right);
            }
        }
    }

    private static void printByLevelOrderTraversal(BinaryTreeNode root){
        if(root == null){
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.remove();

            if(node == null){
                if(!queue.isEmpty()){
                    System.out.println();
                    queue.add(null);
                    continue;
                }
                break;
            }
            System.out.print(node.getData() + "  ");

            BinaryTreeNode left = node.getLeft();
            if(left != null){
                queue.add(left);
            }

            BinaryTreeNode right = node.getRight();
            if(right != null){
                queue.add(right);
            }
        }
    }
}
