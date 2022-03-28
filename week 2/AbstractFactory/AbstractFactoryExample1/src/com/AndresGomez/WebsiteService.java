package AbstractFactory.AbstractFactoryExample1.src.com.AndresGomez;

public class WebsiteService implements InformaticsService {
    //this concrete product implements the abstract product to create website services

    @Override
    public void assignJob() {
        System.out.println("This job has been assigned to our frontend developers  available");
    }

    @Override
    public void timeForThisJob() {
        System.out.println("The EDT for this job will be on 2/16/22");
    }

    @Override
    public void paymentInformation() {
        System.out.println("You will be able to pay this service with nequi or bitcoins :)");
    }
}
