package com.rahul.hacker;

interface StaticMethodClass {

    static StaticMethodClass getInstance(){
        System.out.println("Printed.");
        return new StaticMethodClass() {
        };
    }
}
