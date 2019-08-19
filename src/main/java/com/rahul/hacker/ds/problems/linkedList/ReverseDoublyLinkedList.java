package com.rahul.hacker.ds.problems.linkedList;

import com.rahul.hacker.ds.linked.list.DoublyLinkedListNode;
import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;

/**
 * Created by 212578960 on 8/25/2017.
 */
public class ReverseDoublyLinkedList {


    public static void main(String[] args) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();

        DoublyLinkedListNode head = null;
        DoublyLinkedListNode last = null;

        for(int a_i = 0; a_i < n; a_i++){
            int data = in.nextInt();
            DoublyLinkedListNode node = new DoublyLinkedListNode();
            node.setData(data);

            if(head == null){
                head = node;
            }
            if(last != null){
                last.setNext(node);
                node.setPrev(last);
            }
            last = node;
        }

        reverse(head);
        in.close();
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if(head == null || head.getNext() == null){
            return head;
        }

        DoublyLinkedListNode last = head;
        DoublyLinkedListNode cur = head.getNext();
        while(cur != null){
            DoublyLinkedListNode temp = cur.getNext();
            cur.setNext(last);
            last.setPrev(cur);
            last = cur;
            cur = temp;
        }
        //head.next = null;
        //last.prev = null;
        return last;
    }
}
