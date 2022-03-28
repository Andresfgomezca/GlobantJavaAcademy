package com.company;

import java.util.Arrays;

public class Memory {
    //private int nextSpace;
    String[][] createMemory=new String[20][10];
    void printCurrentMemory() {
        System.out.println("Current Memory Status:");
        // Loop through all rows
        for (int i = createMemory.length-1; i>-1;i--) {
            // Loop through all elements of current row
            for (int j = 0; j <createMemory[i].length; j++) {
                System.out.print(createMemory[i][j] + "|");

            }
            System.out.println("\n");
        }
    }
    void addingProcess(Process process){
        int nextEmptyPositionI=firstEmptyPositionI();
        int nextEmptyPositionJ=firstEmptyPositionJ();
        int currentSpace=process.getSpace();
        //String letter = process.getType();
        //if the process is system it will add a "s" if the process is an application it will be "a"
        //current space needed for the process in the memory will be reduced after writing the first space
        System.out.println("current space "+currentSpace);
        while(currentSpace!=0){
            createMemory[nextEmptyPositionI][nextEmptyPositionJ]=process.getIdMemory();
            currentSpace--;
            nextEmptyPositionJ++;
            if (nextEmptyPositionJ>9){
                nextEmptyPositionJ=0;
                nextEmptyPositionI++;
            }
        }
    }
    int firstEmptyPositionI(){
        //This process looks for the first position empty in the memory and returns its I position
        int nextEmptyPositionI = 0;
        for (int i = 0; i < createMemory.length; i++) {
            for (int j = 0; j < createMemory[i].length; j++) {
                if (createMemory[i][j].equals("****")) {
                    nextEmptyPositionI = i;
                    return nextEmptyPositionI;
                }
            }
        }
        return nextEmptyPositionI;
    }
    int firstEmptyPositionJ(){
        //This process looks for the first position empty in the memory and returns its J position
        int nextEmptyPositionJ = 0;
        for (int i = 0; i < createMemory.length; i++) {
            for (int j = 0; j < createMemory[i].length; j++) {
                if (createMemory[i][j].equals("****")) {
                    nextEmptyPositionJ = j;
                    return nextEmptyPositionJ;
                }
            }
        }
        return nextEmptyPositionJ;
    }
    void fillMemory() {
        for (String[] strings : createMemory) {
            Arrays.fill(strings, "****");
        }
    }
    void deletingProcess(Process process){
        int nextBusyPositionI=firstBusyPositionI(process);
        int nextBusyPositionJ=firstBusyPositionJ(process);
        int currentSpace=process.getSpace();

        //String letter = process.getType();
        //if the process is system it will add a "s" if the process is an application it will be "a"
        //current space needed for the process in the memory will be reduced after writing the first space
        while(currentSpace!=0){
            createMemory[nextBusyPositionI][nextBusyPositionJ]= process.getIdMemory();//****
            currentSpace--;
            nextBusyPositionJ++;
            if (nextBusyPositionJ>9){
                nextBusyPositionJ=0;
                nextBusyPositionI++;
            }
        }
    }
    int firstBusyPositionI(Process process){
        String s = (String.valueOf(process.getId()).substring(1, 4));
        //this process verifies the next position busy in the memory and return its I position
        //for the process submitted
        String verify1 = "a"+(s);
        String verify2 = "s"+(s);
        //This process will look for the next position I busy for the process that we want to delete.
        int nextBusyPositionI = 0;
        for (int i = 0; i < createMemory.length; i++) {
            for (int j = 0; j < createMemory[i].length; j++) {
                //if (createMemory[i][j].equals(process.getIdMemory())||createMemory[i][j].equals(process.getIdMemory())) {
                if (createMemory[i][j].equals(verify1)||createMemory[i][j].equals(verify2)) {
                    nextBusyPositionI = i;
                    return nextBusyPositionI;
                }
            }
        }
        return nextBusyPositionI;
    }
    int firstBusyPositionJ(Process process){
        //this process verifies the next position busy in the memory and return its J position
        String s = (String.valueOf(process.getId()).substring(1, 4));
        //this method verify if there is any kind of process with this id
        String verify1 = "a"+(s);
        String verify2 = "s"+(s);
        //This process will look for the next position J busy for the process that we want to delete.
        int nextBusyPositionJ = 0;
        for (int i = 0; i < createMemory.length; i++) {
            for (int j = 0; j < createMemory[i].length; j++) {
                //if (createMemory[i][j].equals(process.getIdMemory())) {
                if (createMemory[i][j].equals(verify1)||createMemory[i][j].equals(verify2)) {
                    nextBusyPositionJ = j;
                    return nextBusyPositionJ;
                }
            }
        }
        return nextBusyPositionJ;
    }
    void adjustMemory(Process process){
        int currentSpace=process.getSpace();//We call the amount of empty spaces.
        //this variable will assist with the logic to read the matrix if the process occupy more than 1 row
        int iTemp=currentSpace>10 ? 2:1;
        int jTemp= currentSpace>10 ? 2:1;//this variable will assist with the logic to read the matrix
        //This while loop will adjust the empty spaces by J
        while(jTemp!=0){
            for (int i = 0; i<20;i++) {
                // Loop through all elements of current row
                for (int j = 0; j< 10; j++) {
                    if(createMemory[i][j]==("****")){
                        if(i<19) {
                            createMemory[i][j] = createMemory[i + 1][j];
                            createMemory[i + 1][j] = "****";
                        }
                    }
                }
                //currentSpace=countProcessInMemory("****");//verify the amount of empty spaces in memory
            }
            jTemp--;
        }
        //This while loop will adjust the empty spaces by I
        while(iTemp!=0){
            for (int i = 0; i<20;i++) {
                // Loop through all elements of current row
                for (int j = 0; j< 10; j++) {
                    if(createMemory[i][j]==("****")){
                        if(j<9) {
                            createMemory[i][j] = createMemory[i][j+1];
                            createMemory[i][j+1] = "****";
                        }
                    }
                }
            }
            iTemp--;
        }
    }
    boolean verifyProcessInMemory(String id){
        boolean x=false;
        String s = "00"+id;
        //this method verify if there is any kind of process with this id
        String verify1 = "a"+(s);
        String verify2 = "s"+(s);
        if (processInMemory(verify1)||processInMemory(verify2)){
            //this method verify if there is an application process or system process in the memory
            x = true;
        }
        return x;
    }
    boolean processInMemory(String verify){
        //This process verify if the processes submitted is a process in the memory
        boolean x=false;
        for (int i = 0; i < createMemory.length; i++) {
            for (int j = 0; j < createMemory[i].length; j++) {
                if (createMemory[i][j].equalsIgnoreCase(verify)) {
                    x = true;
                }
            }
        }
        return x;
    }
    int countProcessInMemory(String verify){
        //this process counts how many times there is a process in the memory
        String s = "00"+verify;
        //this process allow us to use the method substring to create the id in memory
        String verify1 = "a"+(s);
        String verify2 = "s"+(s);
        int x=0;
        for (int i = 0; i < createMemory.length; i++) {
            for (int j = 0; j < createMemory[i].length; j++) {
                if (createMemory[i][j].equals(verify1)||createMemory[i][j].equals(verify2)||createMemory[i][j].equals(verify)) {
                    //this process counts processes in the memory.
                    x++;
                }
            }
        }
        return x;
    }
    int spaceAvailable(){
        //this method confirms if there are spaces available.
        int y=0;
        for (String[] strings : createMemory) {
            for (String string : strings) {
                if (string.equals("****")) {
                    y++;
                }
            }
        }
        return y;
    }
}
