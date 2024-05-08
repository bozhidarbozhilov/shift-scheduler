package com.bozhilov.shiftscheduler.common.utils;

public class Counter {
    private int counter;

    public Counter(){
        counter = 0;
    }

    public void increment(){
        ++counter;
    }
    public int get(){
        return counter;
    }
     public int incrementAndGet(){
        return ++counter;
     }
     public int getAndIncrement(){return counter++;}
     public void clear(){
        counter=0;
     }

}
