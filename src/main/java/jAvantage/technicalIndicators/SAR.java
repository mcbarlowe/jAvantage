package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

import java.sql.Array;

public class SAR extends apiConnector {

    private String url;

    /**
     * Class to connect to the SAR (Percentage Price Oscillator)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param apikey      Personal API key.
     * @param options     This includes an acceleration factor and the accelerator
     *                    maximum value. Only positive floats accepted for each option.
     */
    public SAR(String symbol, String interval, String apikey, Double... options) {
        //defaults set by Alpha Vantage API
        double acceleration = .01;
        double maximum = .20;
        if (options.length == 2) {
            if (options[0] != null) {
                acceleration = options[0];
            }
            if (options[1] != null) {
                maximum = options[1];
            }
            this.url = base_url + "function=SAR" + "&symbol=" + symbol + "&interval=" + interval
                    + "&acceleration=" + acceleration + "&maximum=" + maximum +
                    "&apikey=" + apikey;
        } else if (options.length == 0){
            this.url = base_url + "function=SAR" + "&symbol=" + symbol + "&interval=" + interval
                    + "&acceleration=" + acceleration + "&maximum=" + maximum +
                    "&apikey=" + apikey;
        } else  if (options.length > 3){
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + (options.length + 3) + " arguments to the SAR API call and it needs five.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        } else {
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + (options.length + 3) + " arguments to the SAR API call and it needs five.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        }
    }
    public static void main(String[] args) {
        SAR SARDaily = new SAR("MSFT", "5min", "BKWGHZ46RDAVZQOK",  null, null);
        System.out.println(SARDaily.url);
        SARDaily.get_request(SARDaily.url, 2000);
        SARDaily.write_file("SARDaily.json");
        SARDaily.write_csv(SARDaily.url, "SARDaily", 1000);
    }
}
