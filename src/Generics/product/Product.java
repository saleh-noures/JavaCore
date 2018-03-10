package Generics.product;

public class Product {

    public String name;

    public Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void PrintProductFeatures() {

        System.out.println("product Name:" + getName());
        System.out.println("Price: " + getPrice() );
    }

}
