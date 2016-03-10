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

    public GameInRandomCategory(int amountOfQuestions) throws IOException {
        super(amountOfQuestions);
//        setUpQuestions();
    }

    public void setUpQuestions() throws IOException {
        CategoryJson json = new CategoryJson();
        List<Question> questionList = new ArrayList<>(getAmountOfQuestionsInGame());
        Clue c;
        Category category = json.getCategory(getValidCategories(1).get(0).getId());

        for (int i = 0; i < getAmountOfQuestionsInGame(); i++) {
            c = category.getClues().get(rand.nextInt(category.getClues().size()));
            questionList.add(new Question((c), (ArrayList<Clue>) category.getClues()));
            category.getClues().remove(c);
        }
        setQuestionsList(questionList);
    }

    public ArrayList<Category> getValidCategories(int amountOfCategoriesToGet) throws IOException {
        CategoriesJson catJson = new CategoriesJson();
        ArrayList<Category> catArrayListWithEnoughClues = new ArrayList<>(amountOfCategoriesToGet);
        int amountOfCategoriesInOneRequest = 25;

        int j = 0;
        while (j < amountOfCategoriesToGet) {
            Category[] randomCategories = catJson.getArrayOfRandomCategories(amountOfCategoriesInOneRequest);

            int i = 0;
            while (i < randomCategories.length && j < amountOfCategoriesToGet) {
                if (randomCategories[i].getCluesCount() >= getMinAmountOfCluesInCategory()) {
                    catArrayListWithEnoughClues.add(randomCategories[i]);
                    j++;
                }
                i++;
            }
        }
        return catArrayListWithEnoughClues;
    }

}

