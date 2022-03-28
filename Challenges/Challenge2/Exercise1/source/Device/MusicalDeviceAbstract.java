package source.Device;

//abstract builder device
public abstract class MusicalDeviceAbstract {
    protected MusicalDevice musicalDevice;

    //always has an object product, concrete method, 1 method to instantiate the product and abstract methods

    public void NewDevice() {
        musicalDevice = new MusicalDevice();
    }
    public MusicalDevice getDevice() {
        return musicalDevice;
    }

    //These methods will be uses by the concrete products
    public abstract void selectColor(String color);
    public abstract void selectMemory(String memory);
    public abstract void selectBattery(String battery);
    public void currentDevice(){ //this extra method is to verify the information of the device created
        System.out.println("the current device has a memory of "
                + musicalDevice.getMemory()
                +", a battery "
                + musicalDevice.getBattery()
                + " and the color is "
                + musicalDevice.getColor());
    }


}
