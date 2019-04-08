package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class EMA extends apiConnector {

    private String url;

    /**
     * api wrapper for EMA (exponential moving average) call. Exponential average gives more
     * weight to more recent prices than older prices.
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public EMA(String symbol, String interval, int time_period, String series_type, String apikey) {
        this.url = base_url + "function=EMA" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        EMA EMADaily = new EMA("MSFT", "5min", 100, "close", "BKWGHZ46RDAVZQOK");
        System.out.println(EMADaily.url);
        EMADaily.get_request(EMADaily.url, 2000);
        EMADaily.write_file("EMADaily.json");
        EMADaily.write_csv(EMADaily.url, "EMADaily", 1000);
    }


}
