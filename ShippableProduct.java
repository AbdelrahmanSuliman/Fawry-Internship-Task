
public class ShippableProduct extends Product implements Shippable {

    private double weight;
    private double shippingFees;

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getShippingFees() {
        return shippingFees;
    }

    public void setShippingFees(double shippingFees) {
        this.shippingFees = shippingFees;
    }

    public ShippableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public double getWeight() {
        return this.weight;
    }
}
