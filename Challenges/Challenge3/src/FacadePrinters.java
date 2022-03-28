import Printers.EpsonEcoTankL3110;

import java.util.Scanner;
//This facade will implement the logic for this app
public class FacadePrinters {
    static Scanner scanner = new Scanner(System.in);
    public void challengeExecution(){
        PrinterDirector printerDirector = new PrinterDirector();
        printerDirector.PrintersCreation(); //this method will create in our app the printers available
        int END = 0;//this variable will control the end of the program
        int temporalVariable = 0; //This variable will assist with the logic of the app
        OfficeUser user;//this is the user that will use the app
        System.out.println("Please submit your name");
        user = new OfficeUser(scanner.nextLine());
        System.out.println("The name submitted is: "+user.getUserName());
        int temporalChannels=0;//this variable will assist with the logic of the options available for the user
        int temporalPrinter=0;//this variable will assist with the logic of the printers available for the user

        while (END == 0) {
            printMenu();
            temporalVariable = NextStep();
            switch (temporalVariable) {
                case 1 -> {
                    System.out.println("""
                            Select one of the printers.
                            
                            """);
                    printerDirector.PrintPrintersInformation();
                    temporalPrinter=NextStep();
                    user.setPrinter(printerDirector.printers.get(temporalPrinter-1)); //dependencies injection with setter
                    System.out.println("the printer selected is: "+printerDirector.printers.get(temporalPrinter-1).getPrinter().getName());
                }
                case 2 -> {
                    System.out.println("""
                            Select the option to print.
                            1. B&N
                            2. Color
                            """);
                    temporalChannels=NextStep();
                    //this parameter will define the option that the user wants
                    user.setOptionForPrinter(temporalChannels);

                }
                case 3 -> {
                    //printer function
                    if(temporalChannels!=0&&temporalPrinter!=0){
                        System.out.println("submit the name of the file that you want to print \n");
                        user.setFile(scanner.nextLine());
                        user.service();

                    } else{
                        System.out.println("Select a printer and one printer mode first");
                    }
                }
                case 4 -> {
                    System.out.println("Submit the new name");
                    user.setUserName(scanner.nextLine());
                    System.out.println("Your user name was changed to: "+user.getUserName());
                }
                case 5 -> {
                    System.out.println("Thank you "+user.getUserName()+"  for testing my app");
                    END++;
                }
                default -> {
                    System.out.println("Your input was invalid");
                    END++;
                }
            }
        }

    }
    public void printMenu () {
        System.out.println("""
                    
                    MENU TO PRINT AT THE OFFICE                                      
                                        
                    1. Select printer
                    2. Select the printer mode
                    3. Send file to print
                    4. Change user name                   
                    5. Close
                                                                                    
                    """);
    }
    public static int NextStep() {
        //this process will stop the terminal until an entry is submitted
        return Integer.parseInt(scanner.nextLine());
    }




}
