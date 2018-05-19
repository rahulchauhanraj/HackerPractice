package com.rahul.interviews.microsoft;

public class DeleteGreaterNodeLinkedList {

    public static void main(String args[]){
        Node head = new Node(10);
        head.next = new Node(6);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(5);
        Node newHead = delete(head, 5);
        while(newHead != null){
            System.out.println(newHead.data);
            newHead = newHead.next;
        }
    }

    private static Node delete(Node head, int k){
        Node current = head;
        Node last = null;
        while(current != null){
            if(current.data > k){
                if(last != null){
                    last.next = current.next;
                }else{
                    head = current.next;
                }
            }else{
                last = current;
            }

            current = current.next;
        }

        return head;
    }

    static class Node
    {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
