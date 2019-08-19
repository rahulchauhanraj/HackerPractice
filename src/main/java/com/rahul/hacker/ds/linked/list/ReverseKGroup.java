package com.rahul.hacker.ds.linked.list;

public class ReverseKGroup {

    public static void main (String args[]) {
        ListNode head = getSinglyLinkedList();
        printSinglyLinkedList(new ReverseKGroup().reverseKGroup(head, 2));
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        int l = getListSize(head);
        return reverseKGroup(head, k, l);
    }


    private ListNode reverseKGroup(ListNode head, int k, int r) {

        if(r < k || k == 1) {
            return head;
        }

        ListNode p = head;
        ListNode last = null;

        for (int i=0;i<k;i++){

            ListNode tm = p.next;
            p.next = last;
            last = p;
            p = tm;
        }

        ListNode node = reverseKGroup(p, k, r-k);
        head.next = node;

        return last;
    }

    private int getListSize(ListNode head){

        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    private static ListNode getSinglyLinkedList() {
        ListNode head = new ListNode(9);
        ListNode n1 = new ListNode(8);
        ListNode n2 = new ListNode(7);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(5);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return head;
    }

    private static void printSinglyLinkedList(ListNode head) {
        if(head != null){
            while (head != null){
                System.out.print(head.val + "  ");
                head = head.next;
            }
        }

        System.out.println();
    }
}
