package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

import java.sql.Array;

public class MOM extends apiConnector {

    private String url;

    /**
     * Class to connect to the MOM (Momentum Values)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period number of data points used to calculate each MOM value
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public MOM(String symbol, String interval, int time_period, String series_type, String apikey) {
        //defaults set by Alpha Vantage API
            this.url = base_url + "function=MOM" + "&symbol=" + symbol + "&interval=" + interval
                    + "&series_type=" + series_type + "&apikey=" + apikey + "&time_period=" + time_period;
    }
    public static void main(String[] args) {
        MOM MOMDaily = new MOM("MSFT", "5min", 60,"close","BKWGHZ46RDAVZQOK" );
        System.out.println(MOMDaily.url);
        MOMDaily.get_request(MOMDaily.url, 2000);
        MOMDaily.write_file("MOMDaily.json");
        MOMDaily.write_csv(MOMDaily.url, "MOMDaily", 1000);
    }
}
