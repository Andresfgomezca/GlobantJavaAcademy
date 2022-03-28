package Exercise3.HotDog.Toppings;

import Exercise3.HotDog.HotDogBase;
import Exercise3.HotDog.HotDogDecorator;

public class ChoppedTomato extends HotDogDecorator {
    public ChoppedTomato(HotDogBase hotdogbase) {
        super(hotdogbase); //this constructor will pass the information from this class to the hot-dog base object.
    }

    @Override
    public void addIngredientUpdate() {
        getHotdogbase().addIngredientUpdate();
        hotdogbase.addIngredient("chopped-tomato");
        //this method will work as a wrapper
    }
}
