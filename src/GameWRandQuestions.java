import GetJsonData.RandomQuestionsJson;
import Questions.Clue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameWRandQuestions extends Game {


    public GameWRandQuestions(int amountOfCluesInCategory) throws IOException {
        super(amountOfCluesInCategory);
        setUpQuestions();
    }

    public void setUpQuestions() throws IOException {
        List<Question> questionList = new ArrayList<>();
        RandomQuestionsJson randomQuestionsJson = new RandomQuestionsJson();
        Clue[] clues;

        int i = 0;
        while (i < getAmountOfQuestions()) {
            clues = randomQuestionsJson.getManyRandomClueObjects(10);

            for (Clue c : clues) {
                if (c.getCategory().getCluesCount() > getAmountOfCluesInCategory()) {
                    questionList.add(new RandomQuestion(clues[i]));
                    i++;
                }
            }
        }
        setGameQuestions(new GameQuestions(questionList));
    }


}
