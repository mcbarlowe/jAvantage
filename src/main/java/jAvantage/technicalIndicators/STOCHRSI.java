package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

import java.sql.Array;

public class STOCHRSI extends apiConnector {

    private String url;

    /**
     * Class to connect to the STOCHRSI (Stochastic Fast)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period number of data points used to calculate each STOCHRSI value
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     * @param period      Optional period for STOCHRSI api call in the order of fastkperiod,
     *                    slowkperiod, slowdperiod, slowkmatype, slowdmatype.
     */
    public STOCHRSI(String symbol, String interval, int time_period, String series_type, String apikey, Integer... period) {
        //defaults set by Alpha Vantage API
        int fastkperiod = 5;
        int fastdperiod = 3;
        int fastdmatype = 0;
        if (period.length == 5) {
            if (period[0] != null) {
                fastkperiod = period[0];
            }
            if (period[2] != null) {
                fastdperiod = period[2];
            }
            if (period[4] != null) {
                fastdmatype = period[4];
            }
            this.url = base_url + "function=STOCHRSI" + "&symbol=" + symbol + "&interval=" + interval
                    + "&series_type=" + series_type + "&apikey=" + apikey + "&time_period=" + time_period +
                    "&fastkperiod=" + fastkperiod +  "&fastdperiod=" + fastdperiod +
                    "&fastdmatype=" + fastdmatype;
        } else if (period.length == 0){
            this.url = base_url + "function=STOCHRSI" + "&symbol=" + symbol + "&interval=" + interval
                    + "&series_type=" + series_type + "&apikey=" + apikey + "&time_period=" + time_period +
                    "&fastkperiod=" + fastkperiod +  "&fastdperiod=" + fastdperiod +
                    "&fastdmatype=" + fastdmatype;
        } else  if (period.length > 3){
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + period.length + " arguments to the STOCHRSI API call and it needs eight.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        } else {
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + period.length + " arguments to the STOCHRSI API call and it needs eight.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        }
    }
    public static void main(String[] args) {
        STOCHRSI STOCHRSIDaily = new STOCHRSI("MSFT", "5min", 60,"close","BKWGHZ46RDAVZQOK", 5, null, 27, null, null);
        System.out.println(STOCHRSIDaily.url);
        STOCHRSIDaily.get_request(STOCHRSIDaily.url, 2000);
        STOCHRSIDaily.write_file("STOCHRSIDaily.json");
        STOCHRSIDaily.write_csv(STOCHRSIDaily.url, "STOCHRSIDaily", 1000);
    }
}
