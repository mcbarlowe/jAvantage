package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class HT_DCPHASE extends apiConnector {

    private String url;

    /**
     * Class to connect to the HT_DCPHASE (Hilbert Transform Dominant Cycle Period)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public HT_DCPHASE(String symbol, String interval, String series_type, String apikey) {
        this.url = base_url + "function=HT_DCPHASE" + "&symbol=" + symbol + "&interval=" + interval
                + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        HT_DCPHASE HT_DCPHASEDaily = new HT_DCPHASE("MSFT", "5min","close", "BKWGHZ46RDAVZQOK");
        System.out.println(HT_DCPHASEDaily.url);
        HT_DCPHASEDaily.get_request(HT_DCPHASEDaily.url, 2000);
        HT_DCPHASEDaily.write_file("HT_DCPHASEDaily.json");
        HT_DCPHASEDaily.write_csv(HT_DCPHASEDaily.url, "HT_DCPHASEDaily", 1000);
    }
}

