package jAvantage.technicalIndicators;

import jAvantage.apiConnector;

public class SECTOR extends apiConnector {

    private String url;

    /**
     * Returns the realtime and historical sector performances calculated from
     * S&P 500 incumbents
     * @param apikey      Personal API key.
     */
    public SECTOR(String apikey) {
        this.url = base_url + "function=SECTOR" + "&apikey=" + apikey;
    }
    public static void main(String[] args) {
        SECTOR SECTORDaily = new SECTOR("BKWGHZ46RDAVZQOK");
        System.out.println(SECTORDaily.url);
        SECTORDaily.get_request(SECTORDaily.url, 2000);
        SECTORDaily.write_file("SECTORDaily.json");
        SECTORDaily.write_csv(SECTORDaily.url, "SECTORDaily", 1000);
    }
}

