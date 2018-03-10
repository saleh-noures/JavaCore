package Generics.product;

public class Battery extends Product {

    private Boolean rechargeable;

    public Battery(Boolean rechargeable, String name, double price) {
        super(name, price);
        this.rechargeable = rechargeable;
    }

    public Boolean getRechargeable() {
        return rechargeable;
    }

    public void setRechargeable(Boolean rechargeable) {
        this.rechargeable = rechargeable;
    }


}
