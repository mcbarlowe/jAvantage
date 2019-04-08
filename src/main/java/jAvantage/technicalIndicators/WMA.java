package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class WMA extends apiConnector{

    private String url;

    /**
     * WMA (Weighted Moving Average) puts more weight on recent and less on past data. WMA is
     * generally more sensitive to price movement which means it could identify trends sooner
     * than a SMA but will experience more whipsaws. WMA is weighted by period selected for
     * example a period of 5 is calculated as
     * WMA = (P1 * 5) + (P2 * 4) + (P3 * 3) + (P4 * 2) + (P5 * 1) / (5 + 4+ 3 + 2 + 1)
     * where P1 = current price, p2 = price one bar ago, etc.
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public WMA(String symbol, String interval, int time_period, String series_type, String apikey) {
        this.url = base_url + "function=SMA" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&series_type=" + series_type + "&apikey=" + apikey;
    }
}
