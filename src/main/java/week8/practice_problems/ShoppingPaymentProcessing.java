package week8.practice_problems;

import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

class OrderItem {
    private Product product;
    private int quantity;

    OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.getPrice() * quantity;
    }
}

class ShoppingCustomer {
    private String name;

    ShoppingCustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface PaymentMethod {
    boolean processPayment(double amount);
    String getName();
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        return true;
    }

    @Override
    public String getName() {
        return "Credit Card";
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        return false;
    }

    @Override
    public String getName() {
        return "PayPal";
    }
}

class BankTransferPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        return true;
    }

    @Override
    public String getName() {
        return "Bank Transfer";
    }
}

class ShoppingOrder {
    private ShoppingCustomer customer;
    private List<OrderItem> items = new ArrayList<>();
    private String status = "Pending";

    ShoppingOrder(ShoppingCustomer customer) {
        this.customer = customer;

        System.out.println(
            "Order created for " + customer.getName() + "."
        );
    }

    public void addProduct(Product product, int quantity) {
        if (quantity > 0) {
            items.add(new OrderItem(product, quantity));
        }
    }

    public double calculateTotal() {
        double total = 0;

        for (OrderItem item : items) {
            total += item.getTotal();
        }

        return total;
    }

    public void pay(PaymentMethod method) {
        if (items.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        System.out.println(
            "Payment initiated via "
            + method.getName()
            + " for Order "
            + customer.getName()
            + "."
        );

        boolean successful =
            method.processPayment(calculateTotal());

        if (successful) {
            status = "Paid";
            System.out.println(
                "Payment for Order "
                + customer.getName()
                + " successful."
            );
        } else {
            System.out.println(
                "Payment for Order "
                + customer.getName()
                + " failed."
            );
        }

        System.out.println("Order status: " + status + ".");
    }
}

public class ShoppingPaymentProcessing {
    public static void main(String[] args) {
        ShoppingCustomer customerX =
            new ShoppingCustomer("Customer X");

        ShoppingOrder orderX = new ShoppingOrder(customerX);

        orderX.addProduct(new Product("Product A", 100), 2);
        orderX.addProduct(new Product("Product B", 50), 1);

        orderX.pay(new CreditCardPayment());

        ShoppingCustomer customerY =
            new ShoppingCustomer("Customer Y");

        ShoppingOrder orderY = new ShoppingOrder(customerY);

        orderY.pay(new CreditCardPayment());

        ShoppingCustomer customerZ =
            new ShoppingCustomer("Customer Z");

        ShoppingOrder orderZ = new ShoppingOrder(customerZ);

        orderZ.addProduct(new Product("Product C", 200), 1);

        orderZ.pay(new PayPalPayment());
    }
}