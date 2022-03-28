

import java.util.ArrayList;
import java.util.Scanner;

public class Facade {
    public void execution() {
        ProductDirector productDirector = new ProductDirector();
        //INSTANTIATE DIRECTOR CLASS
        //This director will request the information from the client.
        //ProductDirector.Execution();
        productDirector.ProductsCreation();
        int customerCounter = 0;
        ArrayList<Customer> CustomersO = new ArrayList<>();//Array list to record the products
        int temporalPrice;
        int temporalIndex;
        int temporalCustomer;
        int END = 0;//this variable will control the end of the program
        int temporalVariable = 0; //This variable will assist with the logic of the app

        while (END == 0) {
            printMenu();
            temporalVariable = NextStep();
            switch (temporalVariable) {
                case 1 -> {
                    System.out.println("""
                            Select the product that you want to change the price.
                            """);
                    productDirector.PrintProductsInformationWithoutPrice();
                    temporalIndex = NextStep();
                    System.out.println("""
                            Submit the price for this product.
                            """);
                    temporalPrice = NextStep();
                    productDirector.changePriceForProduct(temporalIndex, temporalPrice);
                }
                case 2 -> {
                    productDirector.PrintProductsInformation();
                }
                case 3 -> {
                    Customer customer = new Customer();
                    customer.setCustomerId(customerCounter);
                    CustomersO.add(customer);
                    System.out.println("Customer was created successfully with the ID: "
                            + customerCounter);

                    customerCounter++;
                }
                case 4 -> {
                    System.out.println("the last id used to create a customer was: "
                            + (customerCounter - 1));
                }
                case 5 -> {
                    System.out.println("""
                            Select the product to subscribe the customer.
                            """);
                    temporalIndex = NextStep() - 1; //this will be the index of the arraylist of products
                    System.out.println("""
                            Submit the id of the customer that will take the subscription
                            """);
                    temporalCustomer = NextStep();
                    //This method will subscribe a customer to the desired product
                    productDirector.subscribeACustomer(temporalIndex, CustomersO.get(temporalCustomer));
                    System.out.println("the customer with ID "
                            + temporalCustomer
                            + " was successfully subscribe to the product "
                            + (temporalIndex + 1));
                }
                case 6 -> {
                    System.out.println("""
                        Select the product to unsubscribe the customer.
                        """);
                    temporalIndex = NextStep() - 1; //this will be the index of the arraylist of products
                    System.out.println("""
                        Submit the id of the customer that will be removed from this subscription
                        """);
                    temporalCustomer = NextStep();
                    //This method will unsubscribe a customer to the desired product
                    productDirector.unsubscribeACustomer(temporalIndex, CustomersO.get(temporalCustomer));
                    System.out.println("the customer with ID "
                            + temporalCustomer
                            + " was successfully unsubscribe of the product "
                            + (temporalIndex+1));
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
                    STORE ONLINE
                    
                    Menu
                                        
                    1. Change a product price
                    2. See current products
                    3. Create a Customer
                    4. Last customer ID used
                    5. Subscribe a Customer to an object with client ID
                    6. Unsubscribe a Customer to an object with client ID
                    7. Close
                                                                                    
                    """);
    }
    public static int NextStep () {
        //this process will stop the terminal until a new process is created
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
