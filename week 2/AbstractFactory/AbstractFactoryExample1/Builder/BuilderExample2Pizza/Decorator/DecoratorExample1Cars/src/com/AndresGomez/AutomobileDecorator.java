package AbstractFactory.AbstractFactoryExample1.Builder.BuilderExample2Pizza.Decorator.DecoratorExample1Cars.src.com.AndresGomez;

public abstract class AutomobileDecorator implements Automobile{

    //The classes  that inherit  this class will have the new features
    //this car is the extended one
    private Automobile car;
    //we need to receive a car to extend the features
    public AutomobileDecorator(Automobile car) {
        this.car = car;
    }

    protected Automobile getAuto(){
        return car;
    }

}
