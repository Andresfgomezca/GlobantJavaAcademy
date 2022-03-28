package Exercise3.HotDog;

public class RemoveLast extends HotDogDecorator {
    public RemoveLast(HotDogBase hotdogbase) {
        super(hotdogbase); //this constructor will pass the information from this class to the hot-dog base object.
    }

    @Override
    public void addIngredientUpdate() {
        getHotdogbase().addIngredientUpdate();
        /*
        This method will set the ingredients with the previous ones without the last line.
        This method is changing the String of the ingredients into a substring that will has a length reduced finding
        the lenght of the last ingredient.
         */
        int len = 0;

        /* String a is 'final'-- can not be modified
           So, create a copy and trim the spaces from
           both sides */
        String x = hotdogbase.getIngredient().trim();

        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == ' ')
                len = 0;
            else
                len++;
        }
        //I needed to add a connector in those ingredient composed with 2 words because this method find just the last word
        hotdogbase.setIngredient(hotdogbase.getIngredient().substring(0,hotdogbase.getIngredient().length()-len));
        //this method will work as a wrapper
    }
}