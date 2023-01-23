package DataFetching;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GetData implements GetDataProxy {

    private String urlString;

    public Reply getData(APICall request) throws ThrowException {
        this.urlString =
                String.format(
                        "http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json",
                        request.getCountry(), request.getIndicatorID(),
                        request.getYearFrom(), request.getYearTo()
                );
        Reply r = new Reply(this.callAPI());
        return r;
    }

    private String callAPI() throws ThrowException {
        try {
            URL url = new URL(this.urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            String inline = "";
            if (responseCode == 200) {
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }
                sc.close();
            }
            return inline;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new ThrowException("API call failed");
    }

    public class ThrowException extends Exception {
        public ThrowException(String message) {
            super(message);
        }
    }
}