package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	/*
	This project it's developed by Andres Gomez, we are focused on the topic 0 of the course
	Java + Spring + REST Academy - January 2022

	The objective of this project is a simulation of a memory that has 200 spaces where we will save 2 types of
	processes (application and system) both will have a random space between 5 and 20 depending on it's type of process

	 */
        Scanner scanner = new Scanner(System.in);
        int indexP = 1; //initialize the index for the memory spaces
        Memory memory = new Memory();
        memory.fillMemory();//****
        System.out.println("\n");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("This project was developed by Andres Felipe Gomez 01/2022");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String init = "";
        String option = " ";//This variable will print the option processed
        String temporalVariable; //temporal variable used in logic
        boolean temporalVariableB;
        boolean memoryPrintAuto=false;
        boolean printMenuAuto=true;
        boolean printDetailsAuto=false;
        while(!init.equals("off")) {
            if(memoryPrintAuto) {
                memory.printCurrentMemory();
            }
            if(printMenuAuto){
                printMenu();
            }
            if(printDetailsAuto){
                System.out.println("Printing Details");
                System.out.println("Next Process ID: " + indexP);
                System.out.println("Option submitted: "+ option);
                System.out.println("Memory spaces available: "+memory.spaceAvailable());

            }
            init = scanner.next().strip().toLowerCase();
            switch (init) {
                case "c" -> {
                    //This process will create a new process if the memory is available to store it
                    nextOption(init);
                    option=option+("c");
                    //variable that will show the complete function submitted as desired in the challenge
                    if(memory.processInMemory("****")) {
                        temporalVariable = processRequest();
                        if (Objects.equals(temporalVariable, "a")) {
                            //this iff will verify if the process is application or system
                            ApplicationProcess processA = new ApplicationProcess();
                            processA.setId(indexP);
                            processA.CreateSpace();
                            //If there are enough empty spaces the process will be added to the memory
                            if(memory.countProcessInMemory("****")>processA.getSpace())
                            {
                                memory.addingProcess(processA);
                                System.out.println("Process created");
                                option=option+("a");
                            }else {
                                //Exception to allow new process for memory full
                                temporalVariableB=memoryOverFlowException();
                                if(temporalVariableB){
                                    memory.fillMemory();
                                } else{
                                    System.out.println("Memory will not be refill with empty spaces");
                                }
                            }
                        } else {
                        //the process to create a system process will be equal to the application process
                            SystemProcess processS = new SystemProcess();
                            processS.setId(indexP);
                            processS.CreateSpace();
                            if(memory.countProcessInMemory("****")> processS.getSpace())
                            {
                                memory.addingProcess(processS);
                                System.out.println("Process created");
                                option=option+("s");
                            }else {
                                temporalVariableB=memoryOverFlowException();
                                if(temporalVariableB){
                                    memory.fillMemory();
                                }
                            }
                        }
                        indexP++;
                    }else {
                        System.out.println("There are not empty spaces in memory");
                    }
                }
                case "d" -> {
                    //Delete option to delete a process from the memory
                    nextOption(init);
                    temporalVariable = processRequest();//the variable is string with a number
                    option=("d")+temporalVariable;
                    //client submits the id of the process that will be removed
                    //if the process is not in the memory it will not delete any process
                    if(memory.verifyProcessInMemory(temporalVariable)){
                        EmptyProcess processE = new EmptyProcess();
                        //This method will count how many processes the memory has with this id
                        processE.setId(Integer.parseInt(temporalVariable));
                        processE.setSpace(memory.countProcessInMemory(temporalVariable));
                        //This method will define that the empty space will be "****"
                        processE.CreateSpace();
                        memory.deletingProcess(processE);
                        //This process will adjust the memory to the current process
                        memory.adjustMemory(processE);
                    //delete
                        System.out.println("Process removed");
                    }else{
                        System.out.println("The submitted id does not belong to a process in the memory");
                    }
                }
                case "p" -> {
                    //this process will turn on the option to print memory every time it is processed
                    if(!memoryPrintAuto){
                        memoryPrintAuto=true;
                        System.out.println("Auto Memory: on");
                    }
                    else{
                        memoryPrintAuto=false;
                        System.out.println("Auto Memory: off");
                    }
                }
                case "m" ->{
                    //This option turn off the auto menu
                    if(!printMenuAuto){
                        printMenuAuto=true;
                        System.out.println("Auto Menu: on");
                    }
                    else{
                        printMenuAuto=false;
                        System.out.println("Auto Menu: off");
                    }
                }
                case "e" ->{
                    System.out.println("Printing memory");
                    memory.printCurrentMemory();
                }
                case "g" ->{
                    if(!printDetailsAuto){
                        printDetailsAuto=true;
                        System.out.println("Auto details: on");
                    }
                    else{
                        printDetailsAuto=false;
                        System.out.println("Auto details: off");
                    }
                }
                case "h" ->
                    memory.fillMemory();

                default -> {
                    System.out.println("Invalid input");
                    System.out.println("Thank you for testing my app");
                    init = "off";
                }
            }
            System.out.println(option);
            option = (" ");
        }
    }
    public static void nextOption(String init) {
        switch (init) {
            case "c" -> System.out.println("""
                    System is creating a process, please submit the type of process.
                    A for application or S for system:
                    """);
            case "d" -> System.out.println("System is deleting a process, please submit the index of the process: ");
            case "a" -> System.out.println("You selected an application process");
            case "s" -> System.out.println("You selected an system process");
            default -> System.out.println("Your input was invalid");
        }
    }

    public static void printMenu() {
        //This is the menu that will be showed the terminal
        System.out.println(
                """
                        Memory Options                  
                        please select one of the following options
                        --------------------------------------------
                        c. Create process
                        d. Delete process
                        p. Print current memory status Auto
                        m. Print menu Auto
                        e. Print memory
                        g. Print details Auto
                        h. Reset memory spaces
                        """
        );
    }
    public static String processRequest() {
        //this process will stop the terminal until a new process is created
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
    public static boolean memoryOverFlowException(){
        //this process will approve to fill the memory if the client wants to clear the memory
        String temporalVariable;
        boolean x=false;
        System.out.println("There is not enough memory to add the process to the memory");
        System.out.println("Do you want to clear the memory to add more processes? Y/N");
        temporalVariable=processRequest().toLowerCase();
        if(temporalVariable=="y"){
            x=true;
        }
        return x;
    }
}
