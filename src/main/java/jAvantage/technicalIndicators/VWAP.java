package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class VWAP extends apiConnector {

    private String url;

    /**
     * Class to connect to the VWAP (Simple Moving Average) calculated by adding
     * recent closing prices and then dividing by the number of time periods in
     * the calculation average. Short term averages respond quickly to to changes in
     * price while long term are slower.
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public VWAP(String symbol, String interval, String series_type, String apikey) {
        this.url = base_url + "function=VWAP" + "&symbol=" + symbol + "&interval=" + interval
                + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        VWAP VWAPDaily = new VWAP("MSFT", "5min", "close", "BKWGHZ46RDAVZQOK");
        System.out.println(VWAPDaily.url);
        VWAPDaily.get_request(VWAPDaily.url, 2000);
        VWAPDaily.write_file("VWAPDaily.json");
        VWAPDaily.write_csv(VWAPDaily.url, "VWAPDaily", 1000);
    }
}
