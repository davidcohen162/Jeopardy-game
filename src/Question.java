import GetJsonData.CategoryJson;
import GetJsonData.GetJSONData;
import GetJsonData.RandomQuestionsJson;
import Questions.Category;
import Questions.Clue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Question {
    protected CategoryJson categoryJson = new CategoryJson();

    protected final Clue CLUE;
    //    INCORRECT_ANSWER_CHOICES controls how many false answers choices there are in a question.
    private final int INCORRECT_ANSWER_CHOICES = 3;

    protected final ArrayList<String> ANSWER_STRING_ARRAY_LIST = new ArrayList<>(INCORRECT_ANSWER_CHOICES + 1);

    public Question(Category category) {
        CLUE = category.getRandomClue();

        setAnswers(category);
    }

    public Question(RandomQuestionsJson RandClueJson) throws IOException {
        CLUE = RandClueJson.getRandomClueBasedOnLastRequest();

        Category category;
        category = categoryJson.getCategory(CLUE.getCategoryId());
        setAnswers(category);
    }


    protected void setAnswers(Category category) {
        ANSWER_STRING_ARRAY_LIST.add(this.CLUE.getAnswer());
        Random random = new Random();

        ArrayList<Clue> clueArray = (ArrayList<Clue>) category.getClues();

        for (int i = 0; i < INCORRECT_ANSWER_CHOICES && i < clueArray.size(); i++) {
            ANSWER_STRING_ARRAY_LIST.add(clueArray.get(random.nextInt(clueArray.size())).getAnswer());
        }

        Collections.shuffle(ANSWER_STRING_ARRAY_LIST);
    }

    public boolean choiceIsCorrect(String choice) {
        return choice.equalsIgnoreCase(this.CLUE.getAnswer());
    }
}
