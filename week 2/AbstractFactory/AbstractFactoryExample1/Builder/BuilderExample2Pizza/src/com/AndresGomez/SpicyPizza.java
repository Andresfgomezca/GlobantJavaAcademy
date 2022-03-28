package AbstractFactory.AbstractFactoryExample1.Builder.BuilderExample2Pizza.src.com.AndresGomez;
//Concrete builder that inherit the information of the Abstract builder
public class SpicyPizza extends PizzaBuilder{
    @Override
    public void BuildMass() {
        pizza.setMass("Toasted");
    }

    @Override
    public void BuildSauce() {
        pizza.setSauce("Spicy");
    }

    @Override
    public void BuildIngredient() {
        pizza.setIngredients("Beef");
    }
}
