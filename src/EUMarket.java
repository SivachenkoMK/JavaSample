public class EUMarket extends Market {

    public EUMarket() {
        super("EU Market");
    }

    @Override
    public String getCurrencyCode() {
        return "EUR";
    }
}