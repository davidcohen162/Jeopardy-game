package Game;

import GetJsonData.CategoriesJson;
import GetJsonData.CategoryJson;
import Questions.Category;
import Questions.Clue;
import Questions.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameInRandomCategory extends Game {
    private Random rand = new Random();

    public GameInRandomCategory(int amountOfQuestions, int amountOfCluesInCategory) throws IOException {
        super(amountOfQuestions, amountOfCluesInCategory);
//        setUpQuestions();
    }

    public void setUpQuestions() throws IOException {
        CategoryJson json = new CategoryJson();
        List<Question> questionList = new ArrayList<>(getAmountOfQuestions());
        Clue c;
        Category category = json.getCategory(getValidCategories(1).get(0).getId());

        for (int i = 0; i < getAmountOfQuestions(); i++) {
            c = category.getClues().get(rand.nextInt(category.getClues().size()));
            questionList.add(new Question((c), (ArrayList<Clue>) category.getClues()));
            category.getClues().remove(c);
        }

        setGameQuestions(new GameQuestions(questionList));
    }

    public ArrayList<Category> getValidCategories(int amountOfCategoriesToGet) throws IOException {
        CategoriesJson catJson = new CategoriesJson();
        Category[] notValidatedCategories;
        ArrayList<Category> catArrayListWithEnoughQuestions = new ArrayList<>(amountOfCategoriesToGet);
        int amountOfCategoriesInOneRequest = 25;

        int j = 0, offset;
        while (j < amountOfCategoriesToGet) {
            offset = rand.nextInt(CategoriesJson.MAX_OFFSET - amountOfCategoriesInOneRequest);
            notValidatedCategories = catJson.getArrayOfCategories(amountOfCategoriesInOneRequest, offset);

            int i = 0;
            while (i < notValidatedCategories.length && j < amountOfCategoriesToGet) {
                if (notValidatedCategories[i].getCluesCount() >= getAmountOfCluesInCategory()) {
                    catArrayListWithEnoughQuestions.add(notValidatedCategories[i]);
                    j++;
                }
                i++;
            }
        }

        return catArrayListWithEnoughQuestions;
    }

}

