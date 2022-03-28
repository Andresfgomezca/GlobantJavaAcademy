package AbstractFactory.AbstractFactoryExample1.src.com.AndresGomez;

import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        This code is for educational purposes, developed by Andres Felipe Gomez to implement the Abstract
        factory design pattern.

        This example will emulate the services offered by a company that sells website services, design
        services and software services to different companies, and the client will be able to select the
        desired services in the command line.
        */
    int i;
    do{
        i= askForService();
        switch (i){
            case 1:
                selectService(new DesignFactory());
                break;
            case 2:
                selectService(new SoftwareFactory());
                break;
            case 3:
                selectService(new WebsiteFactory());
                break;
            case 4:
                System.out.println("Closing software...");
                break;
            default:
                System.out.println("Invalid answer");
        }
        System.out.println("\n");
    }
    while(i!=4);

    } //end of main(String[] args)
    public static void selectService(AbstractFactory factory){
        //This method will create the product using the abstract method from the abstract factory "create"
        InformaticsService service = factory.createService();
        service.assignJob();
        service.timeForThisJob();
        service.paymentInformation();
    }
    public static int askForService() {
        //This is the men that will be showed the terminal

        System.out.println(
                "Welcome...\n"
                +"Option Menu\n"
                +"please select one of the following options\n"
                +"--------------------------------------------\n"
                +"1. Graphic design service\n"
                +"2. Software service\n"
                +"3. Website service\n"
                +"4. Close program\n"
        );
        String option= scanner.nextLine();
        return Integer.parseInt(option);
    }


}
