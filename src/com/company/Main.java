package com.company;


import java.util.*;

public class Main {
    Integer a;
 public Main(Integer a){
      this.a = Objects.requireNonNull(a,"NO NULL");

 }
    private void display(){
     System.out.println("display inside main");
 }
	public int add(int a , int b){
		return a+b;
}
   public static double subtract(double a , double b)
{		return Math.abs(a-b);
}
	public void printHello(){

     System.out.println("HELLO");
	}
    public static void main(String[] args) {
     Main obj=new Main(null);
        obj.printHello();
        System.out.println(obj.add(5,4));
        obj.display();
        Main obj2 = new Main((Integer) 5);
        System.out.println(obj2.a);
    }

    
}

