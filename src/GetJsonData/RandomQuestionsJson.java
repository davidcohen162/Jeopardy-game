package GetJsonData;

import Questions.Clue;

import java.io.IOException;


public class RandomQuestionsJson extends GetJSONData {
    public static final String countQuery = "count";

    public RandomQuestionsJson() {
        super("http://jservice.io/api/random");
    }


    //    limited to 100
    private void setCountParameter(int count) {
        addParameterQuery(RandomQuestionsJson.countQuery, Integer.toString(count));
    }


    public void requestRandomClueJsonFromWeb() throws IOException {
        requestJsonFromWeb();
    }

    //    Assumes count was set
    public void requestMultipleRandomCluesJson(int count) throws IOException {
        setCountParameter(count);
        requestJsonFromWebWithQueries(getParameters().keySet());
    }

    public Clue getRandomClueBasedOnLastRequest() throws IOException {
        requestRandomClueJsonFromWeb();
        Clue[] clues = gson.fromJson(getLastJsonResponse(), Clue[].class);
        return clues[0];
    }

    public Clue[] getManyRandomClueObjects(int amount) throws IOException {
        requestMultipleRandomCluesJson(amount);
        Clue[] clues = gson.fromJson(getLastJsonResponse(), Clue[].class);
        return clues;
    }
}
