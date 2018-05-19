package com.rahul.interviews.microsoft;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;

/**
 * Input :

 2
 3 3
 5 6 3
 8 4 2
 16 4
 2 2 7 5 3 3 7 3 3 6 8 3 0 5 0 6
 4 3 3 8

 Output :

 1 4 0 5
 2 2 7 5 3 3 7 3 3 6 8 3 4 8 4 4

 */
public class SumOfTwoLinkedListNumbers {

    public static void main (String[] args) {
        Scanner sc = ScannerUtil.getScanner();
        int t = sc.nextInt();
        for(int i = 0; i< t; i++){
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            Node head1= null;
            Node last1 = null;
            int size1 = s1;
            while(s1>0){
                Node node = new Node(sc.nextInt());
                if(head1 == null){
                    head1 = node;
                }else{
                    last1.next = node;
                }
                last1 = node;
                s1--;
            }

            Node head2 = null;
            Node last2 = null;
            int size2 = s2;
            while(s2>0){
                Node node = new Node(sc.nextInt());
                if(head2 == null){
                    head2 = node;
                }else{
                    last2.next = node;
                }
                last2 = node;
                s2--;
            }
            Node h = addElements(head1, size1, head2, size2);

            while(h != null){
                System.out.print(h.data + " ");
                h = h.next;
            }

            System.out.println();
        }
    }

    private static Node addElements(Node head1, int s1, Node head2, int s2){
        int diff = Math.abs(s1-s2);
        Node maxHead;
        Node minHead;
        if(s1 > s2){
            maxHead = head1;
            minHead = head2;
        }else{
            maxHead = head2;
            minHead = head1;
        }
        Node newHead = addElements(maxHead, minHead, diff);
        if(newHead.data == 0){
            return newHead.next;
        }else {
            return newHead;
        }
    }

    private static Node addElements(Node head1, Node head2, int diff){
        if(head1 == null){
            return null;
        }
        Node head;
        int sum;
        if(diff > 0) {
            head = addElements(head1.next, head2, diff - 1);
            if(head != null) {
                sum = head.data + head1.data;
            }else{
                sum = head1.data;
                head = new Node();
            }

        }else{
            head = addElements(head1.next, head2.next, diff);
            if(head != null) {
                sum = head.data + head1.data + head2.data;
            }else{
                sum = head1.data + head2.data;
                head = new Node();
            }
        }
        int rem = sum%10;
        int div = sum/10;
        head.data = rem;
        Node newHead = new Node(div);
        newHead.next = head;
        return newHead;
    }

    static class Node{
        Node next;
        int data;
        public Node() {
        }
        public Node(int data) {
            this.data = data;
        }
    }
}
