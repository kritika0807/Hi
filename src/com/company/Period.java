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
        System.out.println("HI -> "+startDate+" "+ endDate);
    }

    public static void main(String[] args) throws InterruptedException {
        Date s = new Date();
        System.out.println(s);
        Thread.sleep(10000);
        Date e= new Date();
        Period p=new Period(s,e);
        p.setStartDate(new Date());
        p.display();


    }
}
