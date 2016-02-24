package GetJsonData;

import java.io.IOException;


public class RandomQuestionsJson extends GetJSONData{
    String countQuery = "count";

    public RandomQuestionsJson() {
        super("http://jservice.io/api/random?");
    }


//    limited to 100
    public void setCountParameter(int count) {
        addParameterQuery(countQuery, count);
    }

    public void getOneRandomClueFromWeb() throws IOException {
        getJsonFromWeb();
    }

//    Assumes count was set
    public void getRandomCluesWithCount() throws IOException {
        getJsonFromWebWithQueries(parameters.keySet());
    }
}
