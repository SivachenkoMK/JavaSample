import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Market usMarket = new USMarket();
        Market euMarket = new EUMarket();

        Product laptopUS = new Electronics(101,
                "Laptop-Karaziptop",
                2299.99,
                "UniversalTech",
                "X#",
                usMarket);

        Product smartphoneEU = new Electronics(102,
                "AI-Phone",
                899.99,
                "OverTheEdgeSolutions",
                "S++",
                euMarket);

        Product tshirtUS = new Clothing(201,
                "T-Shirt-for-Java-Devs",
                20.00,
                "M",
                "Blue",
                usMarket);

        Product appleEU = new FoodProduct(301,
                "Apple-Red-Fresh-Delicious",
                0.15,
                LocalDate.now().plusDays(7),
                euMarket);

        InitializeSearchConfiguration(appleEU, laptopUS, smartphoneEU, tshirtUS);

        Customer customer = new Customer(1001, "Mikhail", "mikhail.tobuy@example.com");

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(laptopUS);
        cart.addItem(smartphoneEU);
        cart.addItem(tshirtUS);
        cart.addItem(appleEU);

        System.out.println("=== Cart Items ===");
        for (Product p : cart.getItems()) {
            System.out.println(" - " + p);
        }

        Market chosenMarket = usMarket;

        PaymentMethod paymentMethod = new CreditCardPayment("4242-4242-4242-4242",
                "Mikhail",
                "11/33");

        Shipping shippingMethod = new StandardShipping();
        Discount discount = new PerItemDiscount(5.0);

        List<Product> cartItems = new ArrayList<>(cart.getItems());
        Order order = new Order(5001,
                customer,
                cartItems,
                paymentMethod,
                shippingMethod,
                chosenMarket,
                discount);

        order.placeOrder();

        System.out.println("\nFinal Order ID: " + order.getOrderId()
                + ", Status: " + order.getStatus()
                + ", Total: $" + order.getTotalAmount());

        System.out.println("=== Products in the final order ===");
        for (Product p : order.getProducts()) {
            System.out.println(" - " + p);
        }
    }

    private static List<Category> InitializeSearchConfiguration(Product appleEU, Product laptopUS, Product smartphoneEU, Product tshirtUS) {
        Category food = new Category(202, "food");
        food.addProduct(appleEU);

        Category electronics = new Category(203, "electronics");
        electronics.addProduct(laptopUS);
        electronics.addProduct(smartphoneEU);

        Category clothing = new Category(204, "clothing");
        clothing.addProduct(tshirtUS);

        var categories = new ArrayList<Category>();
        categories.add(food);
        categories.add(clothing);
        categories.add(electronics);

        return categories;
    }
}