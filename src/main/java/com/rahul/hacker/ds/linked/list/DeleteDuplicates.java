package com.rahul.hacker.ds.linked.list;

public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(4);

        h1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode head = new DeleteDuplicates().deleteDuplicates(h1);
        System.out.println(head.val);
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode lastN = null;
        ListNode last = null;
        ListNode p = head;
        boolean duplicate = false;

        while (p != null) {

            if (last != null) {

                if(last.val != p.val) {

                    if(duplicate) {
                        if (lastN == null) {
                            head = p;
                        } else {
                            lastN.next = p;
                        }
                    } else {
                        lastN = last;
                    }
                    duplicate = false;
                } else {
                    duplicate = true;
                }
            }

            last = p;
            p = p.next;
        }

        if (duplicate) {
            if (lastN != null) {
                lastN.next = null;
            }else {
                head = p;
            }
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
