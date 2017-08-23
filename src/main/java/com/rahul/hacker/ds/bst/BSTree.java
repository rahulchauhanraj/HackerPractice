package com.rahul.hacker.ds.bst;

/**
 * Created by 212578960 on 7/29/2017.
 */
public class BSTree {

    public static void main(String[] args){
        BSTNode root = getTreeRoot();
        printTree(root);
        BSTNode head = convertBSTToDLL(root);
        root = convertDLLToBST(head);
        printTree(root);
        System.out.println();
        printBetween(root, 4, 16);
    }

    private static void printBetween(BSTNode root, int a, int b){
        if(root == null){
            return;
        }

        printBetween(root.getLeft(), a, b);
        int data = root.getData();
        if(data >= a && data <= b){
            System.out.print(data + "  ");
        }

        printBetween(root.getRight(), a, b);
    }

    private static BSTNode convertDLLToBST(BSTNode head){
        if(head == null || head.getRight() == null){
            return head;
        }

        BSTNode mid = findMidOfDLL(head);

        BSTNode midLeft = mid.getLeft();
        if(midLeft != null){
            midLeft.setRight(null);
        }
        BSTNode midRight = mid.getRight();
        if(midRight != null){
            midRight.setLeft(null);
        }

        BSTNode leftHead = head;
        BSTNode rightHead = midRight;

        mid.setLeft(convertDLLToBST(leftHead));
        mid.setRight(convertDLLToBST(rightHead));
        return mid;
    }

    private static BSTNode findMidOfDLL(BSTNode head){
        BSTNode first = head;
        BSTNode second = head;
        while(second != null){
            second = second.getRight();
            if(second != null){
                first = first.getRight();
                second = second.getRight();
            }
        }

        return first;
    }

    private static BSTNode convertBSTToDLL(BSTNode root){
        BSTNode node = root;
        BSTNode head = null;
        while(node != null){
            head = node;
            node = node.getLeft();
        }

        convertBSTToDLL(root, new BSTNode[1]);
        printDLL(head);
        return head;
    }

    private static void convertBSTToDLL(BSTNode root, BSTNode[] leftNode){
        if(root == null){
            return;
        }
        convertBSTToDLL(root.getLeft(), leftNode);
        BSTNode left = leftNode[0];
        root.setLeft(left);
        if(left != null){
            left.setRight(root);
        }
        leftNode[0] = root;
        convertBSTToDLL(root.getRight(), leftNode);
    }

    public static void printTree(BSTNode root){
        if(root == null){
            return;
        }
        printTree(root.getLeft());
        System.out.print(root.getData() + "  ");
        printTree(root.getRight());
    }

    public static void printDLL(BSTNode root){
        if(root == null){
            return;
        }

        BSTNode node = root;
        BSTNode last = null;
        System.out.println();
        while(node != null){
            last = node;
            System.out.print(node.getData() + "  ");
            node = node.getRight();
        }

        System.out.println();
        node = last;
        while(node != null){
            System.out.print(node.getData() + "  ");
            node = node.getLeft();
        }
        System.out.println();
    }

    public static BSTNode getTreeRoot(){
        BSTNode root = new BSTNode(8);
        BSTNode node4 = new BSTNode(4);
        BSTNode node16 = new BSTNode(16);
        root.setLeft(node4);
        root.setRight(node16);
        BSTNode node2 = new BSTNode(2);
        BSTNode node7 = new BSTNode(7);
        node4.setLeft(node2);
        node4.setRight(node7);

        BSTNode node14 = new BSTNode(14);
        BSTNode node20 = new BSTNode(20);
        node16.setLeft(node14);
        node16.setRight(node20);
        return root;
    }
}
