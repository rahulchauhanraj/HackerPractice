package com.rahul.oops;

class Parent {
    public Parent(){
        System.out.println("Parent default constructor");
    }

    public Parent(int value){
        System.out.println("Parent parametrized constructor");
    }

    protected void print(){
        System.out.println("Parent");
    }
}

public class Inheritance extends Parent{

    public Inheritance(){
        this(10);
        System.out.println("Child default constructor");
    }

    public Inheritance(int value){
        //super(10);
        System.out.println("Child parametrized constructor");
    }

    protected void print(){
        System.out.println("Child");
    }

    private static class A{
        public void print(){
            System.out.println("From A");
        }
    }

    private static class B extends A{

    }

    public static void main(String[] s) {
        B b = new B();
        b.print();

        Inheritance i = new Inheritance();
        i.print();

        i = new Inheritance(1);
        i.print();
    }
}
