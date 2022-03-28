package Exercise3.HotDog.Ingredients;

import Exercise3.HotDog.HotDogBase;
import Exercise3.HotDog.HotDogDecorator;

public class MexicanBeans extends HotDogDecorator {
    public MexicanBeans(HotDogBase hotdogbase) {
        super(hotdogbase); //this constructor will pass the information from this class to the hot-dog base object.
    }

    @Override
    public void addIngredientUpdate() {
        getHotdogbase().addIngredientUpdate();
        hotdogbase.addIngredient("mexican-beans");
        //this method will work as a wrapper
    }
}
