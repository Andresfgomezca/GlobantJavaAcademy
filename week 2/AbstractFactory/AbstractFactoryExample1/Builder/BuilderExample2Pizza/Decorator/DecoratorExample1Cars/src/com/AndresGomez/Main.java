package AbstractFactory.AbstractFactoryExample1.Builder.BuilderExample2Pizza.Decorator.DecoratorExample1Cars.src.com.AndresGomez;

public class Main {

    public static void main(String[] args) {
	/*
	    This code is for educational purposes, developed by Andres Felipe Gomez to implement the decorator
	     design pattern.

        This example will emulate how to add different features to a "car" by extending the original
        methods of the class StandardCar when it is defined that the "car" is not "standard"

        The feature that the car can have is if the car is electric.
	 */
        //this is one way to implement the decorator
        Automobile car = new StandardCar("new car"); //new car created with name new car

        car = new ElectricCar(car);
        //different way to implement the decorator

        //Automobile car = new ElectricCar(new StandardCar("New Car");
        car.start();
        car.accel();
        car.stop();
    }
}
