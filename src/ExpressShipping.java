public class ExpressShipping implements Shipping {
    private static final double FLAT_RATE = 15.0;
    private static final double PERCENTAGE_RATE = 0.05;

    @Override
    public double calculateShippingCost(double orderAmount) {
        return Math.max(FLAT_RATE, orderAmount * PERCENTAGE_RATE);
    }

    @Override
    public String getShippingName() {
        return "Express Shipping";
    }
}