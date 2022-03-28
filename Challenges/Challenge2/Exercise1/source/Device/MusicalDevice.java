package source.Device;

//Musical device
public class MusicalDevice {
    private String color=" ";
    private String memory=" ";
    private String battery=" ";

//This getter methods are just used to verify the features of the device.

    public String getColor() {
        return color;
    }

    public String getMemory() {
        return memory;
    }

    public String getBattery() {
        return battery;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }
}