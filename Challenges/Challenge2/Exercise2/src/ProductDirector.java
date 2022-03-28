import ProductBuilder.*;

import java.util.ArrayList;

public class ProductDirector {
    protected ProductBuilder productBuilder;
    public ArrayList<Product> products=new ArrayList<>();//Array list to record the products
    public void setProductBuilder(ProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }

    public void ProductsCreation() {
        //creation of the product 1
        ProductBuilder product1 = new Product1(); //initialization of the product
        setProductBuilder(product1);
        product1.NewProduct();
        product1.productName();
        products.add(product1.getProduct());
        //creation of the product 2
        ProductBuilder product2 = new Product2(); //initialization of the product
        setProductBuilder(product2);
        product2.NewProduct();
        product2.productName();
        products.add(product2.getProduct());
        //creation of the product 3
        ProductBuilder product3 = new Product3(); //initialization of the product
        setProductBuilder(product3);
        product3.NewProduct();
        product3.productName();
        products.add(product3.getProduct());
    }

    public void PrintProductsInformation(){
        System.out.println("Printing the current information of the products");
        for(int i=0;i<3;i++){ //limited due the number of products for this exercise
            System.out.println("------------------------------------------------");
            System.out.println("Product #"+(i+1));
            System.out.println("Name: "+(products.get(i)).getName());
            System.out.println("Price: "+(products.get(i)).getPrice());
        }
    }
    public void changePriceForProduct(int INDEX, int price){
        //this method will access to the arraylist that has the products to change the price of the desired product
        products.get(INDEX-1).setPrice(Integer.toString(price));
    }
    public void subscribeACustomer(int INDEX, Customer customer){
        products.get(INDEX).Subscription(customer);
    }
    public void unsubscribeACustomer(int INDEX, Customer customer){
        products.get(INDEX).Unsubscribe(customer);
    }
    public void PrintProductsInformationWithoutPrice(){
        System.out.println("This are the existing products");
        for(int i=0;i<3;i++){ //limited due the number of products for this exercise
            System.out.println("------------------------------------------------");
            System.out.println("Product #"+(i+1)+"- Name: "+(products.get(i)).getName());
        }
    }
}
