package AbstractFactory.AbstractFactoryExample1.src.com.AndresGomez;

public class SoftwareService implements InformaticsService {
    //this concrete product implements the abstract product to create software services
    @Override
    public void assignJob() {
        System.out.println("This job has been assigned to our backend developers available");
    }

    @Override
    public void timeForThisJob() {
        System.out.println("The EDT for this job will be on 1/25/22");
    }

    @Override
    public void paymentInformation() {
        System.out.println("You will be able to pay this service with nequi :)");
    }
}
