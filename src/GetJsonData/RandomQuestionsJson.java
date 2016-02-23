package GetJsonData;

import java.io.IOException;


public class RandomQuestionsJson extends GetJSONData{

    int count;
    public RandomQuestionsJson() {
        super("http://jservice.io/api/random?");
    }


    public int getCount() {
        return count;
    }

//    limited to 100
    public void setCount(int count) {
        this.count = count;
    }

    public void getOneRandomCluesFromWeb() throws IOException {
        getJsonFromWeb();
    }

    public void getRandomCluesWithCount() throws IOException {
        setUrl(getUrlString() +  + count);
    }
}
