package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class HT_PHASOR extends apiConnector {

    private String url;

    /**
     * Class to connect to the HT_PHASOR (Hilbert Transform Phasor Components)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public HT_PHASOR(String symbol, String interval, String series_type, String apikey) {
        this.url = base_url + "function=HT_PHASOR" + "&symbol=" + symbol + "&interval=" + interval
                + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        HT_PHASOR HT_PHASORDaily = new HT_PHASOR("MSFT", "5min","close", "BKWGHZ46RDAVZQOK");
        System.out.println(HT_PHASORDaily.url);
        HT_PHASORDaily.get_request(HT_PHASORDaily.url, 2000);
        HT_PHASORDaily.write_file("HT_PHASORDaily.json");
        HT_PHASORDaily.write_csv(HT_PHASORDaily.url, "HT_PHASORDaily", 1000);
    }
}

