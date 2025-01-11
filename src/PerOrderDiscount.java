import java.util.List;

public class PerOrderDiscount extends Discount {
    private double discountAmount;

    public PerOrderDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(List<Product> products) {
        return discountAmount;
    }
}