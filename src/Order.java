import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private double totalAmount;
    private PaymentMethod paymentMethod;
    private Discount discount;
    private Shipping shippingMethod;
    private Market market;
    private String status;

    public Order(int orderId,
                 Customer customer,
                 List<Product> products,
                 PaymentMethod paymentMethod,
                 Shipping shippingMethod,
                 Market market,
                 Discount discount) {
        this.orderId = orderId;
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        this.shippingMethod = shippingMethod;
        this.market = market;
        this.discount = discount;
        this.status = "CREATED";

        this.products = new ArrayList<>();
        for (Product p : products) {
            if (p.isAvailableIn(market)) {
                this.products.add(p);
                System.out.println("Product '" + p.getName()
                        + "' added.");
            } else {
                System.out.println("Product '" + p.getName()
                        + "' not added. Not supported in "
                        + market.getMarketName() + ".");
            }
        }

        this.totalAmount = calculateTotalAmount();
    }

    private double calculateTotalAmount() {
        double sum = 0.0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        if (discount != null) {
            sum -= discount.applyDiscount(products);
        }
        if (shippingMethod != null) {
            sum += shippingMethod.calculateShippingCost(sum);
        }
        return sum;
    }

    public void placeOrder() {
        if (paymentMethod == null) {
            System.out.println("Payment method not set. Cannot place order.");
            return;
        }
        if (products.isEmpty()) {
            System.out.println("No products in order. Cannot place order.");
            return;
        }
        paymentMethod.pay(totalAmount);
        this.status = "PAID";
        System.out.println("Order placed successfully in "
                + market + " for Customer: " + customer.getName()
                + ". Current status: " + status);
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }
}