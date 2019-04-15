package jAvantage;

/**
 * This class acesses the Forex aspects of the Alpha Vantage API
 */
public class forex extends apiConnector {

    private final String[] sizeValues = {"full", "compact"};
    private String url;

    /**
     * Constructor for CURRENCY_EXCHANGE_RATE, FX_WEEKLY and FX_MONTHLY API calls.
     * This consctructor can alls be used with crypto currencies as well.
     * @param function     Forex time series you want to query
     * @param from_symbol  Three letter symbol from the Forex currency list.
     * @param to_symbol    Three letter symbol from the Forex currency list.
     * @param apikey       Personal Alpha Vantage API key
     */
    public forex(String function, String from_symbol, String to_symbol, String apikey) {
        this.url = base_url + "function=" + function + "&from_symbol=" + from_symbol + "&to_symbol="
                + to_symbol + "&apikey=" + apikey;
    }

    /**
     * Overload forex class constructor for FX_INTRADAY API call
     * @param function     Forex time series you want to query
     * @param from_symbol  Three letter symbol from the Forex symbol list.
     * @param to_symbol    Three letter symbol from the Forex symbol list.
     * @param apikey       Personal Alpha Vantage API key
     * @param outputSize   Output size of the API call
     * @param interval     Time interval between two data points in minutes
     */
    public forex(String function, String from_symbol, String to_symbol, String apikey, String outputSize, int... interval) {
        this.url = base_url + "function=" + function + "&from_symbol=" + from_symbol + "&to_symbol="
                + to_symbol + "&interval=" + interval[0] + "min&outputsize=" + outputSize + "&apikey=" + apikey;
    }

    /**
     * Overload forex class constructor for FX_DAILY API call that doesn't need interval keyword in API url.
     * @param function     Forex time series you want to query
     * @param from_symbol  Three letter symbol from the Forex symbol list.
     * @param to_symbol    Three letter symbol from the Forex symbol list.
     * @param apikey       Personal Alpha Vantage API key
     * @param outputSize   Output size of the API call
     */
    public forex(String function, String from_symbol, String to_symbol, String apikey, String outputSize) {
        this.url = base_url + "function=" + function + "&from_symbol=" + from_symbol + "&to_symbol="
                + to_symbol + "&outputsize=" + outputSize + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        crypto cryptoDaily = new crypto("DIGITAL_CURRENCY_DAILY", "BTC", "CNY" ,"BKWGHZ46RDAVZQOK");
        System.out.println(cryptoDaily.url);
        cryptoDaily.get_request(cryptoDaily.url, 2000);
        cryptoDaily.write_file("cryptoDaily.json");
        forex intraday = new forex("FX_INTRADAY", "USD", "EUR",
                "BKWGHZ46RDAVZQOK", "full",5);
        System.out.println(intraday.url);
        intraday.get_request(intraday.url, 2000);
        intraday.write_file("forex_intraday.json");
        forex fxDaily = new forex("FX_DAILY", "USD","EUR", "full");
        System.out.println(fxDaily.url);
        fxDaily.get_request(fxDaily.url, 1000);
        fxDaily.write_file("fxDaily.json");
        forex fxWeekly = new forex("FX_WEEKLY", "USD","EUR", "BKWGHZ46RDAVZQOK");
        System.out.println(fxWeekly.url);
        fxWeekly.get_request(fxWeekly.url, 1000);
        fxWeekly.write_file("fxWeekly.json");
    }
}

