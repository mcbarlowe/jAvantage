package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

import java.sql.Array;

public class MACD extends apiConnector {

    private String url;

    /**
     * Class to connect to the MACD (Simple Moving Average)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     * @param options     Optional options for MACD api call in the order of fastperiod, slowperiod,
     *                    and signalperiod. Defaults are set to 12, 26, 9 respectively. The first parameter
     *                    will always be fastperiod, second slowperiod etc. If you want to assume the default
     *                    values pass null as the argument
     */
    public MACD(String symbol, String interval, String series_type, String apikey, Integer... options) {
        //defaults set by Alpha Vantage API
        int fastperiod = 12;
        int slowperiod = 26;
        int signalperiod = 9;
        if (options.length == 3) {
            if (options[0] != null) {
                fastperiod = options[0];
            }
            if (options[1] != null) {
                slowperiod = options[1];
            }
            if (options[2] != null) {
                signalperiod = options[2];
            }
            this.url = base_url + "function=MACD" + "&symbol=" + symbol + "&interval=" + interval
                    + "&series_type=" + series_type + "&apikey=" + apikey +
                    "&fastperiod=" + fastperiod + "&slowperiod=" + slowperiod + "&signalperiod=" + signalperiod;
        } else if (options.length == 0){
            this.url = base_url + "function=MACD" + "&symbol=" + symbol + "&interval=" + interval
                    + "&series_type=" + series_type + "&apikey=" + apikey +
                    "&fastperiod=" + fastperiod + "&slowperiod=" + slowperiod + "&signalperiod=" + signalperiod;
        } else  if (options.length > 3){
            throw new ArrayIndexOutOfBoundsException("You passed too many arguments to the MACD API call");
        } else {
            throw new ArrayIndexOutOfBoundsException("You passed too few arguments to the MACD API call");
        }
    }
    public static void main(String[] args) {
        MACD MACDDaily = new MACD("MSFT", "5min", "close","BKWGHZ46RDAVZQOK", 5, null, 27);
        System.out.println(MACDDaily.url);
        MACDDaily.get_request(MACDDaily.url, 2000);
        MACDDaily.write_file("MACDDaily.json");
        MACDDaily.write_csv(MACDDaily.url, "MACDDaily", 1000);
    }
}
