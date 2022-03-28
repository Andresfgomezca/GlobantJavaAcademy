package AbstractFactory.AbstractFactoryExample1.src.com.AndresGomez;

public class WebsiteFactory implements AbstractFactory{
    //this factory implements the abstract factory to use the abstract method that will create the desired
    // service
    @Override
    public InformaticsService createService() {
        return new WebsiteService();
    }
}
