package jAvantage.technicalIndicators;

        import jAvantage.apiConnector;

public class ATR extends apiConnector {

    private String url;

    /**
     * Class to connect to the ATR (Average True Range)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period number of data points used to calculate each ATR value
     * @param apikey      Personal API key.
     */
    public ATR(String symbol, String interval, int time_period, String apikey) {
        //defaults set by Alpha Vantage API
        this.url = base_url + "function=ATR" + "&symbol=" + symbol + "&interval=" + interval
                +  "&apikey=" + apikey + "&time_period=" + time_period;
    }
    public static void main(String[] args) {
        ATR ATRDaily = new ATR("MSFT", "5min", 60,"BKWGHZ46RDAVZQOK");
        System.out.println(ATRDaily.url);
        ATRDaily.get_request(ATRDaily.url, 2000);
        ATRDaily.write_file("ATRDaily.json");
        ATRDaily.write_csv(ATRDaily.url, "ATRDaily", 1000);
    }
}
