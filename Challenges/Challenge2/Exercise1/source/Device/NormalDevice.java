package source.Device;


//concrete product
public class NormalDevice extends MusicalDeviceAbstract {

    @Override
    public void selectColor(String color) {
        musicalDevice.setColor(color);
    }

    @Override
    public void selectMemory(String memory) {
        musicalDevice.setMemory(memory);
    }

    @Override
    public void selectBattery(String battery) {
        musicalDevice.setBattery(battery);
    }
    //this normal device will be the device which has a memory, 1 color and the battery desired by the client.

}
