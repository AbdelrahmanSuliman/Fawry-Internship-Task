import java.util.HashMap;

public class Customer {
    public double balance = 0;

    HashMap<Product, Integer> cart = new HashMap<>();

    public void checkout() {
        ShippingService shippingService = new ShippingService();
        if(cart.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }
        double subtotal = 0;
        for(var product : cart.keySet()){
            subtotal += product.getPrice() * cart.get(product);
            if(product instanceof ShippableProduct){shippingService.addShippableProduct((ShippableProduct) product, cart.get(product));}
        }
        double shippingCost = shippingService.getShippingCost();
        double paidAmount = subtotal + shippingCost;

        if(getBalance() < paidAmount){
            throw new RuntimeException("Customer balance is less than paid amount, the required amount is " + paidAmount);
        } else{
            setBalance(getBalance() - paidAmount);
        }

        System.out.println("** Shipment notice **");
        for(var product : cart.keySet()){
            System.out.println(cart.get(product) + "x " + product.getName() );
        }
        System.out.println("Total package weight: " + shippingService.getTotalWeight() + " kg");

        System.out.println("** Checkout receipt **");
        for(var product : cart.keySet()){
            System.out.println(product.getName() + " x " + cart.get(product) + "             " + product.getPrice() * cart.get(product));
        }
        System.out.println("-----------------------------------------");
        System.out.println("Subtotal:              " + subtotal);
        System.out.println("Shipping:              " + shippingCost);
        System.out.printf("Amount: %.2f           \n", paidAmount);
        System.out.println("Customer balance:       " + getBalance());
    }

    public void addToCart(Product product, int amount){
        if(amount > product.getQuantity())
            throw new RuntimeException("Amount requested is greater than available product quantity");
        product.setQuantity(product.getQuantity() - amount);
        if(product.isExpired())
            throw new RuntimeException("Product is expired");
        if(cart.containsKey(product)){
            int prevAmount = cart.get(product);
            cart.put(product,prevAmount + amount);
        } else{
            cart.put(product, amount);
        }
    }

    public void getCartContent(){
        for(var item : cart.entrySet()){
            System.out.println("Product: " + item.getKey() + "Quantity: " + item.getValue());
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
