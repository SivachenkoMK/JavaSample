import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public double getTotal() {
        double total = 0.0;
        for (Product product : items) {
            total += product.getPrice();
        }
        return total;
    }

    public List<Product> getItems() {
        return items;
    }
}