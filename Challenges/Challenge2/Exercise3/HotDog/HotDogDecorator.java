package Exercise3.HotDog;

public abstract class HotDogDecorator implements HotDog{
    protected HotDogBase hotdogbase; //this abstract class receives an object that implements the interface
    public HotDogDecorator(HotDogBase hotdog){
        this.hotdogbase=hotdog;
        //this logic allow us to modify the original object created with new features
        //from the classes that inherit from this class, those classes will be the features
    }
    protected HotDog getHotdogbase() {
        return hotdogbase;
    }
}
