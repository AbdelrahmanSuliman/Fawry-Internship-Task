# Fawry Rise Journey E-Commerce System

## Overview
This project is a simple e-commerce system implemented in Java as part of the Fawry Rise Journey Full Stack Development Internship Challenge. It demonstrates core e-commerce features such as product management, cart operations, checkout, shipping, and error handling.

## Features
- **Product Definition:**
  - Products have a name, price, and quantity.
  - Some products can expire (e.g., Cheese, Biscuits), others do not (e.g., TV, Mobile).
  - Some products require shipping and have a weight (e.g., Cheese, TV), others do not (e.g., Mobile scratch cards).
- **Cart Management:**
  - Customers can add products to their cart with a specific quantity (not exceeding available stock).
  - Expired or out-of-stock products cannot be added.
- **Checkout:**
  - Calculates subtotal, shipping fees, total amount, and updates customer balance.
  - Prints a detailed shipment notice and checkout receipt to the console.
  - Handles errors for empty cart, insufficient balance, and expired/out-of-stock products.
- **Shipping Service:**
  - Collects all shippable items and calculates total shipping cost and package weight.

## Usage

### Normal Output Example
```java
** Shipment notice **
1x Gouda
2x Jikulhang dictionary
2x A4
Total package weight: 4.0 kg
** Checkout receipt **
Gouda x 1             50.5
Jikulhang dictionary x 2             179.96
A4 x 2             24.0
-----------------------------------------
Subtotal:              254.46
Shipping:              40.0
Amount: 294.46           
Customer balance:       8705.54
```

### Edge Cases and Error Handling

#### 1. Cart is empty
```java
Customer customer = new Customer();
customer.checkout();
```
**Output:**
```
Exception in thread "main" java.lang.RuntimeException: Cart is empty
    at Customer.checkout(Customer.java:11)
    at Main.main(Main.java:13)
```

#### 2. Customer has insufficient balance
```java
Customer customer = new Customer();
customer.setBalance(0);
Product cheese = new Product("Gouda", 50.5, 1);
customer.addToCart(cheese, 1);
customer.checkout();
```
**Output:**
```
Exception in thread "main" java.lang.RuntimeException: Customer balance is less than paid amount, the required amount is 50.5
    at Customer.checkout(Customer.java:22)
    at Main.main(Main.java:17)
```

#### 3. Product is expired
```java
Customer customer = new Customer();
customer.setBalance(100);
Product cheese = new Product("Gouda", 50.5, 1);
cheese.setExpiryDate(LocalDate.now().minusDays(1));
customer.addToCart(cheese, 1);
customer.checkout();
```
**Output:**
```
Exception in thread "main" java.lang.RuntimeException: Product is expired
    at Customer.addToCart(Customer.java:48)
    at Main.main(Main.java:16)
```

## How to Run
1. Ensure you have Java 8 or higher installed.
2. Compile all `.java` files:
   ```sh
   javac *.java
   ```
3. Run the main class:
   ```sh
   java Main
   ```

