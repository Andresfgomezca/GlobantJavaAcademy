package Exercise3.HotDog.Ingredients;

import Exercise3.HotDog.HotDogBase;
import Exercise3.HotDog.HotDogDecorator;

public class Avocado extends HotDogDecorator {
    public Avocado(HotDogBase hotdogbase) {
        super(hotdogbase); //this constructor will pass the information from this class to the hot-dog base object.
    }

    @Override
    public void addIngredientUpdate() {
        getHotdogbase().addIngredientUpdate();
        hotdogbase.addIngredient("avocado");
        //this method will work as a wrapper
    }
}
