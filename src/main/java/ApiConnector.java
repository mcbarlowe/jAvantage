import java.io.IOException;
import java.net.URLConnection;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;

class ApiConnector {
    static final String base_url = "https://www.alphavantage.co/query?";

    //reads in the data from the API when based a valid api url string
    String get_request(String url, int timeout){
        try {
            URL request = new URL(url);
            URLConnection conn = request.openConnection();
            conn.setConnectTimeout(timeout);
            conn.setReadTimeout(timeout);

            InputStreamReader inputStream = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStream);
            StringBuilder responseBuilder = new StringBuilder();

            while (bufferedReader.readLine() != null) {
                responseBuilder.append(bufferedReader.readLine());
            }
            bufferedReader.close();
            System.out.println(responseBuilder.toString());
            return responseBuilder.toString();
        }
        catch (IOException e) {
            throw new RuntimeException("Error pulling data from Alpha Vantage", e);
        }

    }
}
