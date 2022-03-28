package Exercise3.HotDog;

public class HotDogBase implements HotDog {
    private String name;
    private String ingredient;
    //This variable will be the name of the HotDog created, the customer will be able to put a name in the hot dog
    public HotDogBase(String n, String i){
        name=n;
        ingredient=i;
        if(i=="0"){
            ingredient="Hot Dog Buns \n"
                    +"Sausage \n";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
    public void addIngredient(String ingredient) {
        this.ingredient += ingredient+"\n";
    }
    //This method will print the information of the hot dog
    public void printHotdogInfo(){
        System.out.println("Hot-Dog Name: " + name
            +"\n"
            +"Current Ingredients: "
            + "\n"
            +ingredient);
    }
    @Override
    public void addIngredientUpdate() {
        System.out.println("new ingredient added!");
    }
}
