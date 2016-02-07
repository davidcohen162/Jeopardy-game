package GetJsonData;

import java.io.IOException;
import java.net.MalformedURLException;


public class RandomQuestionsJson extends GetJSONData{

    int count;
    public RandomQuestionsJson() throws MalformedURLException {
        super("http://jservice.io/api/random");
    }


    public int getCount() {
        return count;
    }

//    limited to 100
    public void setCount(int count) {
        this.count = count;
    }

    public String getRandomClueWithCount() throws IOException {
        setUrl(getUrlString() + "?count=" + count);
        return getGsonResponse();
    }
}
