package Game;

import GetJsonData.CategoriesRepository;
import GetJsonData.CategoryRepository;
import Questions.Category;

import java.io.IOException;
import java.util.ArrayList;


public class ChooseACategory extends Game {

    private final ArrayList<Category> catsToChooseFrom;
    private Category categoryChosen;

    public ChooseACategory(int amountOfQuestions) throws IOException {
        super(amountOfQuestions);
        CategoriesRepository catsJson = new CategoriesRepository();
        catsToChooseFrom = catsJson.getArrayListOfCatsWithMoreThan_n_Clues(25, getMinAmountOfCluesInCategory());
    }

    public String getACategoryTitle(int index) {
        return catsToChooseFrom.get(index).getTitle();
    }

    public void setTheCategory(int index) throws IOException {
        CategoryRepository catJson = new CategoryRepository();
        categoryChosen = catJson.getCategory(Integer.toString(catsToChooseFrom.get(index).getId()));
        setUpQuestions();
    }

    private void setUpQuestions() {
        super.setUpQuestions(categoryChosen.getClues());
    }

}
