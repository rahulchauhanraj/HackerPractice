package com.rahul.hacker.ds.linkedList;

import org.springframework.util.Assert;

public class ReverseSinglyLinkedList {

    public static void main (String args[]) {
        SinglyListNode head = getSnakeSinglyLinkedList();
        printSinglyLinkedList(reverseList(head));
    }

    private static void printSinglyLinkedList(SinglyListNode head) {
        if(head != null){
            while (head != null){
                System.out.println(head.getData());
                head=head.getNext();
            }
        }
    }

    private static SinglyListNode reverseList(SinglyListNode head) {
        SinglyListNode[] a = new SinglyListNode[1];
        reverseSinglyLinkedList(null, head, a);
        return a[0];
    }

    private static void reverseSinglyLinkedList(SinglyListNode prev, SinglyListNode head, SinglyListNode[] a) {
        if(head == null) {
            a[0] = prev;
            return;
        }
        reverseSinglyLinkedList(head, head.getNext(), a);
        head.setNext(prev);
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
