package source.exercise1;

import source.Device.MusicalDeviceAbstract;
import source.Device.NormalDevice;

import java.util.Scanner;

//this is the director class for the builder
public class GeniusDirector {

    private MusicalDeviceAbstract musicalDeviceAbstract;
    //private ColorBuilder color;
    private String color;
    private String battery;
    private String memory;
    //Getter and Setter
    //Polymorphism from Abstract builders
    //This class will create the feature depending on the feature received
    //the method will receive concrete products
    public void setMusicalDeviceAbstract(MusicalDeviceAbstract musicalDeviceAbstract) {
        this.musicalDeviceAbstract = musicalDeviceAbstract;
    }
    public void Execution() {
        int temporalVariable=0;//this variable will assist with the execution of the menu
        while (temporalVariable != 3) {
            MusicalDeviceAbstract normalDevice = new NormalDevice();
            setMusicalDeviceAbstract(normalDevice);
            normalDevice.NewDevice();
            printMenu();
            temporalVariable = NextStep();
            switch (temporalVariable) {
                case 1 -> {
                    System.out.println("""
                            Select 1 of the next colours:
                            1. green 2. Blue
                            """);
                    temporalVariable = NextStep();
                    if (temporalVariable == 1) {
                        this.color="green";
                        normalDevice.selectColor(color);
                    } else {
                        this.color="blue";
                        normalDevice.selectColor(color);
                    }
                    System.out.println("""
                            Select the capacity of the memory:
                            1. 8 Gb 2. 16Gb
                            """);
                    temporalVariable = NextStep();
                    if (temporalVariable == 1) {
                        this.memory="8 Gb";
                        normalDevice.selectMemory(memory);
                    } else {
                        this.memory="16 Gb";
                        normalDevice.selectMemory(memory);
                    }
                    //normalDevice.selectMemory(memory);
                    System.out.println("""
                            Select the capacity of the battery:
                            1. 5 Hours 2. 8 Hours
                            """);
                    temporalVariable = NextStep();
                    if (temporalVariable == 1) {
                        this.battery="5 Hours";
                        normalDevice.selectBattery(battery);
                    } else {
                        this.battery="8 Hours";
                        normalDevice.selectBattery(battery);

                    }
                    //normalDevice.selectBattery(battery);
                    //build method
                    normalDevice.NewDevice();
                    normalDevice.selectBattery(battery);
                    normalDevice.selectMemory(memory);
                    normalDevice.selectColor(color);
                    normalDevice.currentDevice();
                }
                case 2 -> {
                    System.out.println("System is printing the previous device information");
                    normalDevice.currentDevice();
                }
                case 3 -> {
                    System.out.println("Thank you for testing the musical store app");
                }
                default -> System.out.println("Your input was invalid");
            }
        }

    }
        public void printMenu () {
            System.out.println("""
                    This is the menu of the musical store
                    1. Create a device
                    2. See previous device
                    3. Close
                                                                
                    """);
        }
        public static int NextStep () {
            //this process will stop the terminal until a new process is created
            Scanner scanner = new Scanner(System.in);
            return Integer.parseInt(scanner.nextLine());
        }
}
