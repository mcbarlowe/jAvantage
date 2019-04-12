package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class CMO extends apiConnector {

    private String url;

    /**
     * Class to connect to the CMO (Chande Momentum Oscillator)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period number of data points used to calculate each CMO value
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public CMO(String symbol, String interval, int time_period, String series_type, String apikey) {
        //defaults set by Alpha Vantage API
        this.url = base_url + "function=CMO" + "&symbol=" + symbol + "&interval=" + interval
                + "&series_type=" + series_type + "&apikey=" + apikey + "&time_period=" + time_period;
    }
    public static void main(String[] args) {
        CMO CMODaily = new CMO("MSFT", "5min", 60,"close","BKWGHZ46RDAVZQOK");
        System.out.println(CMODaily.url);
        CMODaily.get_request(CMODaily.url, 2000);
        CMODaily.write_file("CMODaily.json");
        CMODaily.write_csv(CMODaily.url, "CMODaily", 1000);
    }
}
