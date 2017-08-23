package com.rahul.hacker.ds.problems.binaryTree;

import com.rahul.hacker.ds.binaryTree.BinaryTree;
import com.rahul.hacker.ds.binaryTree.BinaryTreeNode;

import java.util.Stack;

/**
 * Created by 212578960 on 8/23/2017.
 */
public class ZigZagTraversal {
    public static void main(String[] args){
        BinaryTreeNode root = BinaryTree.getTreeRoot();
        zigZagTraversal(root);
    }

    private static void zigZagTraversal(BinaryTreeNode root){
        if(root == null){
            return;
        }
        boolean isEven = true;
        Stack<BinaryTreeNode> stackEven = new Stack<>();
        Stack<BinaryTreeNode> stackOdd = new Stack<>();
        stackEven.add(root);
        while(!stackEven.isEmpty() || !stackOdd.isEmpty()){
            Stack<BinaryTreeNode> popStack;
            Stack<BinaryTreeNode> pushStack;
            if(isEven){
                popStack = stackEven;
                pushStack = stackOdd;
            }else{
                popStack = stackOdd;
                pushStack = stackEven;
            }

            while(!popStack.isEmpty()){
                BinaryTreeNode node = popStack.pop();
                System.out.print(node.getData() + "  ");
                BinaryTreeNode left = node.getLeft();
                BinaryTreeNode right = node.getRight();

                if(isEven){
                    if(left != null){
                        pushStack.push(left);
                    }
                    if(right != null){
                        pushStack.push(right);
                    }
                }else{
                    if(right != null){
                        pushStack.push(right);
                    }
                    if(left != null){
                        pushStack.push(left);
                    }
                }


            }
            System.out.println();
            isEven = !isEven;
        }
    }
}
