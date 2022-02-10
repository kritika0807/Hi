package com.company;

public interface List_imp {
    public int size();
    public void add(int elem);
     static public void delete(){
         List_mod.arr[--List_mod.index]=null;
    };

}
