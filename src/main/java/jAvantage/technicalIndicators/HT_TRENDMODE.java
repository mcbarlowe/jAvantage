package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class HT_TRENDMODE extends apiConnector {

    private String url;

    /**
     * Class to connect to the HT_TRENDMODE Hilbert transform trend vs cycle mode
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public HT_TRENDMODE(String symbol, String interval, String series_type, String apikey) {
        this.url = base_url + "function=HT_TRENDMODE" + "&symbol=" + symbol + "&interval=" + interval
                + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        HT_TRENDMODE HT_TRENDMODEDaily = new HT_TRENDMODE("MSFT", "5min","close", "BKWGHZ46RDAVZQOK");
        System.out.println(HT_TRENDMODEDaily.url);
        HT_TRENDMODEDaily.get_request(HT_TRENDMODEDaily.url, 2000);
        HT_TRENDMODEDaily.write_file("HT_TRENDMODEDaily.json");
        HT_TRENDMODEDaily.write_csv(HT_TRENDMODEDaily.url, "HT_TRENDMODEDaily", 1000);
    }
}


