public class USMarket extends Market {

    public USMarket() {
        super("US Market");
    }

    @Override
    public String getCurrencyCode() {
        return "USD";
    }
}