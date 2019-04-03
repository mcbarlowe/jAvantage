import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


class ApiConnector {
    static final String base_url = "https://www.alphavantage.co/query?";

    /**
     * Method reads in the data from the Alpha Vantage API
     * @param url This is the API url to access the data
     * @param timeout An int that specifies timeout in milliseconds
     * @return inputStream an InputStream object that can be written to file
     *                               or inserted into a SQL database
     */
    InputStream get_request(String url, int timeout) {
        InputStream inputStream;
        try {
            URL request = new URL(url);
            URLConnection conn = request.openConnection();
            conn.setConnectTimeout(timeout);
            conn.setReadTimeout(timeout);
            inputStream = conn.getInputStream();

            //inputStream = new InputStreamReader(request.openStream(), StandardCharsets.UTF_8);
            //BufferedReader bufferedReader = new BufferedReader(inputStream);
            //StringBuilder responseBuilder = new StringBuilder();
            //responseBuilder.append(bufferedReader.readLine());

            return inputStream;
        } catch (IOException e) {
            throw new RuntimeException("Error pulling data from Alpha Vantage", e);
        }
    }

    /**
     * Method takes InputStream object and writes it to fileName
     * @param inputStream InputStream object returned from the Alpha Vantage API.
     * @param fileName    name of file to write InputStream object to.
     */
    void write_file (InputStream inputStream, String fileName){

        int c;
        try {
            while ((c = inputStream.read()) != -1) {
                System.out.print((char) c);
            }
            Files.copy(request.openStream(), Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e) {
            throw new RuntimeException("Error writing Data from Alpha Vantage to file " + fileName, e);
        }
    }
