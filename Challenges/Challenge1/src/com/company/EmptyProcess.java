package com.company;

public class EmptyProcess implements Process {
    private int id;
    private int space=0; //implement random class to create a random number between 0-10
    private String idMemory;
    private final String type= "E";

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

        return this.id;
    }

    public void setSpace(int space) {
        this.space = space;
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
        this.idMemory="****" ;
    }

    @Override
    public void DeleteSpace(Memory x) {

    }
}
