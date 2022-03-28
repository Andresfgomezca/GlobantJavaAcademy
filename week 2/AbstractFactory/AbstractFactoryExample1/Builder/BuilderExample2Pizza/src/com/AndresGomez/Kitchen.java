package AbstractFactory.AbstractFactoryExample1.Builder.BuilderExample2Pizza.src.com.AndresGomez;
//class Director
public class Kitchen {
    private PizzaBuilder pizzaBuilder;
    //Getter and Setter
    public PizzaBuilder getPizzaBuilder() {
        return pizzaBuilder;
    }

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        //Polymorphism from Abstract Pizza builder
        //This class will create the pizza depending on the pizza received
        //the method will receive concrete products
        this.pizzaBuilder = pizzaBuilder;
    }

    public void BuildPizza(){
        pizzaBuilder.NewPizza(); //Instantiate pizza
        pizzaBuilder.BuildMass();
        pizzaBuilder.BuildSauce();
        pizzaBuilder.BuildIngredient();
        pizzaBuilder.currentPizza();

    }

}
