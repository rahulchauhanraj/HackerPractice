package com.rahul;

public class Main {

    public static void main(String[] args) {
        Long n = 9007042835703847503L;
        String val = Long.toString(Long.valueOf(String.valueOf(n), 10), 2);
        System.out.println(val);
    }
}
