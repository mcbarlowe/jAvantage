package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class AROON extends apiConnector {

    private String url;

    /**
     * Class to connect to the AROON (Aroon values)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period number of data points used to calculate each AROON value
     * @param apikey      Personal API key.
     */
    public AROON(String symbol, String interval, int time_period,  String apikey) {
        //defaults set by Alpha Vantage API
        this.url = base_url + "function=AROON" + "&symbol=" + symbol + "&interval=" + interval
                 + "&apikey=" + apikey + "&time_period=" + time_period;
    }
    public static void main(String[] args) {
        AROON AROONDaily = new AROON("MSFT", "5min", 60,"BKWGHZ46RDAVZQOK");
        System.out.println(AROONDaily.url);
        AROONDaily.get_request(AROONDaily.url, 2000);
        AROONDaily.write_file("AROONDaily.json");
        AROONDaily.write_csv(AROONDaily.url, "AROONDaily", 1000);
    }
}
