import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product book = new Product("Jikulhang dictionary", 89.98, 90);
        Product cheese = new Product("Gouda", 50.5,1 );
        ShippableProduct paper = new ShippableProduct("A4", 12, 5);
        paper.setWeight(2);
        paper.setShippingFees(10);

        Customer customer = new Customer();
        customer.setBalance(9000);

        cheese.setExpiryDate(LocalDate.now().plusDays(2));

        customer.addToCart(book, 2);
        customer.addToCart(cheese, 1);
        customer.addToCart(paper, 2);

        customer.checkout();


    }

}
