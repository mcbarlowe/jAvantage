package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class AROONSOC extends apiConnector {

    private String url;

    /**
     * Class to connect to the AROONSOC (Aroon values)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period number of data points used to calculate each AROONSOC value
     * @param apikey      Personal API key.
     */
    public AROONSOC(String symbol, String interval, int time_period, String apikey) {
        //defaults set by Alpha Vantage API
        this.url = base_url + "function=AROONSOC" + "&symbol=" + symbol + "&interval=" + interval
                 + "&apikey=" + apikey + "&time_period=" + time_period;
    }
    public static void main(String[] args) {
        AROONSOC AROONSOCDaily = new AROONSOC("MSFT", "5min", 60,"BKWGHZ46RDAVZQOK");
        System.out.println(AROONSOCDaily.url);
        AROONSOCDaily.get_request(AROONSOCDaily.url, 2000);
        AROONSOCDaily.write_file("AROONSOCDaily.json");
        AROONSOCDaily.write_csv(AROONSOCDaily.url, "AROONSOCDaily", 1000);
    }
}
