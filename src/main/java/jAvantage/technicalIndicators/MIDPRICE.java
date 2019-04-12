package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class MIDPRICE extends apiConnector {

    private String url;

    /**
     * Class to connect to the MIDPRICE (MIDPRICE = (highest high + lowest low)/2)
     * @param symbol      Name of the security.
     * @param interval    Time interval between two consecutive data points in the time series.
     * @param time_period number of data points used to calculate each MIDPRICE value
     * @param apikey      Personal API key.
     */
    public MIDPRICE(String symbol, String interval, int time_period, String apikey) {
        //defaults set by Alpha Vantage API
        this.url = base_url + "function=MIDPRICE" + "&symbol=" + symbol + "&interval=" + interval
                +  "&apikey=" + apikey + "&time_period=" + time_period;
    }
    public static void main(String[] args) {
        MIDPRICE MIDPRICEDaily = new MIDPRICE("MSFT", "5min", 60,"BKWGHZ46RDAVZQOK");
        System.out.println(MIDPRICEDaily.url);
        MIDPRICEDaily.get_request(MIDPRICEDaily.url, 2000);
        MIDPRICEDaily.write_file("MIDPRICEDaily.json");
        MIDPRICEDaily.write_csv(MIDPRICEDaily.url, "MIDPRICEDaily", 1000);
    }
}
