import GetJsonData.CategoryJson;
import Questions.Clue;

import java.io.IOException;


public class RandomQuestion extends Question{

    protected CategoryJson categoryJson = new CategoryJson();

    public RandomQuestion(Clue clue) throws IOException {
        super(clue);

        setAnswers(categoryJson.getCategory(CLUE.getCategoryId()).getClues());
    }
}