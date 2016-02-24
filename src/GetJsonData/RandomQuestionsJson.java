package GetJsonData;

import Questions.Clue;

import java.io.IOException;


public class RandomQuestionsJson extends GetJSONData {
    String countQuery = "count";

    public RandomQuestionsJson() {
        super("http://jservice.io/api/random");
    }


    //    limited to 100
    private void setCountParameter(int count) {
        addParameterQuery(countQuery, count);
    }


    public void getOneRandomClueFromWeb() throws IOException {
        getJsonFromWeb();
    }

    //    Assumes count was set
    public void getJsonForMultipleRandomClue(int count) throws IOException {
        setCountParameter(count);
        getJsonFromWebWithQueries(parameters.keySet());
    }

    public Clue getRandomClueBasedOnLastRequest() throws IOException {
        getOneRandomClueFromWeb();
        Clue[] clues = gson.fromJson(getLastJsonResponse(), Clue[].class);
        return clues[0];
    }

}
