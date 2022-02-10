package com.company;

import java.util.*;

public class map  {


    public static void main(String[] args) throws InterruptedException {
        Integer a = 5;
        WeakHashMap<Integer, String > maps= new WeakHashMap<>();
        maps.put(a,"five"); 
        System.out.println(maps);
        a=null;
        System.gc();
        System.out.println(a);
        Thread.sleep(1);
        System.out.println(maps);
    }

}
