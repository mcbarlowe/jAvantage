package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class HT_DCPERIOD extends apiConnector {

    private String url;

    /**
     * Class to connect to the HT_DCPERIOD (Hilbert Transform Dominant Cycle Period)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public HT_DCPERIOD(String symbol, String interval, String series_type, String apikey) {
        this.url = base_url + "function=HT_DCPERIOD" + "&symbol=" + symbol + "&interval=" + interval
                + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        HT_DCPERIOD HT_DCPERIODDaily = new HT_DCPERIOD("MSFT", "5min","close", "BKWGHZ46RDAVZQOK");
        System.out.println(HT_DCPERIODDaily.url);
        HT_DCPERIODDaily.get_request(HT_DCPERIODDaily.url, 2000);
        HT_DCPERIODDaily.write_file("HT_DCPERIODDaily.json");
        HT_DCPERIODDaily.write_csv(HT_DCPERIODDaily.url, "HT_DCPERIODDaily", 1000);
    }
}

