package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class DX extends apiConnector {

    private String url;

    /**
     * API call returns the DX (Directional Movement)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param apikey      Personal API key.
     */
    public DX(String symbol, String interval, int time_period, String series_type, String apikey) {
        this.url = base_url + "function=DX" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        DX DXDaily = new DX("MSFT", "5min", 100, "close", "BKWGHZ46RDAVZQOK");
        System.out.println(DXDaily.url);
        DXDaily.get_request(DXDaily.url, 2000);
        DXDaily.write_file("DXDaily.json");
        DXDaily.write_csv(DXDaily.url, "DXDaily", 1000);
    }
}
