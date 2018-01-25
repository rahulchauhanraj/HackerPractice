package com.rahul.hacker.ds.linkedList;

public class SinglyListNode {
    int data;
    SinglyListNode next;

    public SinglyListNode() { }

    public SinglyListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public SinglyListNode(int data, SinglyListNode next) {
        this.data = data;
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public SinglyListNode getNext() {
        return next;
    }

    public void setNext(SinglyListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "SinglyListNode{" +
                "data=" + data +
                '}';
    }
}
