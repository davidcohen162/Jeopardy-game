package GetJsonData;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class GetJSONData {

    //
    protected static Gson gson = new Gson();
    protected Response response;
    //    The base url of the api, in this case http://jservice.io/api/
    private String baseUrlString;
    //Add query parameters here, as needed.
    private HashMap<String, String> parameters;
    private OkHttpClient client = new OkHttpClient();
    private String jsonResponse;

    public GetJSONData(String urlString) {
        this.baseUrlString = urlString;
        parameters = new HashMap<>();
    }

    public String getBaseUrlString() {
        return baseUrlString;
    }

    public void setBaseUrlStringUrl(String urlString) {
        this.baseUrlString = urlString;
    }

//  This method gets json data from the web. It doesn't use any query parameters.
//    It uses the okhttp library for the web requests.
    public void requestJsonFromWeb() throws IOException {

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

//    Same as above but with queries. Accepts a set to limit which queries to use; you can just use the
//    Map.keyset as the set to use all queries.
public void requestJsonFromWebWithParamQueries(Set<String> keys) throws IOException {
        String parameters = "?";
        for (String key : keys) {
            if (this.parameters.containsKey(key)) {
                parameters += key + this.parameters.get(key) + "&";
            } else {
                throw new RuntimeException("Parameter not set.");
            }
        }
        Request request = new Request.Builder()
                .url(this.baseUrlString + parameters)
                .build();

    response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        } else {
            this.jsonResponse = response.body().string();
        }
    }

    public void addParameterQuery(String queryName, String value) {
        parameters.put(queryName, value);
    }

    public void removeQueryParameter(String queryName) {
        parameters.remove(queryName);
    }

    protected String getQueryValue(String queryKey) {
        if (parameters.containsKey(queryKey)) {
            return parameters.get(queryKey);
        } else {
            throw new RuntimeException("Key not found");
        }
    }

    public HashMap<String, String> getParametersMap() {
        return new HashMap<>(parameters);
    }

    public String getLastJsonResponse() {
        return this.jsonResponse;
    }

}
