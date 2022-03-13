package com.company;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;
class Solution {
    public int solution(String S, int[] X, int[] Y) {
        int n = S.length();
        double [] distance = new double[n];
        for(int i=0;i<n;i++){
            double temp = Math.sqrt(Math.pow(X[i],2)+Math.pow(Y[i],2));
            distance [i] =temp;
        }
        Map<Character,List<Integer>> map=new HashMap<>();
        for(int i =0;i<26;i++){
            char curr = (char)('A'+i);
            map.put(curr,new ArrayList<Integer>());
        }
        for(int i =0;i<n;i++){
            map.get(S.charAt(i)).add(i);
        }
        for(Character c : map.keySet()){
            List<Integer> temp = map.get(c);
            Collections.sort(temp, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(distance[o1]>distance[o2])
                        return -1;
                    return 1;
                }
            });
            map.put(c,temp);

        }
        int ans=0;
        double min = Double.MAX_VALUE;
        ArrayList<Character> l = new ArrayList<>();
        for(int i =0;i<26;i++){
            char curr = (char)('A'+i);
            if(!map.get(curr).isEmpty())
            l.add(curr);
        }
        l.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (map.get(o1).get(0) > map.get(o2).get(0))
                    return -1;
                return 1;
            }
        });

            for(Character curr :l){
            double val ;
            if(!map.get(curr).isEmpty()){
                val = map.get('A').get(0);
                if(map.get(curr).get(0)<min)
                    ans++;
                if(map.get(curr).size()>1)
                    min=Math.min(min,map.get(curr).get(1));
            }


        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println("hello"+ Math.pow(-2,2));
        System.out.println("wassup");

    }
}

