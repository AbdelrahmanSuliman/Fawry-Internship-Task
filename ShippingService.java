import java.util.HashMap;

public class ShippingService {
    public HashMap<ShippableProduct, Integer> shippableProducts = new HashMap<>();

    public void addShippableProduct(ShippableProduct product, int amount) {
        shippableProducts.put(product, amount);
    }

    public double getShippingCost(){
        double shippingCost = 0;
        for(var product : shippableProducts.entrySet()){
            shippingCost += product.getKey().getWeight() * product.getKey().getShippingFees() * product.getValue();
        }

        return shippingCost;
    }

    public double getTotalWeight(){
        double totalWeight = 0;
        for(var product : shippableProducts.keySet()){
            totalWeight += product.getWeight() * shippableProducts.get(product);
        }
        return totalWeight;
    }
}
