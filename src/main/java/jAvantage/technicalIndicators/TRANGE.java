package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class TRANGE extends apiConnector {

    private String url;

    /**
     * Class to connect to the TRANGE (True Range)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period number of data points used to calculate each TRANGE value
     * @param apikey      Personal API key.
     */
    public TRANGE(String symbol, String interval, int time_period, String apikey) {
        //defaults set by Alpha Vantage API
        this.url = base_url + "function=TRANGE" + "&symbol=" + symbol + "&interval=" + interval
                + "&apikey=" + apikey + "&time_period=" + time_period;
    }
    public static void main(String[] args) {
        TRANGE TRANGEDaily = new TRANGE("MSFT", "5min", 60,"BKWGHZ46RDAVZQOK");
        System.out.println(TRANGEDaily.url);
        TRANGEDaily.get_request(TRANGEDaily.url, 2000);
        TRANGEDaily.write_file("TRANGEDaily.json");
        TRANGEDaily.write_csv(TRANGEDaily.url, "TRANGEDaily", 1000);
    }
}
