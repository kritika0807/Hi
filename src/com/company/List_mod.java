package com.company;
import java.util.*;

public class List_mod implements List_imp {
    static int size=0;
    static int index=0;
    static Integer [] arr ;
    List_mod(){
        arr=new Integer[16];
    }
    public int size(){
        return size;
    }
    public void add(int elem){
        arr[index++] =elem;
    }



}
