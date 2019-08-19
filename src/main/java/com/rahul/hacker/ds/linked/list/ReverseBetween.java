package com.rahul.hacker.ds.linked.list;

public class ReverseBetween {

    public static void main(String[] args) {

        System.out.println(~1 +2);

        /*ListNode h1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        h1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode head = reverseBetween(h1, 1,2);
        System.out.println(head.val);*/
    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {

        if(head == null) {
            return null;
        }

        int ind;
        ListNode start = null;
        ListNode startHead;

        if(m > 1) {
            start = head;
            ind = 1;

            while (ind < m - 1) {
                start = start.next;
                ind++;
            }
            startHead = start.next;
        } else {
            startHead = head;
        }

        ListNode newStart = reverseList(start, startHead, n-m+1);
        if(start == null) {
            return newStart;
        } else {
            start.next = newStart;
        }
        return head;
    }

    private static ListNode reverseList(ListNode start, ListNode head, int v) {

        int count = 1;
        ListNode last = null;
        ListNode p = head;

        while (count <= v) {
            ListNode tm = p.next;
            p.next = last;
            last = p;
            p = tm;
            count++;
        }

        if (start != null) {
            start.next = last;
        }

        head.next = p;
        return last;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
