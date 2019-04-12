package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class PLUS_DM extends apiConnector {

    private String url;

    /**
     * API call returns the PLUS_DM (Plus Directional Movement)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param apikey      Personal API key.
     */
    public PLUS_DM(String symbol, String interval, int time_period, String apikey) {
        this.url = base_url + "function=PLUS_DM" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        PLUS_DM PLUS_DMDaily = new PLUS_DM("MSFT", "5min", 100,  "BKWGHZ46RDAVZQOK");
        System.out.println(PLUS_DMDaily.url);
        PLUS_DMDaily.get_request(PLUS_DMDaily.url, 2000);
        PLUS_DMDaily.write_file("PLUS_DMDaily.json");
        PLUS_DMDaily.write_csv(PLUS_DMDaily.url, "PLUS_DMDaily", 1000);
    }
}
