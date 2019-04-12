package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class MFI extends apiConnector {

    private String url;

    /**
     * Class to connect to the MFI (Money Flow Index values)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period number of data points used to calculate each MFI value
     * @param apikey      Personal API key.
     */
    public MFI(String symbol, String interval, int time_period, String apikey) {
        //defaults set by Alpha Vantage API
        this.url = base_url + "function=MFI" + "&symbol=" + symbol + "&interval=" + interval
                + "&apikey=" + apikey + "&time_period=" + time_period;
    }
    public static void main(String[] args) {
        MFI MFIDaily = new MFI("MSFT", "5min", 60,"BKWGHZ46RDAVZQOK");
        System.out.println(MFIDaily.url);
        MFIDaily.get_request(MFIDaily.url, 2000);
        MFIDaily.write_file("MFIDaily.json");
        MFIDaily.write_csv(MFIDaily.url, "MFIDaily", 1000);
    }
}
