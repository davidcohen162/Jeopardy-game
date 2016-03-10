package Game;

import GetJsonData.CategoriesJson;
import GetJsonData.CategoryJson;
import Questions.Category;

import java.io.IOException;
import java.util.ArrayList;


public class ChooseACategory extends Game {

    private final ArrayList<Category> catsToChooseFrom;

    public ChooseACategory(int amountOfQuestions) throws IOException {
        super(amountOfQuestions);
        CategoriesJson catsJson = new CategoriesJson();
        catsToChooseFrom = catsJson.getArrayListOfCatsWithMoreThan_n_Clues(25, getMinAmountOfCluesInCategory());
    }

    public String getACategoryTitle(int index) {
        return catsToChooseFrom.get(index).getTitle();
    }

    public void setTheCategory(int index) throws IOException {
        CategoryJson catJson = new CategoryJson();
        Category cat = catJson.getCategory(catsToChooseFrom.get(index).getId());

        setUpQuestions(cat.getClues());
    }
}
