import java.util.Arrays;

class StockTimeSeries extends ApiConnector{

    private String function;
    private String symbol;
    private int[] interval;
    private String apikey;
    private String[] sizeValues = {"full", "compact"};
    private String outputSize;

    //constructor
    StockTimeSeries(String function, String symbol, String apikey, String outputSize, int... interval){
        checkInterval(function, symbol, apikey, outputSize, interval);
    }

    public urlBuilder(String function, String symbol, String apikey, String outputSize, int... interval){

    }

    /**
     * This checks to make sure the proper interval is entered to the API and throws and exception
     * if not when the StockTimeSeries object is instantiated
     * @param function the type of time series API call you want object to make
     * @param symbol   The Stock symbol you want to query against the Alpha Vantage API
     * @param apikey   Your personal API key provided by Alpha Vantage
     * @param interval This is the time interval between two data points
     * @param outputSize Sets the output size of the API call compact returns just last 100 data points
     */
    public void checkInterval(String function, String symbol,  String apikey, String outputSize, int... interval) {
        if (interval.length == 0 && function == "TIME_SERIES_INTRADAY"){
            throw new IllegalArgumentException("Intraday Time Series API calls must have a time interval argument provided");
        }
        if (interval.length != 1){
            throw new IllegalArgumentException("Too many time interval arguments passed to StockTimeSeries instance.");
        }
        if (!Arrays.asList(1, 5, 15, 30, 60).contains(interval)) {
            throw new IllegalArgumentException("Invalid time interval passed to StockTimeSeries instance.");
        }
        if (!Arrays.asList(sizeValues).contains(outputSize)){
            throw new IllegalArgumentException("Invalid outputSize passed to StockTimeSeries instance.");
        }
        this.function = function;
        this.symbol = symbol;
        this.interval = interval;
        this.apikey = apikey;
        this.outputSize = outputSize;
    }
    public static void main(String[] args) {
        String test_url;
        StockTimeSeries intraday = new StockTimeSeries("TIME_SERIES_INTRADAY", "MSFT",  "BKWGHZ46RDAVZQOK", 5);
        test_url = StockTimeSeries.base_url + "function="+ intraday.function + "&symbol=" + intraday.symbol + "&interval=" + intraday.interval + "&apikey=" + intraday.apikey;
        System.out.println(test_url);
        intraday.get_request(test_url, 1000);
    }
}
