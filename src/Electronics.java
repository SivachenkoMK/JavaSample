public class Electronics extends Product {
    private String brand;
    private String model;

    public Electronics(int productId,
                       String name,
                       double price,
                       String brand,
                       String model,
                       Market market) {
        super(productId, name, price, market);
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Electronics [brand=" + brand
                + ", model=" + model
                + ", " + super.toString() + "]";
    }
}