package Game;

import GetJsonData.CategoryRepository;
import Questions.Category;

import java.io.IOException;
import java.util.Random;


public class GameInRandomCategory extends Game {
    private Random rand = new Random();

    public GameInRandomCategory(int amountOfQuestions) throws IOException {
        super(amountOfQuestions);
//        setUpQuestions();
    }

    public void setUpQuestions() throws IOException {
        CategoryRepository catJson = new CategoryRepository();
        Category category = catJson.getRandomCatWith_n_Clues(getMinAmountOfCluesInCategory());

        super.setUpQuestions(category.getClues());
    }

}

