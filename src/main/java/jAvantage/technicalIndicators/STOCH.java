package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

import java.sql.Array;

public class STOCH extends apiConnector {

    private String url;

    /**
     * Class to connect to the STOCH (Simple Moving Average)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     * @param period      Optional period for STOCH api call in the order of fastkperiod,
     *                    slowkperiod, slowdperiod, slowkmatype, slowdmatype.
     */
    public STOCH(String symbol, String interval, String series_type, String apikey, Integer... period) {
        //defaults set by Alpha Vantage API
        int fastkperiod = 5;
        int slowkperiod = 3;
        int slowdperiod = 3;
        int slowkmatype = 0;
        int slowdmatype = 0;
        if (period.length == 5) {
            if (period[0] != null) {
                fastkperiod = period[0];
            }
            if (period[1] != null) {
                slowkperiod = period[1];
            }
            if (period[2] != null) {
                slowdperiod = period[2];
            }
            if (period[3] != null) {
                slowkmatype = period[3];
            }
            if (period[4] != null) {
                slowdmatype = period[4];
            }
            this.url = base_url + "function=STOCH" + "&symbol=" + symbol + "&interval=" + interval
                    + "&series_type=" + series_type + "&apikey=" + apikey +
                    "&fastkperiod=" + fastkperiod + "&slowkperiod=" + slowkperiod + "&slowdperiod=" + slowdperiod +
                    "&slowkmatype=" + slowkmatype + "&slowdmatype=" + slowdmatype;
        } else if (period.length == 0){
            this.url = base_url + "function=STOCH" + "&symbol=" + symbol + "&interval=" + interval
                    + "&series_type=" + series_type + "&apikey=" + apikey +
                    "&fastkperiod=" + fastkperiod + "&slowkperiod=" + slowkperiod + "&slowdperiod=" + slowdperiod +
                    "&slowkmatype=" + slowkmatype + "&slowdmatype=" + slowdmatype;
        } else  if (period.length > 3){
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + period.length + " arguments to the STOCH API call and it needs five.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        } else {
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + period.length + " arguments to the STOCH API call and it needs five.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        }
    }
    public static void main(String[] args) {
        STOCH STOCHDaily = new STOCH("MSFT", "5min", "close","BKWGHZ46RDAVZQOK", 5, null, 27, null, null);
        System.out.println(STOCHDaily.url);
        STOCHDaily.get_request(STOCHDaily.url, 2000);
        STOCHDaily.write_file("STOCHDaily.json");
        STOCHDaily.write_csv(STOCHDaily.url, "STOCHDaily", 1000);
    }
}
