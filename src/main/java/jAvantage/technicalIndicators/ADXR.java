package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class ADXR extends apiConnector {

    private String url;

    /**
     * API call returns the ADXR (Average Directional Movement Index Rating) values of passed security
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param apikey      Personal API key.
     */
    public ADXR(String symbol, String interval, int time_period, String apikey) {
        this.url = base_url + "function=ADXR" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&series_type="  + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        ADXR ADXRDaily = new ADXR("MSFT", "5min", 100, "BKWGHZ46RDAVZQOK");
        System.out.println(ADXRDaily.url);
        ADXRDaily.get_request(ADXRDaily.url, 2000);
        ADXRDaily.write_file("ADXRDaily.json");
        ADXRDaily.write_csv(ADXRDaily.url, "ADXRDaily", 1000);
    }
}
