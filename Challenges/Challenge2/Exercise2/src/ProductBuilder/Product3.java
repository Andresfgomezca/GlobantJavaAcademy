package ProductBuilder;

public class Product3 extends ProductBuilder{
    //this product will be a memory dual pack Corsair Vengeance pro sl RGB 4000Mhz
    @Override
    public void productName() {
        product.setName("Corsair Vengeance pro sl RGB 4000Mhz");
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
