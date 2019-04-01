class intraDayApiConnector extends ApiConnector{

    private final String function;
    private final String symbol;
    private final String interval;
    private final String apikey;

    //constructor
    intraDayApiConnector(String function, String symbol, String interval, String apikey){
        super();
        this.function = function;
        this.symbol = symbol;
        this.interval = interval;
        this.apikey = apikey;
    }

    public static void main(String[] args) {
        String test_url;
        intraDayApiConnector intraday = new intraDayApiConnector("TIME_SERIES_INTRADAY", "MSFT", "5min", "BKWGHZ46RDAVZQOK");
        test_url = intraDayApiConnector.base_url + "function="+ intraday.function + "&symbol=" + intraday.symbol + "&interval=" + intraday.interval + "&apikey=" + intraday.apikey;
        System.out.println(test_url);
        intraday.get_request(test_url, 10);
    }
}
