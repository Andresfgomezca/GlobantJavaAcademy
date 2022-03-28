package ProductBuilder;

public class Product1 extends ProductBuilder{
    //this product will be a processor Ryzen 7 5700x
    @Override
    public void productName() {
        product.setName("Ryzen 7 5700x");
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
