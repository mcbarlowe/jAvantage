package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class SMA extends apiConnector {

    private String url;

    /**
     * Class to connect to the SMA (Simple Moving Average) calculated by adding
     * recent closing prices and then dividing by the number of time periods in
     * the calculation average. Short term averages respond quickly to to changes in
     * price while long term are slower.
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public SMA(String symbol, String interval, int time_period, String series_type, String apikey) {
        this.url = base_url + "function=SMA" + "&symbol=" + symbol + "&interval=" + interval
           + "&time_period=" + time_period + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        SMA SMADaily = new SMA("MSFT", "5min", 100, "close", "BKWGHZ46RDAVZQOK");
        System.out.println(SMADaily.url);
        SMADaily.get_request(SMADaily.url, 2000);
        SMADaily.write_file("SMADaily.json");
    }
}
