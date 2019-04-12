package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class MIDPOINT extends apiConnector {

    private String url;

    /**
     * Class to connect to the MIDPOINT (MIDPOINT = (highest_value + lowest value)/2)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period number of data points used to calculate each MIDPOINT value
     * @param series_type type of price type in time series
     * @param apikey      Personal API key.
     */
    public MIDPOINT(String symbol, String interval, int time_period, String series_type, String apikey) {
        //defaults set by Alpha Vantage API
        this.url = base_url + "function=MIDPOINT" + "&symbol=" + symbol + "&interval=" + interval
                + "&series_type=" + series_type + "&apikey=" + apikey + "&time_period=" + time_period;
    }
    public static void main(String[] args) {
        MIDPOINT MIDPOINTDaily = new MIDPOINT("MSFT", "5min", 60,"close","BKWGHZ46RDAVZQOK");
        System.out.println(MIDPOINTDaily.url);
        MIDPOINTDaily.get_request(MIDPOINTDaily.url, 2000);
        MIDPOINTDaily.write_file("MIDPOINTDaily.json");
        MIDPOINTDaily.write_csv(MIDPOINTDaily.url, "MIDPOINTDaily", 1000);
    }
}
