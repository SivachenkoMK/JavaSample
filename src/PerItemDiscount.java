import java.util.List;

public class PerItemDiscount extends Discount {
    private double discountPerItem;

    public PerItemDiscount(double discountPerItem) {
        this.discountPerItem = discountPerItem;
    }

    @Override
    public double applyDiscount(List<Product> products) {
        double totalDiscount = 0.0;
        for (Product product : products) {
            totalDiscount += discountPerItem;
        }
        return totalDiscount;
    }
}