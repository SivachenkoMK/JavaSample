import java.time.LocalDate;

public class FoodProduct extends Product {
    private LocalDate expirationDate;

    public FoodProduct(int productId,
                       String name,
                       double price,
                       LocalDate expirationDate,
                       Market market) {
        super(productId, name, price, market);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return "FoodProduct [expirationDate=" + expirationDate
                + ", " + super.toString() + "]";
    }
}