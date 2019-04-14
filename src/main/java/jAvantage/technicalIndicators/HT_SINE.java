package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class HT_SINE extends apiConnector {

    private String url;

    /**
     * Class to connect to the HT_SINE where HT stands for Hilbert transform sine wave
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public HT_SINE(String symbol, String interval, String series_type, String apikey) {
        this.url = base_url + "function=HT_SINE" + "&symbol=" + symbol + "&interval=" + interval
                + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        HT_SINE HT_SINEDaily = new HT_SINE("MSFT", "5min","close", "BKWGHZ46RDAVZQOK");
        System.out.println(HT_SINEDaily.url);
        HT_SINEDaily.get_request(HT_SINEDaily.url, 2000);
        HT_SINEDaily.write_file("HT_SINEDaily.json");
        HT_SINEDaily.write_csv(HT_SINEDaily.url, "HT_SINEDaily", 1000);
    }
}

