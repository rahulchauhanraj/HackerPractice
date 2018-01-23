package com.rahul.hacker.ds.linkedList;

import org.springframework.util.Assert;

public class SnakeOrSnail {

    public static void main (String args[]) {
        SinglyListNode head1 = getSnakeSinglyLinkedList();
        Assert.isTrue(!isSnail(head1));
        SinglyListNode head2 = getSnailSinglyLinkedList();
        Assert.isTrue(isSnail(head2));
        System.out.println("Success.");
    }

    private static boolean isSnail(SinglyListNode head) {
        boolean isSnail = false;

        if(head == null) {
            return isSnail;
        }


        SinglyListNode p1 = head;
        SinglyListNode p2 = head.getNext();

        while(p1 != null && p2 != null) {

            p2 = p2.getNext();

            if(p2 == null) {
                break;
            }

            p1 = p1.getNext();

            if(p1 == p2) {
                isSnail = true;
                break;
            }
            p2 = p2.getNext();
        }

        if(isSnail) {
            p1 = head;

            while (p1 != p2) {
                p1 = p1.getNext();
                p2 = p2.getNext();
            }

            System.out.println("Snail start at node : " + p1.getData());
            int loopCount = 1;
            p1 = p1.getNext();
            while(p1 != p2) {
                p1 = p1.getNext();
                loopCount++;
            }
            System.out.println("Loop count : " + loopCount);
        } else {
            System.out.println("Snake ");
        }

        return isSnail;
    }

    private static SinglyListNode getSnailSinglyLinkedList() {
        SinglyListNode node8 = new SinglyListNode();
        node8.setData(8);
        SinglyListNode node7 = new SinglyListNode(7, node8);
        SinglyListNode node6 = new SinglyListNode(6, node7);
        SinglyListNode node5 = new SinglyListNode(5, node6);
        SinglyListNode node4 = new SinglyListNode(4, node5);
        SinglyListNode node3 = new SinglyListNode(3, node4);
        SinglyListNode node2 = new SinglyListNode(2, node3);
        SinglyListNode node1 = new SinglyListNode(1, node2);
        node8.setNext(node3);
        return node1;
    }

    private static SinglyListNode getSnakeSinglyLinkedList() {
        SinglyListNode node7 = new SinglyListNode(7, null);
        SinglyListNode node6 = new SinglyListNode(6, node7);
        SinglyListNode node5 = new SinglyListNode(5, node6);
        SinglyListNode node4 = new SinglyListNode(4, node5);
        SinglyListNode node3 = new SinglyListNode(3, node4);
        SinglyListNode node2 = new SinglyListNode(2, node3);
        SinglyListNode node1 = new SinglyListNode(1, node2);
        return node1;
    }
}
