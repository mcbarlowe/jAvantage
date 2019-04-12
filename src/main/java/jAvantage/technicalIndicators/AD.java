package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class AD extends apiConnector {

    private String url;

    /**
     * Class to connect to the AD (Chaikin A/D Line)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param apikey      Personal API key.
     */
    public AD(String symbol, String interval, String apikey) {
        //defaults set by Alpha Vantage API
        this.url = base_url + "function=AD" + "&symbol=" + symbol + "&interval=" + interval
                +  "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        AD ADDaily = new AD("MSFT", "5min", "BKWGHZ46RDAVZQOK");
        System.out.println(ADDaily.url);
        ADDaily.get_request(ADDaily.url, 2000);
        ADDaily.write_file("ADDaily.json");
        ADDaily.write_csv(ADDaily.url, "ADDaily", 1000);
    }
}
