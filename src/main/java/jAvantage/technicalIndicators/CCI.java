package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

import java.sql.Array;

public class CCI extends apiConnector {

    private String url;

    /**
     * Class to connect to the CCI (Commodity Channel Index Values)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param apikey      Personal API key.
     * @param time_period number of data points used to calculate each MOM value
     */
    public CCI(String symbol, String interval, int time_period, String apikey) {
        //defaults set by Alpha Vantage API
        this.url = base_url + "function=CCI" + "&symbol=" + symbol + "&interval=" + interval
                + "&apikey=" + apikey + "&time_period=" + time_period;
    }
    public static void main(String[] args) {
        CCI CCIDaily = new CCI("MSFT", "5min",60, "BKWGHZ46RDAVZQOK" );
        System.out.println(CCIDaily.url);
        CCIDaily.get_request(CCIDaily.url, 2000);
        CCIDaily.write_file("CCIDaily.json");
        CCIDaily.write_csv(CCIDaily.url, "CCIDaily", 1000);
    }
}
