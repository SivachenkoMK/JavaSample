public abstract class Product {
    private int productId;
    private String name;
    private double price;
    private Market market; // Exactly one market

    public Product(int productId, String name, double price, Market market) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.market = market;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Market getMarket() {
        return market;
    }

    public boolean isAvailableIn(Market orderMarket) {
        return this.market.getClass().equals(orderMarket.getClass());
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId
                + ", name=" + name
                + ", price=" + price
                + ", market=" + market + "]";
    }
}