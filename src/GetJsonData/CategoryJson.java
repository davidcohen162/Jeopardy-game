package GetJsonData;

import Questions.Category;

import java.io.IOException;


public class CategoryJson extends GetJSONData{

    public static final String idQuery = "id";

    public CategoryJson() {
        super("http://jservice.io/api/category");
    }

    private void setCategoryId(int id) {
        addParameterQuery(idQuery, Integer.toString(id));
    }

    public void requestCategoryJsonFromWeb(int id) throws IOException {
        setCategoryId(id);
        requestJsonFromWebWithQueries(getParametersMap().keySet());
    }

    public Category getCategory(int id) throws IOException {
        requestCategoryJsonFromWeb(id);
        Category category = gson.fromJson(getLastJsonResponse(), Category.class);
        return category;
    }

    public Category getRandomCatWith_n_Clues(int amountOfClues) throws IOException {
        CategoriesJson categoriesJson = new CategoriesJson();

        return categoriesJson.getArrayListOfCatsWithMoreThan_n_Clues(1, amountOfClues).get(0);
    }
}
