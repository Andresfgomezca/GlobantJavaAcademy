package ProductBuilder;

public abstract class ProductBuilder {
    protected Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void NewProduct() {
        product = new Product();
    }
    public abstract void productName();
    public abstract void changePrice(String price);
    public abstract String currentPrice();
    public abstract String currentName();
    public void currentProduct(){ //this extra method is to verify the information of the device created
        System.out.println("the current product is"
                + product.getName()
                +"and its price is "
                + product.getPrice());
    }

}
