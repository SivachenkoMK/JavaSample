public class StandardShipping implements Shipping {
    private static final double FLAT_RATE = 5.0;

    @Override
    public double calculateShippingCost(double orderAmount) {
        return FLAT_RATE;
    }

    @Override
    public String getShippingName() {
        return "Standard Shipping";
    }
}