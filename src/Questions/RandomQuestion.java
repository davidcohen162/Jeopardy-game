package Questions;

import GetJsonData.CategoryRepository;

import java.io.IOException;
import java.util.ArrayList;


public class RandomQuestion extends Question {

    public RandomQuestion(Clue clue) throws IOException {
        super(clue);

        CategoryRepository categoryRepository = new CategoryRepository();
        setAnswerMultipleChoice((ArrayList<Clue>) categoryRepository
                .getCategory(Integer.toString(getCLUE().getCategoryId())).getClues());
    }

}