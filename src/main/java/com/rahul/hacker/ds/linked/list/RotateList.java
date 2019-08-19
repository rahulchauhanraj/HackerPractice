package com.rahul.hacker.ds.linked.list;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if(k == 0 || head == null) {
            return head;
        }

        int r = getSize(head);

        k = k%r;

        if(k == 0) {
            return head;
        }

        ListNode p1 = head;

        for(int i=0; i<k-r-1;i++){
            p1=p1.next;
        }

        ListNode h = p1.next;
        p1.next = null;

        h = reverse(h);

        while(h != null){
            ListNode t = h.next;
            h.next = head;
            head = h;
            h = t;
        }

        return head;
    }

    private int getSize(ListNode head){

        int count = 0;

        while(head != null){
            count++;
            head= head.next;
        }

        return count;
    }

    private ListNode reverse(ListNode head) {

        ListNode last = null;
        ListNode p = head;

        while(p != null){

            ListNode t = p.next;

            p.next = last;

            last = p;
            p = t;
        }

        return last;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
