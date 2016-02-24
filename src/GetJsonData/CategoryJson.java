package GetJsonData;

import Questions.Category;

import java.io.IOException;


public class CategoryJson extends GetJSONData{
    public CategoryJson() {
        super("http://jservice.io/api/category");
    }
    String idQuery = "id";

    private void setCategoryId(int id) {
        addParameterQuery(idQuery, id);
    }
    public void getCategoryFromWeb (int id) throws IOException {
        setCategoryId(id);
        getJsonFromWebWithQueries(parameters.keySet());
    }

    public Category getCategory(int id) throws IOException {
        getCategoryFromWeb(id);
        Category category = gson.fromJson(getLastJsonResponse(), Category.class);
        return category;
    }
}
