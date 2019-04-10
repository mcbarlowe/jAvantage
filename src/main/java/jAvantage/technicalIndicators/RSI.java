package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class RSI extends apiConnector {

    private String url;

    /**
     * API connector to return RSI (Relative Strength Index) values.
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public RSI(String symbol, String interval, int time_period, String series_type, String apikey) {
        this.url = base_url + "function=SMA" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        RSI RSIDaily = new RSI("MSFT", "5min", 100, "close", "BKWGHZ46RDAVZQOK");
        System.out.println(RSIDaily.url);
        RSIDaily.get_request(RSIDaily.url, 2000);
        RSIDaily.write_file("RSIDaily.json");
        RSIDaily.write_csv(RSIDaily.url, "RSIDaily", 1000);
    }
}


