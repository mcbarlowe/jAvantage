package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class BBANDS extends apiConnector {

    private String url;

    /**
     * Class to connect to the BBANDS (Bollinger Bands)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_options number of data points used to calculate each BBANDS value
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     * @param options      Optional options for BBANDS api call in the order of fastoptions,
     *                    slowdoptions, matype.
     */
    public BBANDS(String symbol, String interval, int time_options, String series_type, String apikey, Integer... options) {
        //defaults set by Alpha Vantage API
        int nbdevup = 5;
        int nbdevdn = 3;
        int matype = 0;
        if (options.length == 3) {
            if (options[0] != null) {
                nbdevup = options[0];
            }
            if (options[1] != null) {
                 nbdevdn = options[1];
            }
            if (options[2] != null) {
                matype = options[2];
            }
            this.url = base_url + "function=BBANDS" + "&symbol=" + symbol + "&interval=" + interval
                    + "&series_type=" + series_type + "&apikey=" + apikey + "&time_options=" + time_options +
                    "&nbdevup=" + nbdevup +  "&nbdevdn=" + nbdevdn +
                    "&matype=" + matype;
        } else if (options.length == 0){
            this.url = base_url + "function=BBANDS" + "&symbol=" + symbol + "&interval=" + interval
                    + "&series_type=" + series_type + "&apikey=" + apikey + "&time_options=" + time_options +
                    "&nbdevup=" + nbdevup +  "&nbdevdn=" + nbdevdn +
                    "&matype=" + matype;
        } else  if (options.length > 3){
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + options.length + " arguments to the BBANDS API call and it needs eight.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        } else {
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + options.length + " arguments to the BBANDS API call and it needs eight.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        }
    }
    public static void main(String[] args) {
        BBANDS BBANDSDaily = new BBANDS("MSFT", "5min", 60,"close","BKWGHZ46RDAVZQOK",   27, null, null);
        System.out.println(BBANDSDaily.url);
        BBANDSDaily.get_request(BBANDSDaily.url, 2000);
        BBANDSDaily.write_file("BBANDSDaily.json");
        BBANDSDaily.write_csv(BBANDSDaily.url, "BBANDSDaily", 1000);
    }
}
