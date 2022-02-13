package com.company;

import java.util.Date;

public class Period {
    private  Date startDate;
    private  Date endDate;
    Period(Date startDate , Date endDate){
        this.startDate=new Date(startDate.getTime());
        System.out.println(this.startDate);
        this.endDate=new Date(endDate.getTime());
        System.out.println(this.endDate);
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void display() {
        System.out.println(startDate+" "+ endDate);
    }

    public static void main(String[] args) {
        Date s = new Date();
        System.out.println(s);
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e ){
            System.out.println("Caught an Exception");
        }
        Date e= new Date();
        Period p=new Period(s,e);
        p.setStartDate(new Date());
        p.display();



    }
}
