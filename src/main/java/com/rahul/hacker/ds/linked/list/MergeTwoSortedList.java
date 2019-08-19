package com.rahul.hacker.ds.linked.list;

public class MergeTwoSortedList {


    public SinglyListNode mergeTwoLists(SinglyListNode l1, SinglyListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        SinglyListNode temp;
        if (l1.data < l2.data) {
            temp = l1;
            l1 = l1.next;
        } else {
            temp = l2;
            l2 = l2.next;
        }

        SinglyListNode head = mergeTwoLists(l1, l2);
        temp.next = head;
        return temp;
    }
}
