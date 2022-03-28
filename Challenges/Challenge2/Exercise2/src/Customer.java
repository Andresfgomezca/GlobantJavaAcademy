import ProductBuilder.Observer;

public class Customer implements Observer {
    private int customerId;
    @Override
    public void update() {
        System.out.println("Customer# "+customerId+" is notified about the change");
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
