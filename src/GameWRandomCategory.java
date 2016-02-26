import GetJsonData.CategoriesJson;
import Questions.Category;
import Questions.Clue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameWRandomCategory extends Game {

    private final int numberOfCategories = 25;

    public GameWRandomCategory(int amountOfCluesInCategory) {
        super(amountOfCluesInCategory);
    }

    public void setUpQuestions() throws IOException {
        CategoriesJson catJson = new CategoriesJson();
        Category[] categories;
        Random rand = new Random();
        List<Question> questionList = new ArrayList<>(getAmountOfQuestions());

        int offset;
        boolean foundValidCategory = false;
        while (!foundValidCategory) {

            offset = rand.nextInt(CategoriesJson.MAX_OFFSET - 25);
            categories = catJson.getArrayOfCategories(25, offset);

            int i = 0;
            while (i < categories.length && !foundValidCategory) {
                if (categories[i].getCluesCount() > getAmountOfCluesInCategory()) {
                    foundValidCategory = true;

                    for (int j = 0; j < getAmountOfQuestions(); j++) {
                        questionList.add(new Question(categories[i].getClues().get(rand.nextInt(categories[i].getClues().size())), (ArrayList<Clue>) categories[i].getClues()));
                    }
                }
            }
        }
        setGameQuestions(new GameQuestions(questionList));
    }


}
