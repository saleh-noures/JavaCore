package Generics.product;

public class Desk extends Product {

    private double capacity;

    public Desk(double capacity, String name, double price) {
        super(name, price);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

}
