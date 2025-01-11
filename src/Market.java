public abstract class Market {
    protected String marketName;

    public Market(String marketName) {
        this.marketName = marketName;
    }

    public String getMarketName() {
        return marketName;
    }

    public abstract String getCurrencyCode();

    @Override
    public String toString() {
        return getMarketName() + " (" + getCurrencyCode() + ")";
    }
}