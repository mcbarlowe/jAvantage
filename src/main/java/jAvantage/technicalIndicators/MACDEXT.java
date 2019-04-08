package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

import java.sql.Array;

public class MACDEXT extends apiConnector {

    private String url;

    /**
     * Class to connect to the MACDEXT (Simple Moving Average)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     * @param period      Optional period for MACDEXT api call in the order of fastperiod, slowperiod,
     *                    and signalperiod. Defaults are set to 12, 26, 9 respectively. The first parameter
     *                    will always be fastperiod, second slowperiod etc. If you want to assume the default
     *                    values pass null as the argument. ALso includes the matype you want to use for each
     *                    fast, slow, signal period now with this call. Can pass null if you want default.
     */
    public MACDEXT(String symbol, String interval, String series_type, String apikey, Integer... period) {
        //defaults set by Alpha Vantage API
        int fastperiod = 12;
        int slowperiod = 26;
        int signalperiod = 9;
        int fastmatype = 0;
        int slowmatype = 0;
        int signalmatype = 0;
        if (period.length == 6) {
            if (period[0] != null) {
                fastperiod = period[0];
            }
            if (period[1] != null) {
                slowperiod = period[1];
            }
            if (period[2] != null) {
                signalperiod = period[2];
            }
            if (period[3] != null) {
                fastmatype = period[3];
            }
            if (period[4] != null) {
                slowmatype = period[4];
            }
            if (period[5] != null) {
                signalmatype = period[5];
            }
            this.url = base_url + "function=MACDEXT" + "&symbol=" + symbol + "&interval=" + interval
                    + "&series_type=" + series_type + "&apikey=" + apikey +
                    "&fastperiod=" + fastperiod + "&slowperiod=" + slowperiod + "&signalperiod=" + signalperiod +
                    "&fastmatype=" + fastmatype + "&slowmatype=" + slowmatype + "&signalmatype=" + signalmatype;
        } else if (period.length == 0){
            this.url = base_url + "function=MACDEXT" + "&symbol=" + symbol + "&interval=" + interval
                    + "&series_type=" + series_type + "&apikey=" + apikey +
                    "&fastperiod=" + fastperiod + "&slowperiod=" + slowperiod + "&signalperiod=" + signalperiod +
                    "&fastmatype=" + fastmatype + "&slowmatype=" + slowmatype + "&signalmatype=" + signalmatype;
        } else  if (period.length > 3){
            throw new ArrayIndexOutOfBoundsException("You passed" + period.length + "arguments to the MACDEXT API call and it needs six.\n" +
                                                     "If you want default values remember to pass null to the option you want to have default");
        } else {
            throw new ArrayIndexOutOfBoundsException("You passed" + period.length + "arguments to the MACDEXT API call and it needs six.\n" +
                                                     "If you want default values remember to pass null to the option you want to have default");
        }
    }
    public static void main(String[] args) {
        MACDEXT MACDEXTDaily = new MACDEXT("MSFT", "5min", "close","BKWGHZ46RDAVZQOK", 5, null, 27, null, null, 1);
        System.out.println(MACDEXTDaily.url);
        MACDEXTDaily.get_request(MACDEXTDaily.url, 2000);
        MACDEXTDaily.write_file("MACDEXTDaily.json");
        MACDEXTDaily.write_csv(MACDEXTDaily.url, "MACDEXTDaily", 1000);
    }
}
