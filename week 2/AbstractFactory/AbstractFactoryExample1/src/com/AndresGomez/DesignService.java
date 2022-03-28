package AbstractFactory.AbstractFactoryExample1.src.com.AndresGomez;

public class DesignService implements InformaticsService {
    //this concrete product implements the abstract product to create design services

    @Override
    public void assignJob() {
        System.out.println("This job has been assigned to our graphic designers available");
    }

    @Override
    public void timeForThisJob() {
        System.out.println("The EDT for this job will be on 1/30/22");
    }

    @Override
    public void paymentInformation() {
        System.out.println("You will be able to pay this service with ETH or Bitcash :)");
    }
}
