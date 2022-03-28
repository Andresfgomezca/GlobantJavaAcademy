package com.company;

import java.util.Random;

public class ApplicationProcess implements Process{
    private int id;
    Random random = new Random();
    private final int space= random.nextInt(10)+10; //implement random class to create a random number between 0-10
    private String idMemory;
    private final String type= "a";

    //this method will create a random number in a range of 10 numbers and adding 10 will be number from where
    //it starts
    public void setId(int idd) {
        this.id=idd+1000;
    }

    public String getType() {
        return type;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getSpace() {
        return this.space;
    }

    @Override
    public String getIdMemory() {
        return this.idMemory;
    }

    @Override
    public void CreateSpace() {
        this.idMemory="a"+(String.valueOf(getId()).substring(1, 4)) ;
    }

    @Override
    public void DeleteSpace(Memory x) {

    }
}
