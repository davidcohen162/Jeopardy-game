package GetJsonData;

import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;


public class GetJSONData {


//    The base url of the api, in this case http://jservice.io/api/
    private String urlString;
    //Add query parameters here, as needed.
    private HashMap<String, Integer> parameters;
    private String jsonResponse;

    public GetJSONData(String urlString) {
        this.urlString = urlString;
    }

    public String getUrlString() {
        return urlString;
    }

    public void setUrl(String urlString) {
        this.urlString = urlString;
    }


    public void getJsonFromWeb () throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(this.urlString)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        } else {
            this.jsonResponse = response.body().string();
        }
    }

    public void addParameterQuery (String queryName, int value) {
        parameters.put(queryName, value);
    }


    public String getJsonResponse() {
        return this.jsonResponse;
    }

}
