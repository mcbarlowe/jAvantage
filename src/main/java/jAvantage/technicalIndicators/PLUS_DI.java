package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class PLUS_DI extends apiConnector {

    private String url;

    /**
     * API call returns the PLUS_DI (Plus Directional Indicator)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param apikey      Personal API key.
     */
    public PLUS_DI(String symbol, String interval, int time_period, String series_type, String apikey) {
        this.url = base_url + "function=PLUS_DI" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        PLUS_DI PLUS_DIDaily = new PLUS_DI("MSFT", "5min", 100, "close", "BKWGHZ46RDAVZQOK");
        System.out.println(PLUS_DIDaily.url);
        PLUS_DIDaily.get_request(PLUS_DIDaily.url, 2000);
        PLUS_DIDaily.write_file("PLUS_DIDaily.json");
        PLUS_DIDaily.write_csv(PLUS_DIDaily.url, "PLUS_DIDaily", 1000);
    }
}
