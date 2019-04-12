package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class MINUS_DM extends apiConnector {

    private String url;

    /**
     * API call returns the MINUS_DM (Minus Directional Movement)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param apikey      Personal API key.
     */
    public MINUS_DM(String symbol, String interval, int time_period, String apikey) {
        this.url = base_url + "function=MINUS_DM" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        MINUS_DM MINUS_DMDaily = new MINUS_DM("MSFT", "5min", 100,  "BKWGHZ46RDAVZQOK");
        System.out.println(MINUS_DMDaily.url);
        MINUS_DMDaily.get_request(MINUS_DMDaily.url, 2000);
        MINUS_DMDaily.write_file("MINUS_DMDaily.json");
        MINUS_DMDaily.write_csv(MINUS_DMDaily.url, "MINUS_DMDaily", 1000);
    }
}
