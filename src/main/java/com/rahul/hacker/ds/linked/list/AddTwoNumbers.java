package com.rahul.hacker.ds.linked.list;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode h1 = new ListNode(5);
        ListNode n12 = new ListNode(5);
        ListNode n13 = new ListNode(5);
        h1.next = n12;
        n12.next = n13;
        n13.next = null;

        ListNode h2 = new ListNode(5);
        ListNode n22 = new ListNode(5);
        ListNode n23 = new ListNode(5);
        h2.next = n22;
        n22.next = n23;
        n23.next = null;

        ListNode head = addTwoNumbers(h1, h2);
        System.out.println(head.val);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return addTwoNumbers(l1, l2, 0);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2, int rem) {

        if (l1 == null && l2 == null && rem == 0) {
            return null;
        }

        int newVal = rem;
        if (l1 != null) {
            newVal += l1.val;
        }
        if (l2 != null) {
            newVal += l2.val;
        }

        int newRem = 0;
        if (newVal > 9) {
            newVal = newVal % 10;
            newRem = 1;
        }

        ListNode newNode = new ListNode(newVal);

        if (l1 != null) {
            l1 = l1.next;
        }
        if (l2 != null) {
            l2 = l2.next;
        }
        newNode.next = addTwoNumbers(l1, l2, newRem);
        return newNode;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
