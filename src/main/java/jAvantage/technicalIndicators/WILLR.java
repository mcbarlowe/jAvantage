package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class WILLR extends apiConnector {

    private String url;

    /**
     * API call returns the WILLR (WIlliams' %R) values of passed security
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param apikey      Personal API key.
     */
    public WILLR(String symbol, String interval, int time_period, String series_type, String apikey) {
        this.url = base_url + "function=WILLR" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        WILLR WILLRDaily = new WILLR("MSFT", "5min", 100, "close", "BKWGHZ46RDAVZQOK");
        System.out.println(WILLRDaily.url);
        WILLRDaily.get_request(WILLRDaily.url, 2000);
        WILLRDaily.write_file("WILLRDaily.json");
        WILLRDaily.write_csv(WILLRDaily.url, "WILLRDaily", 1000);
    }
}
