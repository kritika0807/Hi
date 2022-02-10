package com.company;

public class SubClass implements SuperInterface {

    SubClass(){
        System.out.println("Inside SubClass");

    }
     public void display(){

        System.out.println("display inside SubClass");
    }

    @Override
    public int add(int a, int b) {
        return 0;
    }

    @Override
    public int subtract (int a, int b) {
        throw new IllegalStateException() ;


    }

    public static void main(String[] args) {
        SubClass obj = new SubClass();
        obj.subtract(7,8 );
    }



}
