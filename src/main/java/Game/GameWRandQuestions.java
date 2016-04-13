package Game;

import GetJsonData.RandomQuestionsRepository;
import Questions.Clue;
import Questions.Question;
import Questions.RandomQuestion;

import java.io.IOException;
import java.util.ArrayList;

public class GameWRandQuestions extends Game {


    public GameWRandQuestions(int amountOfQuestions, int amountOfCluesInCategory) throws IOException {
        super(amountOfQuestions, amountOfCluesInCategory);
//        setUpQuestions();
    }

    public void setUpQuestions() throws IOException {
        ArrayList<Question> questionList = new ArrayList<>();
        RandomQuestionsRepository json = new RandomQuestionsRepository();
        ArrayList<Clue> clues = json.getRandCluesWithMoreThan_n_CluesInCat(getAmountOfQuestionsInGame(), getMinAmountOfCluesInCategory());
        for (Clue c : clues) {
            questionList.add(new RandomQuestion(c));
        }
        setQuestionsList(questionList);
    }


}
