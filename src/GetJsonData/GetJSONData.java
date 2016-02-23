package GetJsonData;

import okhttp3.*;

import java.io.IOException;


public class GetJSONData {


    private String urlString;
    //Add query parameters in subclasses here.
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



    public String getJsonResponse() {
        return this.jsonResponse;
    }

}
