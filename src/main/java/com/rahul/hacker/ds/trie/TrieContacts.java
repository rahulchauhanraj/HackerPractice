package com.rahul.hacker.ds.trie;

import com.rahul.hacker.util.ScannerUtil;

import java.util.Scanner;

public class TrieContacts {

    private static Node root;

    private static final Scanner sc = ScannerUtil.getScanner();

    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = sc.nextLine().split(" ");

            String op = opContact[0];

            String contact = opContact[1];

            switch (op){
                case "add" :
                    addContact(contact);
                    break;
                case "find" :
                    int count = searchContact(contact);
                    System.out.println(count);
                    break;
            }
        }

        sc.close();
    }

    private static void addContact(String contact) {
        if(root == null){
            root = new Node();
        }
        Node current = root;
        for(int i = 0; i< contact.length(); i++){
            char ch = contact.charAt(i);
            int index = ch - 97;
            Node node;
            if (current.childs != null) {
                node = current.childs[index];
            } else {
                current.childs = new Node[26];
                node = current.childs[index];
            }

            if(node == null){
                node = new Node();
                node.ch = ch;
                current.childs[index] = node;
            }

            node.count++;
            current = node;
        }
        current.endOfString = true;
    }

    private static int searchContact(String contact){
        if(root == null){
            return 0;
        }
        Node current = root;
        for(int i = 0; i< contact.length(); i++){
            char ch = contact.charAt(i);
            int index = ch - 97;
            Node node;
            if (current.childs != null) {
                node = current.childs[index];
            } else {
                return 0;
            }
            current = node;
            if(current == null){
                return 0;
            }
        }

        return current.count;
    }

    static class Node {
        char ch;
        boolean endOfString;
        Node[] childs;
        int count;

        @Override
        public String toString() {
            return "Node{" +
                    "ch=" + ch +
                    ", endOfString=" + endOfString +
                    ", count=" + count +
                    '}';
        }
    }
}
