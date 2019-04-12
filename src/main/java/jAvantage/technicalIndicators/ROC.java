package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class ROC extends apiConnector {

    private String url;

    /**
     * Class to connect to the ROC (Rate of Change)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period number of data points used to calculate each ROC value
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public ROC(String symbol, String interval, int time_period, String series_type, String apikey) {
        //defaults set by Alpha Vantage API
        this.url = base_url + "function=ROC" + "&symbol=" + symbol + "&interval=" + interval
                + "&series_type=" + series_type + "&apikey=" + apikey + "&time_period=" + time_period;
    }
    public static void main(String[] args) {
        ROC ROCDaily = new ROC("MSFT", "5min", 60,"close","BKWGHZ46RDAVZQOK");
        System.out.println(ROCDaily.url);
        ROCDaily.get_request(ROCDaily.url, 2000);
        ROCDaily.write_file("ROCDaily.json");
        ROCDaily.write_csv(ROCDaily.url, "ROCDaily", 1000);
    }
}
