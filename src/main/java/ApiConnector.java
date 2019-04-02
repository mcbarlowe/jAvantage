import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


class ApiConnector {
    static final String base_url = "https://www.alphavantage.co/query?";

    //reads in the data from the API when based a valid api url string
    String get_request(String url, int timeout){
        try {
            int c;
            URL request = new URL(url);
            URLConnection conn = request.openConnection();
            conn.setConnectTimeout(timeout);
            conn.setReadTimeout(timeout);
            String file = "test.json";


            InputStreamReader inputStream = new InputStreamReader(request.openStream(), StandardCharsets.UTF_8);
            //BufferedReader bufferedReader = new BufferedReader(inputStream);
            //StringBuilder responseBuilder = new StringBuilder();
            //responseBuilder.append(bufferedReader.readLine());
            while((c=inputStream.read())!=-1)
            {
                System.out.print((char)c);
            }
            Files.copy(request.openStream(),Paths.get(file), StandardCopyOption.REPLACE_EXISTING);

            return null;
        }
        catch (IOException e) {
            throw new RuntimeException("Error pulling data from Alpha Vantage", e);
        }

    }
}
