package AbstractFactory.AbstractFactoryExample1.Builder.BuilderExample2Pizza.Decorator.DecoratorExample1Cars.src.com.AndresGomez;

public class ElectricCar extends  AutomobileDecorator{
    //constructor is required
    public ElectricCar(Automobile car) {
        super(car); //wrapper
    }
    //this new methods are the ones that can extend the original car.
    @Override
    public void start() {
        System.out.println("Starting electric system of the car");
        getAuto().accel();
    }

    @Override
    public void accel() {
        System.out.println("Increasing current to the motor");
        getAuto().accel();
    }

    @Override
    public void stop() {
        System.out.println("Activating electric breaks");
        getAuto().stop();
    }
}
