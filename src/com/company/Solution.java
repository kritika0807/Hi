package com.company;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();
        for(int i=-3;i<3;i++)
            list.add(i);
        for(int i=0;i<3;i++)
            list.remove((Integer) i);
        for(int i: list)
            System.out.println(i);
        char [] temp = {'a','e','i','o','u'};
        System.out.println(String.valueOf(temp));
        System.out.println(String.valueOf((Object)temp));
    }
}
