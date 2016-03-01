package Game;

import GetJsonData.CategoriesJson;
import Questions.Category;
import Questions.Clue;
import Questions.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameInRandomCategory extends Game {

    private final int numberOfCategories = 25;

    public GameInRandomCategory(int amountOfQuestions, int amountOfCluesInCategory) throws IOException {
        super(amountOfQuestions, amountOfCluesInCategory);
        setUpQuestions();
    }

    public void setUpQuestions() throws IOException {
        Random rand = new Random();
        List<Question> questionList = new ArrayList<>(getAmountOfQuestions());
        Category category = getValidCategories(1).get(0);

        for (int i = 0; i < getAmountOfQuestions(); i++) {
            questionList.add(new Question(category.getClues().get(rand.nextInt(category.getClues().size())), (ArrayList<Clue>) category.getClues()));
        }

        setGameQuestions(new GameQuestions(questionList));
    }

    public ArrayList<Category> getValidCategories(int amount) throws IOException {
        CategoriesJson catJson = new CategoriesJson();
        Category[] categories;
        ArrayList<Category> catArrayList = new ArrayList<>(amount);
        Random rand = new Random();

        int j = 0, offset;
        while (j < amount) {
            offset = rand.nextInt(CategoriesJson.MAX_OFFSET - 25);
            categories = catJson.getArrayOfCategories(25, offset);

            int i = 0;
            while (i < categories.length && j < amount) {
                if (categories[i].getCluesCount() > getAmountOfCluesInCategory()) {
                    catArrayList.add(categories[i]);
                    i++;
                    j++;
                }
            }
        }
        return catArrayList;
    }

}

