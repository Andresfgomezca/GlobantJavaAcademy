package AbstractFactory.AbstractFactoryExample1.src.com.AndresGomez;

public interface AbstractFactory {
    //his is our abstract factory, and it has a method that return the
    //abstract product type
    InformaticsService createService();
}
