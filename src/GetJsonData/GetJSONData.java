package GetJsonData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class GetJSONData {


    private String urlString;
    //Add parameters in subclasses here.
    private URL urlObject;
    private HttpURLConnection httpURLConnection;
    private int responseCode;
    private String jsonResponse;

    public GetJSONData(String urlString) throws MalformedURLException{
        this.urlString = urlString;
        this.urlObject = new URL(this.urlString);
    }

    public String getUrlString() {
        return urlString;
    }

    public void setUrl(String urlString) throws MalformedURLException {
        this.urlString = urlString;
        this.urlObject = new URL(this.urlString);
    }



    public void setUrlObject(String urlString) throws MalformedURLException {
        this.urlObject = new URL(urlString);
    }

    public String getGsonResponse () throws IOException {


        StringBuilder response = new StringBuilder();
        if(statusOK()) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));


            while ((jsonResponse = in.readLine()) != null) {
                response.append(jsonResponse);
            }
            in.close();
        }
        return response.toString();
    }

    public boolean statusOK () throws IOException {

        this.httpURLConnection =(HttpURLConnection) this.urlObject.openConnection();

        responseCode = httpURLConnection.getResponseCode();

        if(responseCode != 200) {
            return false;
        } else {
            return true;
        }
    }
}
