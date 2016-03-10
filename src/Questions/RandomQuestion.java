package Questions;

import GetJsonData.CategoryJson;

import java.io.IOException;
import java.util.ArrayList;


public class RandomQuestion extends Question {

    private final CategoryJson categoryJson = new CategoryJson();

    public RandomQuestion(Clue clue) throws IOException {
        super(clue);

        setAnswerMultipleChoice((ArrayList<Clue>) categoryJson.getCategory(getCLUE().getCategoryId()).getClues());
    }


}