package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

import java.sql.Array;

public class BOP extends apiConnector {

    private String url;

    /**
     * Class to connect to the BOP (Balance of Power Values)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param apikey      Personal API key.
     */
    public BOP(String symbol, String interval, String apikey) {
        //defaults set by Alpha Vantage API
        this.url = base_url + "function=BOP" + "&symbol=" + symbol + "&interval=" + interval
                + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        BOP BOPDaily = new BOP("MSFT", "5min", "BKWGHZ46RDAVZQOK" );
        System.out.println(BOPDaily.url);
        BOPDaily.get_request(BOPDaily.url, 2000);
        BOPDaily.write_file("BOPDaily.json");
        BOPDaily.write_csv(BOPDaily.url, "BOPDaily", 1000);
    }
}
