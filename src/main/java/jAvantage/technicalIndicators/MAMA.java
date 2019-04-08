package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class MAMA extends apiConnector {

    private String url;

    /**
     * Class to connect to the MAMA (MESA Adaptive Moving Average)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public MAMA(String symbol, String interval, int time_period, String series_type, String apikey) {
        this.url = base_url + "function=MAMA" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        MAMA MAMADaily = new MAMA("MSFT", "5min", 100, "close", "BKWGHZ46RDAVZQOK");
        System.out.println(MAMADaily.url);
        MAMADaily.get_request(MAMADaily.url, 2000);
        MAMADaily.write_file("MAMADaily.json");
        MAMADaily.write_csv(MAMADaily.url, "MAMADaily", 1000);
    }
}
