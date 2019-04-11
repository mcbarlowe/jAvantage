package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

import java.sql.Array;

public class PPO extends apiConnector {

    private String url;

    /**
     * Class to connect to the PPO (Percentage Price Oscillator)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period number of data points used to calculate each PPO value
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     * @param period      Optional period for PPO api call in the order of fastperiod,
     *                    slowdperiod, matype.
     */
    public PPO(String symbol, String interval, int time_period, String series_type, String apikey, Integer... period) {
        //defaults set by Alpha Vantage API
        int fastperiod = 5;
        int slowperiod = 3;
        int fastdmatype = 0;
        if (period.length == 5) {
            if (period[0] != null) {
                fastperiod = period[0];
            }
            if (period[2] != null) {
                slowperiod = period[2];
            }
            if (period[4] != null) {
                fastdmatype = period[4];
            }
            this.url = base_url + "function=PPO" + "&symbol=" + symbol + "&interval=" + interval
                    + "&series_type=" + series_type + "&apikey=" + apikey + "&time_period=" + time_period +
                    "&fastperiod=" + fastperiod +  "&slowperiod=" + slowperiod +
                    "&fastdmatype=" + fastdmatype;
        } else if (period.length == 0){
            this.url = base_url + "function=PPO" + "&symbol=" + symbol + "&interval=" + interval
                    + "&series_type=" + series_type + "&apikey=" + apikey + "&time_period=" + time_period +
                    "&fastperiod=" + fastperiod +  "&slowperiod=" + slowperiod +
                    "&fastdmatype=" + fastdmatype;
        } else  if (period.length > 3){
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + period.length + " arguments to the PPO API call and it needs seven.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        } else {
            throw new ArrayIndexOutOfBoundsException("\nYou passed " + period.length + " arguments to the PPO API call and it needs seven.\n" +
                    "If you want default values remember to pass null to the option you want to have default");
        }
    }
    public static void main(String[] args) {
        PPO PPODaily = new PPO("MSFT", "5min", 60,"close","BKWGHZ46RDAVZQOK", 5, null, 27, null, null);
        System.out.println(PPODaily.url);
        PPODaily.get_request(PPODaily.url, 2000);
        PPODaily.write_file("PPODaily.json");
        PPODaily.write_csv(PPODaily.url, "PPODaily", 1000);
    }
}
