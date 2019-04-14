package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class ADOSC extends apiConnector {

    private String url;

    /**
     * This class pulls from the Chaikin A/D Oscillator Technical Indicator
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param apikey      Personal API key
     * @param period      Takes two arguments the first for the fastperiod of the fast EMA and
     *                    slowperiod for the time period of the slow EMA. Only takes positive integers
     *                    pass null to set it to API defaults.
     */
    public ADOSC(String symbol, String interval, String apikey, Integer... period) {
        int fastperiod = 3;
        int slowperiod = 10;

        if (period.length == 2) {
            if (period[0] != null) {
                fastperiod = period[0];
            }
            if (period[1] != null) {
                slowperiod = period[1];
            }
            this.url = base_url + "function=ADOSC" + "&symbol=" + symbol + "&interval=" + interval
                    + "&apikey=" + apikey + "&fastperiod=" + fastperiod + "&slowperiod=" + slowperiod;
        } else if (period.length == 0) {
            this.url = base_url + "function=ADOSC" + "&symbol=" + symbol + "&interval=" + interval
                    + "&apikey=" + apikey + "&fastperiod=" + fastperiod + "&slowperiod=" + slowperiod;
        } else if (period.length > 3) {
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + (period.length + 3) +
                    " arguments to the ADOSC API call and it needs five.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        } else {
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + (period.length + 3) +
                    " arguments to the ADOSC API call and it needs five.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        }
    }
    public static void main(String[] args) {
        ADOSC ADOSCDaily = new ADOSC("MSFT", "5min", "BKWGHZ46RDAVZQOK", 5, null);
        System.out.println(ADOSCDaily.url);
        ADOSCDaily.get_request(ADOSCDaily.url, 2000);
        ADOSCDaily.write_file("ADOSCDaily.json");
        ADOSCDaily.write_csv(ADOSCDaily.url, "ADOSCDaily", 1000);
    }

}
