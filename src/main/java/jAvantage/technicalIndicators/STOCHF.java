package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

import java.sql.Array;

public class STOCHF extends apiConnector {

    private String url;

    /**
     * Class to connect to the STOCHF (Stochastic Fast)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     * @param period      Optional period for STOCHF api call in the order of fastkperiod,
     *                    slowkperiod, slowdperiod, slowkmatype, slowdmatype.
     */
    public STOCHF(String symbol, String interval, String series_type, String apikey, Integer... period) {
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
            this.url = base_url + "function=STOCHF" + "&symbol=" + symbol + "&interval=" + interval
                    + "&series_type=" + series_type + "&apikey=" + apikey +
                    "&fastkperiod=" + fastkperiod +  "&fastdperiod=" + fastdperiod +
                     "&fastdmatype=" + fastdmatype;
        } else if (period.length == 0){
            this.url = base_url + "function=STOCHF" + "&symbol=" + symbol + "&interval=" + interval
                    + "&series_type=" + series_type + "&apikey=" + apikey +
                    "&fastkperiod=" + fastkperiod +  "&fastdperiod=" + fastdperiod +
                    "&fastdmatype=" + fastdmatype;
        } else  if (period.length > 3){
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + period.length + " arguments to the STOCHF API call and it needs three.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        } else {
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + period.length + " arguments to the STOCHF API call and it needs three.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        }
    }
    public static void main(String[] args) {
        STOCHF STOCHFDaily = new STOCHF("MSFT", "5min", "close","BKWGHZ46RDAVZQOK", 5, null, 27, null, null);
        System.out.println(STOCHFDaily.url);
        STOCHFDaily.get_request(STOCHFDaily.url, 2000);
        STOCHFDaily.write_file("STOCHFDaily.json");
        STOCHFDaily.write_csv(STOCHFDaily.url, "STOCHFDaily", 1000);
    }
}
