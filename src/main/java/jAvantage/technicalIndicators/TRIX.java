package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class TRIX extends apiConnector {

    private String url;

    /**
     * Class to connect to the TRIX the one day rate of change of a triple smooth exponential moving average
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period number of data points used to calculate each TRIX value
     * @param series_type Desired price type in the time series.
     * @param apikey      Personal API key.
     */
    public TRIX(String symbol, String interval, int time_period, String series_type, String apikey) {
        //defaults set by Alpha Vantage API
        this.url = base_url + "function=TRIX" + "&symbol=" + symbol + "&interval=" + interval
                + "&series_type=" + series_type + "&apikey=" + apikey + "&time_period=" + time_period;
    }
    public static void main(String[] args) {
        TRIX TRIXDaily = new TRIX("MSFT", "5min", 60,"close","BKWGHZ46RDAVZQOK");
        System.out.println(TRIXDaily.url);
        TRIXDaily.get_request(TRIXDaily.url, 2000);
        TRIXDaily.write_file("TRIXDaily.json");
        TRIXDaily.write_csv(TRIXDaily.url, "TRIXDaily", 1000);
    }
}
