package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class T3 extends apiConnector {

    private String url;

    /**
     * Class to connect to the T3 (Simple Moving Average) calculated by adding
     * recent closing prices and then dividing by the number of time periods in
     * the calculation average. Short term averages respond quickly to to changes in
     * price while long term are slower.
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public T3(String symbol, String interval, int time_period, String series_type, String apikey) {
        this.url = base_url + "function=T3" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        T3 T3Daily = new T3("MSFT", "5min", 100, "close", "BKWGHZ46RDAVZQOK");
        System.out.println(T3Daily.url);
        T3Daily.get_request(T3Daily.url, 2000);
        T3Daily.write_file("T3Daily.json");
        T3Daily.write_csv(T3Daily.url, "T3Daily", 1000);
    }
}
