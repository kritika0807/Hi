package com.company;

import com.sun.java.accessibility.util.EventQueueMonitor;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    public static Integer[] elements;
    public static final int init_capacity=16;
    public static int size =0;
     Stack() {
    elements = new Integer[init_capacity];
    }
    public void push(int a){
        elements[size++]=a;

    }
    public int pop(){
        int s= elements[--size];
        elements[size]= null;
        return s;
    }



    public static void main(String[] args) {
        Stack stk = new Stack();
        for(int i=0;i<10;i++)
        stk.push(i);
        for(int i=0;i<11;i++)
            try {
                System.out.println(stk.pop());
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println(size);
                throw new EmptyStackException();

            }
    }


    protected void finalize() throws Throwable {
        System.out.println("CALLED FINALIZE");
    }
}
