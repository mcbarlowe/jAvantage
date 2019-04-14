package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class OBV extends apiConnector {

    private String url;

    /**
     * Returns the on balance volume(OBV) values
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param apikey      Personal API key.
     */
    public OBV(String symbol, String interval, String apikey) {
        this.url = base_url + "function=OBV" + "&symbol=" + symbol + "&interval=" + interval
                + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        OBV OBVDaily = new OBV("MSFT", "5min","BKWGHZ46RDAVZQOK");
        System.out.println(OBVDaily.url);
        OBVDaily.get_request(OBVDaily.url, 2000);
        OBVDaily.write_file("OBVDaily.json");
        OBVDaily.write_csv(OBVDaily.url, "OBVDaily", 1000);
    }
}

