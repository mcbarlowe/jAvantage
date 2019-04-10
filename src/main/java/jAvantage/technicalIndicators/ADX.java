package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class ADX extends apiConnector {

    private String url;

    /**
     * API call returns the ADX (Average Directional Movement Index) values of passed security
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param apikey      Personal API key.
     */
    public ADX(String symbol, String interval, int time_period, String apikey) {
        this.url = base_url + "function=ADX" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&series_type="  + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        ADX ADXDaily = new ADX("MSFT", "5min", 100, "BKWGHZ46RDAVZQOK");
        System.out.println(ADXDaily.url);
        ADXDaily.get_request(ADXDaily.url, 2000);
        ADXDaily.write_file("ADXDaily.json");
        ADXDaily.write_csv(ADXDaily.url, "ADXDaily", 1000);
    }
}
