package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class MINUS_DI extends apiConnector {

    private String url;

    /**
     * API call returns the MINUS_DI (Minus Directional Indicator)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param apikey      Personal API key.
     */
    public MINUS_DI(String symbol, String interval, int time_period, String apikey) {
        this.url = base_url + "function=MINUS_DI" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        MINUS_DI MINUS_DIDaily = new MINUS_DI("MSFT", "5min", 100,  "BKWGHZ46RDAVZQOK");
        System.out.println(MINUS_DIDaily.url);
        MINUS_DIDaily.get_request(MINUS_DIDaily.url, 2000);
        MINUS_DIDaily.write_file("MINUS_DIDaily.json");
        MINUS_DIDaily.write_csv(MINUS_DIDaily.url, "MINUS_DIDaily", 1000);
    }
}
