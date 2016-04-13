package GetJsonData;

import Questions.Category;

import java.io.IOException;
import java.util.ArrayList;


public class CategoryRepository extends GetJSONData {

    public static final String idQuery = "id=";

    public CategoryRepository() {
        super("http://jservice.io/api/category");
    }

    private void setCategoryId(String id) {
        addParameterQuery(idQuery, id);
    }

    public void requestCategoryJsonFromWeb(String id) throws IOException {
        setCategoryId(id);
        requestJsonFromWebWithParamQueries(getParametersMap().keySet());
    }

    public Category getCategory(String id) throws IOException {
        requestCategoryJsonFromWeb(id);
        Category category = gson.fromJson(getLastJsonResponse(), Category.class);

        return category;
    }

    public Category getRandomCatWith_n_Clues(int amountOfClues) throws IOException {
        CategoriesRepository categoriesRepository = new CategoriesRepository();
        Category cat = categoriesRepository.getArrayListOfCatsWithMoreThan_n_Clues(1, amountOfClues).get(0);

        return getCategory(Integer.toString(cat.getId()));
    }

    public ArrayList<Category> getRandomCatsWith_n_Clues(int amountOfClues, int amountOfCategories) throws IOException {
        ArrayList<Category> categories = new ArrayList<>(amountOfCategories);

        for (int i = 0; i < amountOfCategories; i++) {
            categories.add(getRandomCatWith_n_Clues(amountOfClues));
        }

        return categories;
    }
}
