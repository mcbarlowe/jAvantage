package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class TRIMA extends apiConnector {

    private String url;

    /**
     * Class to connect to the TRIMA (Triangular Moving Average) calculated by
     * taking the SMA of the SMA. Greater weight is place on values near the middle of the
     * period and reacts relatively slowly to price changes. This reduces whipsaw and keeps the
     * trend stable despite fluctuating prices and requires a sustained move in price to change
     * the trend.
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public TRIMA(String symbol, String interval, int time_period, String series_type, String apikey) {
        this.url = base_url + "function=TRIMA" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        TRIMA TRIMADaily = new TRIMA("MSFT", "5min", 100, "close", "BKWGHZ46RDAVZQOK");
        System.out.println(TRIMADaily.url);
        TRIMADaily.get_request(TRIMADaily.url, 2000);
        TRIMADaily.write_file("TRIMADaily.json");
        TRIMADaily.write_csv(TRIMADaily.url, "TRIMADaily", 1000);
    }
}

