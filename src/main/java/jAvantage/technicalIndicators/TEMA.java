package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class TEMA extends apiConnector {

    private String url;

    /**
     * Class to connect to the TEMA (Triple Exponential Moving Average). See comments for DEMA class
     * on calculation and use.
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public TEMA(String symbol, String interval, int time_period, String series_type, String apikey) {
        this.url = base_url + "function=TEMA" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        TEMA TEMADaily = new TEMA("MSFT", "5min", 100, "close", "BKWGHZ46RDAVZQOK");
        System.out.println(TEMADaily.url);
        TEMADaily.get_request(TEMADaily.url, 2000);
        TEMADaily.write_file("TEMADaily.json");
        TEMADaily.write_csv(TEMADaily.url, "TEMADaily", 1000);
    }
}

