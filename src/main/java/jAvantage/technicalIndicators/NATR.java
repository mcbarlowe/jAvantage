package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class NATR extends apiConnector {

    private String url;

    /**
     * Class to connect to the NATR (Normalized Average True Range)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period number of data points used to calculate each NATR value
     * @param apikey      Personal API key.
     */
    public NATR(String symbol, String interval, int time_period, String apikey) {
        //defaults set by Alpha Vantage API
        this.url = base_url + "function=NATR" + "&symbol=" + symbol + "&interval=" + interval
                +  "&apikey=" + apikey + "&time_period=" + time_period;
    }
    public static void main(String[] args) {
        NATR NATRDaily = new NATR("MSFT", "5min", 60,"BKWGHZ46RDAVZQOK");
        System.out.println(NATRDaily.url);
        NATRDaily.get_request(NATRDaily.url, 2000);
        NATRDaily.write_file("NATRDaily.json");
        NATRDaily.write_csv(NATRDaily.url, "NATRDaily", 1000);
    }
}
