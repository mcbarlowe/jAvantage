package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class KAMA extends apiConnector {

    private String url;

    /**
     * Class to connect to the KAMA (Kaufman Adaptive Moving Average)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public KAMA(String symbol, String interval, int time_period, String series_type, String apikey) {
        this.url = base_url + "function=KAMA" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        KAMA KAMADaily = new KAMA("MSFT", "5min", 100, "close", "BKWGHZ46RDAVZQOK");
        System.out.println(KAMADaily.url);
        KAMADaily.get_request(KAMADaily.url, 2000);
        KAMADaily.write_file("KAMADaily.json");
        KAMADaily.write_csv(KAMADaily.url, "KAMADaily", 1000);
    }
}
