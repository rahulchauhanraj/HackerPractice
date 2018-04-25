package com.rahul.hacker.ds.linkedList;

import java.util.Stack;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SinglyLinkedListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

public class ShortListInBatches {

    public static void main(String[] args) throws Exception {
        SinglyLinkedListNode head = new SinglyLinkedListNode(4);
        SinglyLinkedListNode newNode1 = new SinglyLinkedListNode(8);
        head.next = newNode1;

        SinglyLinkedListNode newNode2 = new SinglyLinkedListNode(3);
        newNode1.next = newNode2;
        SinglyLinkedListNode newNode3 = new SinglyLinkedListNode(9);
        newNode2.next = newNode3;
        SinglyLinkedListNode newNode4 = new SinglyLinkedListNode(1);
        newNode3.next = newNode4;
        SinglyLinkedListNode newNode5 = new SinglyLinkedListNode(3);
        newNode4.next = newNode5;
        SinglyLinkedListNode newNode6 = new SinglyLinkedListNode(2);
        newNode5.next = newNode6;
        newNode6.next = new SinglyLinkedListNode(1);
        SinglyLinkedListNode newHead = sort(3, head);

        while(newHead != null) {
            System.out.println(newHead.data);
            newHead = newHead.next;
        }
    }

    static SinglyLinkedListNode sort(int k, SinglyLinkedListNode head) {

        if(head == null) {
            return null;
        }

        Stack<SinglyLinkedListNode> s1 = new Stack<>();
        Stack<SinglyLinkedListNode> s2 = new Stack<>();
        SinglyLinkedListNode current = head;

        SinglyLinkedListNode newListHead = null;
        SinglyLinkedListNode newListLast = null;

        while (current != null) {
            for (int i = 0; i < k; i++) {
                SinglyLinkedListNode temp = current;
                current = current.next;
                s1.push(temp);
                if (current == null) {
                    break;
                }
            }

            while(!s1.isEmpty()) {
                if(s2.isEmpty()) {
                    s2.push(s1.pop());
                } else {
                    SinglyLinkedListNode n1 = s1.pop();
                    SinglyLinkedListNode n2 = s2.peek();
                    if(n2.data < n1.data) {
                        while(!s2.isEmpty() && n2.data < n1.data) {
                            n2 = s2.peek();
                            s1.push(s2.pop());
                        }
                    }
                    s2.push(n1);
                }
            }

            while (!s2.isEmpty()){
                SinglyLinkedListNode n = s2.pop();

                if( newListHead == null ){
                    newListHead = n;
                    newListLast = n;
                } else {
                    newListLast.next = n;
                }
                newListLast = n;
            }
        }
        if(newListLast != null) {
            newListLast.next = null;
        }

        return newListHead;
    }

}
