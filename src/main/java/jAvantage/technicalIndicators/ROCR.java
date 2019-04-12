package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class ROCR extends apiConnector {

    private String url;

    /**
     * Class to connect to the ROCR (Rate of Change Ratio)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period number of data points used to calculate each ROCR value
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public ROCR(String symbol, String interval, int time_period, String series_type, String apikey) {
        //defaults set by Alpha Vantage API
        this.url = base_url + "function=ROCR" + "&symbol=" + symbol + "&interval=" + interval
                + "&series_type=" + series_type + "&apikey=" + apikey + "&time_period=" + time_period;
    }
    public static void main(String[] args) {
        ROCR ROCRDaily = new ROCR("MSFT", "5min", 60,"close","BKWGHZ46RDAVZQOK");
        System.out.println(ROCRDaily.url);
        ROCRDaily.get_request(ROCRDaily.url, 2000);
        ROCRDaily.write_file("ROCRDaily.json");
        ROCRDaily.write_csv(ROCRDaily.url, "ROCRDaily", 1000);
    }
}
