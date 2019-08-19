package com.rahul.hacker.ds.linked.list;

public class AddTwoNumbers2 {

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

    public static ListNode addTwoNumbers(ListNode n1, ListNode n2) {

        int l1 = getSize(n1);
        int l2 = getSize(n2);

        if (l1 > l2) {
            n2 = getWithEmptyNodes(l1-l2, n2);
        }

        if (l2 > l1) {
            n1 = getWithEmptyNodes(l2-l1, n1);
        }

        ListNode head = addTwoLists(n1, n2);

        if (head != null && head.val > 9) {
            ListNode node = new ListNode(head.val % 10);
            head.val = 1;
            node.next = head.next;
            head.next = node;
        }

        return head;
    }

    private static ListNode addTwoLists(ListNode n1, ListNode n2) {

        if(n1 == null || n2 == null) {
            return null;
        }

        ListNode ret = addTwoLists(n1.next, n2.next);

        int v = n1.val + n2.val;

        if (ret != null) {

            int val = ret.val;
            int rem = 0;
            if (val > 9) {
                val = val % 10;
                rem = 1;
                ret.val = val;
            }
            v += rem;
        }

        ListNode node = new ListNode(v);
        node.next = ret;
        return node;
    }

    private static int getSize(ListNode n){
        int count = 0;
        while (n != null) {
            count++;
            n = n.next;
        }
        return count;
    }

    private static ListNode getWithEmptyNodes(int l, ListNode n) {

        ListNode head = new ListNode(0);
        int count = 1;
        ListNode p = head;

        while (count < l) {
            ListNode p1 = new ListNode(0);
            p.next = p1;
            p = p1;
            count++;
        }

        p.next = n;
        return head;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
