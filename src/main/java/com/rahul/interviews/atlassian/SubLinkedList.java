package com.rahul.interviews.atlassian;

class LLNode{
    int data;
    LLNode next;
}

public class SubLinkedList {
    public static void main(String[] args){
        LLNode l1 = getMainLinkedList();
        LLNode l2 = getSubLinkedList();
        System.out.println(findSubList(l1, l2));
    }

    private static int findSubList(LLNode l1, LLNode l2){
        int ind = -1;
        if (l1 == null || l2 == null) {
            return ind;
        }

        LLNode p1 = l1;
        LLNode p2 = l2;
        int count = 0;
        while(p1 != null && p2 != null){
            if (p1.data == p2.data){
                p2 = p2.next;
                if(ind == -1){
                    ind = count;
                }
            } else {
                ind = -1;
                p2 = l2;
            }
            p1 = p1.next;
            count++;
        }

        if(p2 != null){
            return -1;
        }
        return ind;
    }

    private static LLNode getMainLinkedList(){
        LLNode l1 = new LLNode();
        l1.data = 4;
        LLNode l11 = new LLNode();
        l11.data = 8;
        l1.next = l11;
        LLNode l12 = new LLNode();
        l12.data = 3;
        l11.next = l12;
        LLNode l13 = new LLNode();
        l13.data = 5;
        l12.next = l13;
        LLNode l14 = new LLNode();
        l14.data = 6;
        l13.next = l14;
        LLNode l15 = new LLNode();
        l15.data = 8;
        l14.next = l15;
        LLNode l16 = new LLNode();
        l16.data = 9;
        l15.next = l16;
        LLNode l17 = new LLNode();
        l17.data = 4;
        l16.next = l17;
        LLNode l18 = new LLNode();
        l18.data = 5;
        l17.next = l18;
        LLNode l19 = new LLNode();
        l19.data = 6;
        l18.next = l19;
        return l1;
    }

    private static LLNode getSubLinkedList(){
        LLNode l2 = new LLNode();
        l2.data = 8;
        LLNode l16 = new LLNode();
        l16.data = 9;
        l2.next = l16;
        LLNode l17 = new LLNode();
        l17.data = 4;
        l16.next = l17;
        LLNode l18 = new LLNode();
        l18.data = 5;
        l17.next = l18;
        return l2;
    }
}
