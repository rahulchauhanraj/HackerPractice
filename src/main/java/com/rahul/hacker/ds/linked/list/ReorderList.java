package com.rahul.hacker.ds.linked.list;

public class ReorderList {

    public void reorderList(ListNode head) {

        if(head == null) {
            return;
        }

        int l = getSize(head);

        ListNode p1 = head;

        int l2 = l % 2 == 0 ? l/2 : l/2 +1;

        for(int i=1; i<l2;i++){
            p1 = p1.next;
        }

        ListNode h = p1.next;
        p1.next = null;

        h = reverse(h);
        ListNode p2 = head;

        while (h != null){
            ListNode t = h.next;

            ListNode t2 = p2.next;
            p2.next = h;
            h.next = t2;
            p2 = t2;

            h = t;
        }

    }

    private int getSize(ListNode head) {

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
