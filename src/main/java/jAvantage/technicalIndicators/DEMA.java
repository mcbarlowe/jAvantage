package jAvantage.technicalIndicators;

        import jAvantage.apiConnector;

public class DEMA extends apiConnector {

    private String url;

    /**
     * Returns double exponential moving average with the formula DEMA = 2 * EMA - EMA(EMA) where
     * EMA = EMA(1) + a * (Close - EMA(1)) and a = 2/(N+1) where N = the smoothing period. DEMA crossover
     * points generally happen sooner than standard SMA crossover points
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period Number of data points used to calculate the moving average.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public DEMA(String symbol, String interval, int time_period, String series_type, String apikey) {
        this.url = base_url + "function=DEMA" + "&symbol=" + symbol + "&interval=" + interval
                + "&time_period=" + time_period + "&series_type=" + series_type + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        DEMA DEMADaily = new DEMA("MSFT", "5min", 100, "close", "BKWGHZ46RDAVZQOK");
        System.out.println(DEMADaily.url);
        DEMADaily.get_request(DEMADaily.url, 2000);
        DEMADaily.write_file("DEMADaily.json");
        DEMADaily.write_csv(DEMADaily.url, "DEMADaily", 1000);
    }
}

