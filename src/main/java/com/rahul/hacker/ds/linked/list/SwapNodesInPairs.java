package com.rahul.hacker.ds.linked.list;

public class SwapNodesInPairs {

    public static void main(String[] args) {

        int k = 2;
        SinglyListNode head = getSinglyLinkedList();
        printSinglyLinkedList(head);
        int len = getSinglyLinkedListSize(head);
        head = swapPairs(null, head, k, len);
        printSinglyLinkedList(head);
    }

    private static SinglyListNode swapPairs(SinglyListNode last, SinglyListNode head, int k, int len) {

        if (len < k) {
            return head;
        }

        int count = 0;
        SinglyListNode prev = null;
        SinglyListNode newLast = head;

        while (count < k) {

            SinglyListNode next = head.getNext();
            head.setNext(prev);
            prev = head;
            head = next;

            count++;
        }

        if (last != null) {
            last.setNext(prev);
        }
        newLast.setNext(head);

        swapPairs(newLast, head, k, len-k);

        return prev;
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
                System.out.print(head.getData() + "  ");
                head=head.getNext();
            }
        }

        System.out.println();
    }
}
