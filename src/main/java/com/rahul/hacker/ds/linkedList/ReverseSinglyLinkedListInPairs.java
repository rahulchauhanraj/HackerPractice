package com.rahul.hacker.ds.linkedList;

public class ReverseSinglyLinkedListInPairs {

    // 1-> 2-> 3-> 4-> X
    // 2-> 1-> 4-> 3-> X

    public static void main(String args[]) {
        SinglyListNode head = getSinglyLinkedList();
        int k = 4;
        SinglyListNode newHead = reverse(head, k);
        printSinglyLinkedList(newHead);
    }

    private static SinglyListNode reverse(SinglyListNode head, int k) {
        int size = getSinglyLinkedListSize(head);
        SinglyListNode[] newHead = new SinglyListNode[1];
        reverse(null, head, k, size, newHead);
        return newHead[0];
    }

    private static SinglyListNode reverse(SinglyListNode last, SinglyListNode head, int k, int remaining, SinglyListNode[] newHead) {
        if(k > remaining) {
            return null;
        }

        int count = 0;

        SinglyListNode start = head;
        SinglyListNode prev = null;
        while(count < k) {
            SinglyListNode temp = head.getNext();
            head.setNext(prev);
            prev = head;
            head = temp;
            count++;
        }
        if(newHead[0] == null) {
            newHead[0] = prev;
        }
        if(last != null) {
            last.setNext(prev);
        }
        start.setNext(head);

        return reverse(start, head, k, remaining-k, newHead);
    }

    private static int getSinglyLinkedListSize(SinglyListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.getNext();
        }
        return count;
    }


    private static SinglyListNode getSinglyLinkedList() {
        SinglyListNode node9 = new SinglyListNode(9);
        SinglyListNode node8 = new SinglyListNode(8, node9);
        SinglyListNode node7 = new SinglyListNode(7, node8);
        SinglyListNode node6 = new SinglyListNode(6, node7);
        SinglyListNode node5 = new SinglyListNode(5, node6);
        SinglyListNode node4 = new SinglyListNode(4, node5);
        SinglyListNode node3 = new SinglyListNode(3, node4);
        SinglyListNode node2 = new SinglyListNode(2, node3);
        SinglyListNode node1 = new SinglyListNode(1, node2);
        return node1;
    }

    private static void printSinglyLinkedList(SinglyListNode head) {
        if(head != null){
            while (head != null){
                System.out.println(head.getData());
                head=head.getNext();
            }
        }
    }

}
