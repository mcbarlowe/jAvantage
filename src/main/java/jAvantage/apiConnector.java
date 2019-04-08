package jAvantage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class apiConnector {
    public static final String base_url = "https://www.alphavantage.co/query?";
    private InputStream inputStream;

    /**
     * Method reads in the data from the Alpha Vantage API and stores it in an
     * InputStream class variable called inputStream
     *
     * @param url     This is the API url to access the data
     * @param timeout An int that specifies timeout in milliseconds
     */
    public void get_request(String url, int timeout) {
        try {
            URL request = new URL(url);
            URLConnection conn = request.openConnection();
            conn.setConnectTimeout(timeout);
            conn.setReadTimeout(timeout);
            //inputStream = new InputStreamReader(request.openStream(), StandardCharsets.UTF_8);
            //BufferedReader bufferedReader = new BufferedReader(inputStream);
            //StringBuilder responseBuilder = new StringBuilder();
            //responseBuilder.append(bufferedReader.readLine());
            this.inputStream = conn.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException("Error pulling data from Alpha Vantage", e);
        }
    }


    /**
     * Method takes inputStream class variable and writes it to fileName
     * will overwrite file if a file with the same name exists in folder
     *
     * @param fileName name of file to write InputStream object to.
     */
    public void write_file(String fileName) {
        try {
            Files.copy(this.inputStream, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Error writing Data from Alpha Vantage to file " + fileName, e);
        }
    }
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}



