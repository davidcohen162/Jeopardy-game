package Questions;

import GetJsonData.CategoryRepository;

import java.io.IOException;
import java.util.ArrayList;


public class RandomQuestion extends Question {

    private final CategoryRepository categoryRepository = new CategoryRepository();

    public RandomQuestion(Clue clue) throws IOException {
        super(clue);

        setAnswerMultipleChoice((ArrayList<Clue>) categoryRepository.getCategory(Integer.toString(getCLUE().getCategoryId())).getClues());
    }

}