package ProductBuilder;

import java.util.ArrayList;

public class Product implements Subject {
    private String Name=" ";
    private String Price=" ";
    private ArrayList<Observer> Customers=new ArrayList<>();
    public void Subscription(Observer c){
        Customers.add(c);
    }
    public void Unsubscribe(Observer c){
        Customers.remove(c);
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
        notification();
    }

    @Override
    public void notification() {
        for(Observer c: Customers)
        {
            System.out.println("the price was changed to: "+getPrice());
            c.update();
        }
    }
}
