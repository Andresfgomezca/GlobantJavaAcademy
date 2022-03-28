package AbstractFactory.AbstractFactoryExample1.Builder.BuilderExample2Pizza.src.com.AndresGomez;
//Concrete builder that inherit the information of the Abstract builder
public class HawaiianPizza extends PizzaBuilder{
    @Override
    public void BuildMass() {
        pizza.setMass("Soft");
    }

    @Override
    public void BuildSauce() {
        pizza.setSauce("Sweet");
    }

    @Override
    public void BuildIngredient() {
        pizza.setIngredients("PineApple+Ham");
    }

}
