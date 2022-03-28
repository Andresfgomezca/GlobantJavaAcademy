package Exercise3.HotDog.Toppings;

import Exercise3.HotDog.HotDogBase;
import Exercise3.HotDog.HotDogDecorator;

public class Sauerkraut extends HotDogDecorator {
    public Sauerkraut(HotDogBase hotdogbase) {
        super(hotdogbase); //this constructor will pass the information from this class to the hot-dog base object.
    }

    @Override
    public void addIngredientUpdate() {
        getHotdogbase().addIngredientUpdate();
        hotdogbase.addIngredient("sauerkraut");
        //this method will work as a wrapper
    }
}
