package Builder.BuilderExample2Pizza.src.com.AndresGomez;

public class Main {

    public static void main(String[] args) {
	/*
	This code is for educational purposes, developed by Andres Felipe Gomez to implement the Builder
	design pattern.
    This example will emulate the services offered by a Pizza restaurant that sells different types of pizza
	 */
        Kitchen kitchen = new Kitchen();//INSTANTIATE DIRECTOR CLASS
        PizzaBuilder hawaiian_pizzaBuilder = new HawaiianPizza();//INSTANTIATE CONCRETE BUILDERS
        PizzaBuilder spicy_pizzaBuilder = new SpicyPizza();

        kitchen.setPizzaBuilder(hawaiian_pizzaBuilder);//Now director can create the object using its methods
        kitchen.BuildPizza();
    }
}
