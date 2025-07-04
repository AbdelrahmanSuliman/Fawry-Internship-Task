import java.time.LocalDate;

public class Product{
        private String name;
        private double price;
        private int quantity;

        private LocalDate expiryDate;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", expiryDate=" + expiryDate +
                '}';
    }

    public Product(String name, double price, int quantity){
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }

        public void setPrice(double price){
            this.price = price;
        }
        public double getPrice(){
            return this.price;
        }

        public void setQuantity(int quantity){
            this.quantity = quantity;
        }
        public int getQuantity(){
            return this.quantity;
        }

        public void setExpiryDate(LocalDate expiryDate){
            this.expiryDate = expiryDate;
        }
        public boolean isExpired(){
            return this.expiryDate != null && this.expiryDate.isBefore(LocalDate.now());
        }



}
