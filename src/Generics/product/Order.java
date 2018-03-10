package Generics.product;


public class Order<T extends Product> {

    T product;

    int count;

    public Order(T product, int count) {
        this.product = product;
        this.count = count;
    }

    public void print()
    {
        product.PrintProductFeatures();
        System.out.println("Number: " + this.count );
        System.out.println("Total Price: " + this.count * product.getPrice());
    }

    public static void main(String[] args) {

        Product desk1 = new Desk(5,"Desk",15d);
        Order<Product> o = new Order<Product>(desk1,2);
        o.print();

    }
}
