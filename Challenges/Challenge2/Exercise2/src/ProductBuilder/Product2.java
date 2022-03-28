package ProductBuilder;

public class Product2 extends ProductBuilder{
    //this product will be a processor EVGA Geforce RTC 3060TI
    @Override
    public void productName() {
        product.setName("EVGA Geforce RTC 3060TI");
    }

    @Override
    public void changePrice(String price) {
        product.setPrice(price);
        product.notification();//NOTIFICATION TO THE OBSERVER
    }

    @Override
    public String currentPrice() {
        return product.getPrice();
    }

    @Override
    public String currentName() {
        return product.getName();
    }
}
