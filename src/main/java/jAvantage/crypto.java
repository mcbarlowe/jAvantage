package jAvantage;

public class crypto extends apiConnector{

    private final String[] sizeValues = {"full", "compact"};
    public String url;

    /**
     * Constructor for the Crypto Currency Exchange rate
     * for functions DIGITAL_CURRENCY_DAILY, DIGITAL_CURRENCY_WEEKLY, and DIGITAL_CURRENCY_MONTHLY
     * @param function     For construct of class crypto of this type can only be
     * @param symbol       Three letter symbol of the crypto currency.
     * @param market       Three letter symbol of the market you want the crypto currency's value on.
     * @param apikey       Personal Alpha Vantage API key
     */

    public crypto(String function, String symbol, String market, String apikey){
        this.url = base_url + "function=" + function + "&symbol=" + symbol + "&market=" + market + "&apikey=" + apikey;
    }

    public static void main(String[] args) {
        crypto cryptoDaily = new crypto("DIGITAL_CURRENCY_DAILY", "BTC", "CNY" ,"BKWGHZ46RDAVZQOK");
        System.out.println(cryptoDaily.url);
        cryptoDaily.get_request(cryptoDaily.url, 2000);
        cryptoDaily.write_file("cryptoDaily.json");
        crypto cryptoWeekly = new crypto("DIGITAL_CURRENCY_WEEKLY", "BTC", "CNY" ,"BKWGHZ46RDAVZQOK");
        System.out.println(cryptoWeekly.url);
        cryptoWeekly.get_request(cryptoWeekly.url, 2000);
        cryptoWeekly.write_file("cryptoWeekly.json");
        crypto cryptoMonthly = new crypto("DIGITAL_CURRENCY_MONTHLY", "BTC", "CNY" ,"BKWGHZ46RDAVZQOK");
        System.out.println(cryptoMonthly.url);
        cryptoMonthly.get_request(cryptoMonthly.url, 2000);
        cryptoMonthly.write_file("cryptoMonthly.json");
    }
}
