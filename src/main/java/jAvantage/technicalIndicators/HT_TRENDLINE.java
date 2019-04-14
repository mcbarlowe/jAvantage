package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class HT_TRENDLINE extends apiConnector {

    private String url;

    /**
     * Class to connect to the HT_TRENDLINE where HT stands for Hilbert transform instantaneous trendline
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public HT_TRENDLINE(String symbol, String interval, String series_type, String apikey) {
        this.url = base_url + "function=HT_TRENDLINE" + "&symbol=" + symbol + "&interval=" + interval
                + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        HT_TRENDLINE HT_TRENDLINEDaily = new HT_TRENDLINE("MSFT", "5min","close", "BKWGHZ46RDAVZQOK");
        System.out.println(HT_TRENDLINEDaily.url);
        HT_TRENDLINEDaily.get_request(HT_TRENDLINEDaily.url, 2000);
        HT_TRENDLINEDaily.write_file("HT_TRENDLINEDaily.json");
        HT_TRENDLINEDaily.write_csv(HT_TRENDLINEDaily.url, "HT_TRENDLINEDaily", 1000);
    }
}

