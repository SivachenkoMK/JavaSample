
public class Clothing extends Product {
    private String size;
    private String color;

    public Clothing(int productId,
                    String name,
                    double price,
                    String size,
                    String color,
                    Market market) {
        super(productId, name, price, market);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Clothing [size=" + size
                + ", color=" + color
                + ", " + super.toString() + "]";
    }
}