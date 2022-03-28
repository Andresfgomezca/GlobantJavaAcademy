package AbstractFactory.AbstractFactoryExample1.Builder.BuilderExample2Pizza.Decorator.DecoratorExample1Cars.src.com.AndresGomez;

public class StandardCar implements Automobile{
    private String carName;
    public StandardCar(String name) {
        carName=name;
    }

    @Override
    public void start() {
        System.out.println("Starting car");
    }

    @Override
    public void accel() {
        System.out.println("Accelerating car");
    }

    @Override
    public void stop() {
        System.out.println("Stopping car");
    }
}
