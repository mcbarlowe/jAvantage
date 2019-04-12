package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

import java.sql.Array;

public class ULTOSC extends apiConnector {

    private String url;

    /**
     * Class to connect to the ULTOSC (Percentage Price Oscillator)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param apikey      Personal API key.
     * @param period      Optional period for ULTOSC api call in the order of timeperiod1,
     *                    timeperiod2, timeperiod3. Have to be postive intergers greater than 0
     */
    public ULTOSC(String symbol, String interval, String apikey, Integer... period) {
        //defaults set by Alpha Vantage API
        int timeperiod1 = 7;
        int timeperiod2 = 14;
        int timeperiod3 = 28;
        if (period.length == 3) {
            if (period[0] != null) {
                timeperiod1 = period[0];
            }
            if (period[1] != null) {
                timeperiod2 = period[1];
            }
            if (period[2] != null) {
                timeperiod3 = period[2];
            }
            this.url = base_url + "function=ULTOSC" + "&symbol=" + symbol + "&interval=" + interval
                      + "&timeperiod1=" + timeperiod1 +  "&timeperiod2=" + timeperiod2 +
                    "&timeperiod3=" + timeperiod3+ "&apikey=" + apikey;
        } else if (period.length == 0){
            this.url = base_url + "function=ULTOSC" + "&symbol=" + symbol + "&interval=" + interval
                    + "&timeperiod1=" + timeperiod1 +  "&timeperiod2=" + timeperiod2 +
                    "&timeperiod3=" + timeperiod3+ "&apikey=" + apikey;
        } else  if (period.length > 3){
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + period.length + " arguments to the ULTOSC API call and it needs three.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        } else {
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + period.length + " arguments to the ULTOSC API call and it needs three.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        }
    }
    public static void main(String[] args) {
        ULTOSC ULTOSCDaily = new ULTOSC("MSFT", "5min", "BKWGHZ46RDAVZQOK",  null, null, null);
        System.out.println(ULTOSCDaily.url);
        ULTOSCDaily.get_request(ULTOSCDaily.url, 2000);
        ULTOSCDaily.write_file("ULTOSCDaily.json");
        ULTOSCDaily.write_csv(ULTOSCDaily.url, "ULTOSCDaily", 1000);
    }
}
