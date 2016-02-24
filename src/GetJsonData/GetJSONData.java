package GetJsonData;

import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class GetJSONData {


    //    The base url of the api, in this case http://jservice.io/api/
    private String baseUrlString;
    //Add query parameters here, as needed.
    protected HashMap<String, Integer> parameters;
    private static OkHttpClient client = new OkHttpClient();
    private String jsonResponse;

    public GetJSONData(String urlString) {
        this.baseUrlString = urlString;
        parameters = new HashMap<>();
    }

    public String getBaseUrlString() {
        return baseUrlString;
    }

    public void setUrl(String urlString) {
        this.baseUrlString = urlString;
    }


    public void getJsonFromWeb() throws IOException {

        Request request = new Request.Builder()
                .url(this.baseUrlString)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        } else {
            this.jsonResponse = response.body().string();
        }
    }

    public void getJsonFromWebWithQueries(Set<String> keys) throws IOException {
        String parameters = "?";
        for (String key : keys) {
            if (this.parameters.containsKey(key)) {
                parameters += key + "=" + this.parameters.get(key) + "&";
            } else {
                throw new RuntimeException("Parameter not set.");
            }
        }
        Request request = new Request.Builder()
                .url(this.baseUrlString + parameters)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        } else {
            this.jsonResponse = response.body().string();
        }
    }

    protected void addParameterQuery(String queryName, int value) {
        parameters.put(queryName, value);
    }

    protected void removeQueryParameter(String queryName) {
        parameters.remove(queryName);
    }


    public String getLastJsonResponse() {
        return this.jsonResponse;
    }

}
