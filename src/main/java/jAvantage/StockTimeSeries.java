package jAvantage;

import java.util.Arrays;

/**
 * This class access the Stock/securities portion of the Alpha Vantage API
 */
public class StockTimeSeries extends apiConnector{

    private final String[] sizeValues = {"full", "compact"};
    public String url;

    /**
     * Constructor for the StockTimeSeries class which runs the checkInputs method to make sure
     * all the parameters have been entered in properly for the TIME_SERIES_INTRADAY API call
     * @param function the type of time series API call you want object to make
     * @param symbol   The Stock symbol you want to query against the Alpha Vantage API
     * @param apikey   Your personal API key provided by Alpha Vantage
     * @param interval This is the time interval between two data points in minutes
     * @param outputSize Sets the output size of the API call compact returns just last 100 data points
     */
    public StockTimeSeries(String function, String symbol, String apikey, String outputSize, int... interval){
        checkInputs(function, symbol, apikey, outputSize, interval);
        this.url = base_url + "function=" + function + "&symbol=" + symbol + "&interval=" + interval[0] +"min" +
            "&outputsize=" + outputSize + "&apikey=" + apikey;
    }
    /**
     * Override constructor for the StockTimeSeries class which runs the checkInputs method to make sure
     * all the parameters have been entered in properly for TIME_SERIES_DAILY, TIME_SERIES_ADJUSTED
     * @param function the type of time series API call you want object to make
     * @param symbol   The Stock symbol you want to query against the Alpha Vantage API
     * @param apikey   Your personal API key provided by Alpha Vantage
     * @param outputSize Sets the output size of the API call compact returns just last 100 data points
     */
    public StockTimeSeries(String function, String symbol, String apikey, String outputSize){
        checkInputs(function, symbol, apikey, outputSize);
        this.url = base_url + "function=" + function + "&symbol=" + symbol +
            "&outputsize=" + outputSize + "&apikey=" + apikey;
    }

    /**
     * Override constructor for the StockTimeSeries class which runs the checkInputs method to make sure
     * all the parameters have been entered in properly for TIME_SERIES_WEEKLY, TIME_SERIES_WEEKLY_ADJUSTED,
     * TIME_SERIES_MONTHLY, TIME_SERIES_MONTHLY_ADJUSTED, GLOBAL_QUOTE
     * @param function the type of time series API call you want object to make
     * @param symbol   The Stock symbol you want to query against the Alpha Vantage API
     * @param apikey   Your personal API key provided by Alpha Vantage
     */
    public StockTimeSeries(String function, String symbol, String apikey){
        checkInputs(function, symbol, apikey);
        this.url = base_url + "function=" + function + "&symbol=" + symbol +
                "&apikey=" + apikey;
    }
    /**
     * This checks to make sure the proper interval is entered to the API and throws and exception
     * if not when the StockTimeSeries object is instantiated for TIME_SERIES_INTRADAY API call
     * @param function the type of time series API call you want object to make
     * @param symbol   The Stock symbol you want to query against the Alpha Vantage API
     * @param apikey   Your personal API key provided by Alpha Vantage
     * @param interval This is the time interval between two data points
     * @param outputSize Sets the output size of the API call compact returns just last 100 data points
     */
    private void checkInputs(String function, String symbol, String apikey, String outputSize, int... interval) {
        if (interval.length == 0 && function.equals("TIME_SERIES_INTRADAY")){
            throw new IllegalArgumentException("Intraday Time Series API calls must have a time interval argument provided");
        }
        if (interval.length != 1){
            throw new IllegalArgumentException("Too many time interval arguments passed to StockTimeSeries instance.");
        }
        if (!Arrays.asList(1, 5, 15, 30, 60).contains(interval[0])) {
            throw new IllegalArgumentException("Invalid time interval passed to StockTimeSeries instance.");
        }
        if (!Arrays.asList(sizeValues).contains(outputSize)){
            throw new IllegalArgumentException("Invalid outputSize passed to StockTimeSeries instance.");
        }
    }
    /**
     * Overrides checkInputs when you want API calls for TIME_SERIES_DAILY, TIME_SERIES_ADJUSTED
     * API calls
     * @param function the type of time series API call you want object to make
     * @param symbol   The Stock symbol you want to query against the Alpha Vantage API
     * @param apikey   Your personal API key provided by Alpha Vantage
     * @param outputSize Sets the output size of the API call compact returns just last 100 data points
     */
    private void checkInputs(String function, String symbol, String apikey, String outputSize) {
        if (!Arrays.asList(sizeValues).contains(outputSize)){
            throw new IllegalArgumentException("Invalid outputSize passed to StockTimeSeries instance.");
        }
        if (isNullOrEmpty(function) || isNullOrEmpty(symbol) || isNullOrEmpty(apikey)){
            throw new IllegalArgumentException("Invalid parameters passed to StockTimeSeries instance.");
        }
    }
    /**
     * Overrides checkInputs when you want API calls for TIME_SERIES_DAILY, TIME_SERIES_ADJUSTED
     * API calls
     * @param function the type of time series API call you want object to make
     * @param symbol   The Stock symbol you want to query against the Alpha Vantage API
     * @param apikey   Your personal API key provided by Alpha Vantage
     */
    private void checkInputs(String function, String symbol, String apikey) {
        if (isNullOrEmpty(function) || isNullOrEmpty(symbol) || isNullOrEmpty(apikey)){
            throw new IllegalArgumentException("Invalid parameters passed to StockTimeSeries instance.");
        }
    }

    public static void main(String[] args) {
        StockTimeSeries intraday = new StockTimeSeries("TIME_SERIES_INTRADAY", "MSFT",
                "BKWGHZ46RDAVZQOK", "full",5);
        System.out.println(intraday.url);
        intraday.get_request(intraday.url, 1000);
        intraday.write_file("intraday.json");
        StockTimeSeries timeSeriesDaily = new StockTimeSeries("TIME_SERIES_DAILY", "MSFT",
                "BKWGHZ46RDAVZQOK", "full");
        System.out.println(timeSeriesDaily.url);
        timeSeriesDaily.get_request(timeSeriesDaily.url, 850);
        timeSeriesDaily.write_file("timeSeriesDaily.json");
        StockTimeSeries timeSeriesWeekly = new StockTimeSeries("TIME_SERIES_WEEKLY", "MSFT",
                "BKWGHZ46RDAVZQOK");
        System.out.println(timeSeriesWeekly.url);
        timeSeriesWeekly.get_request(timeSeriesWeekly.url, 750);
        timeSeriesWeekly.write_file("timeSeriesWeekly.json");
    }


}
