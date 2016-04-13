package GetJsonData;

import Questions.Clue;

import java.io.IOException;
import java.util.ArrayList;


public class RandomQuestionsRepository extends GetJSONData {
    public static final String COUNT_PARAM = "count=";

    public RandomQuestionsRepository() {
        super("http://jservice.io/api/random");
    }


    //    limited to 100
    private void setCountParameter(int count) {
        addParameterQuery(RandomQuestionsRepository.COUNT_PARAM, Integer.toString(count));
    }


    public void requestRandomClueFromWeb() throws IOException {
        requestJsonFromWeb();
    }

    //    Assumes count was set
    public void requestMultipleRandomCluesFromWeb(int count) throws IOException {
        setCountParameter(count);
        requestJsonFromWebWithParamQueries(getParametersMap().keySet());
    }

    public Clue getRandomClueObject() throws IOException {
        requestRandomClueFromWeb();
        Clue[] clues = gson.fromJson(getLastJsonResponse(), Clue[].class);
        return clues[0];
    }

    public Clue[] getManyRandomClueObjects(int howManyCluesToGet) throws IOException {
        requestMultipleRandomCluesFromWeb(howManyCluesToGet);
        Clue[] clues = gson.fromJson(getLastJsonResponse(), Clue[].class);
        return clues;
    }

    public ArrayList<Clue> getRandCluesWithMoreThan_n_CluesInCat(int howManyCluesToGet, int howManyCluesInCat) throws IOException {
        ArrayList<Clue> cluesList = new ArrayList<>();

        int i = 0;
        while (i < howManyCluesToGet) {
            Clue[] randomClues = getManyRandomClueObjects(10);

            int cluesWeGot = 0;
            while (cluesWeGot < randomClues.length && i < howManyCluesToGet) {
                if (randomClues[cluesWeGot].getCategory().getCluesCount() >= howManyCluesInCat) {
                    cluesList.add(randomClues[cluesWeGot]);
                    i++;
                }
                cluesWeGot++;
            }
        }
        return cluesList;
    }

    public Clue getRandomClueThatHasMoreThan_n_CluesInCat(int howManyCluesInCat) throws IOException {
        return getRandCluesWithMoreThan_n_CluesInCat(1, howManyCluesInCat).get(0);
    }

}
