package Builder.BuilderExample2Pizza.src.com.AndresGomez;
//ABSTRACT BUILDER
public abstract class PizzaBuilder {
    protected Pizza pizza;
    //always has an object product, concrete method, 1 method to instantiate the product and abstract methods

    public Pizza getPizza() {
        return pizza;
    }

    public void NewPizza(){
        pizza = new Pizza();
    }
    //These methods will be uses by the concrete products
    public abstract void BuildMass();
    public abstract void BuildSauce();
    public abstract void BuildIngredient();
    public void currentPizza(){ //this extra method is to verify the information of the pizza created
        System.out.println("the current pizza has mass "+pizza.getMass()+", sauce "+pizza.getSauce()
                +" and these ingredients "+pizza.getIngredients());
    }

}
