package Builder.BuilderExample2Pizza.src.com.AndresGomez;
//Concrete  class product
public class Pizza {
    private String mass="";
    private String sauce="";
    private String Ingredients="";

    public void setMass(String mass) {
        this.mass = mass;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setIngredients(String ingredients) {
        Ingredients = ingredients;
    }
    //This getter methods are just used to verify the ingredients of the pizza.
    public String getMass() {
        return mass;
    }

    public String getSauce() {
        return sauce;
    }

    public String getIngredients() {
        return Ingredients;
    }


}
