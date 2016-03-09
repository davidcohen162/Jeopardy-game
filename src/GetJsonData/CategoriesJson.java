package GetJsonData;


import Questions.Category;

import java.io.IOException;

public class CategoriesJson extends GetJSONData {

    public static final int MAX_OFFSET = 18416;
    //    The maximum categories you can request in one request.
    public static final int MAX_CATEGORIES_REQUEST = 100;
    //      countQuery: an optional parameter to request more than 1 category at a time. Currently limited to 100
    private static final String countQuery = "count";
    //    By default the request will always return the same categories starting from x. Setting the Offset will return
//    categories starting from the offset number.
    private static final String offsetQuery = "offset";


    public CategoriesJson() {
        super("http://jservice.io/api/categories");
    }

    public int getCountAmount() {
        try {
            return Integer.parseInt(getQueryValue(CategoriesJson.countQuery));
        } catch (RuntimeException e) {
            return -1;
        }
    }

    private void setCountAmount(int count) {
        addParameterQuery(CategoriesJson.countQuery, Integer.toString(count));
    }

    public int getOffsetAmount() {
        try {
            return Integer.parseInt(getQueryValue(CategoriesJson.offsetQuery));
        } catch (RuntimeException e) {
            return -1;
        }
    }

    private void setOffsetAmount(int offsetAmount) {
        addParameterQuery(CategoriesJson.offsetQuery, Integer.toString(offsetAmount));
    }

    public void requestCategoriesJsonFromWeb(int count, int offSet) throws IOException {
        setCountAmount(count);
        setOffsetAmount(offSet);

        requestJsonFromWebWithQueries(getParametersMap().keySet());
    }

    public Category[] getArrayOfCategories(int count, int offSet) throws IOException {
        requestCategoriesJsonFromWeb(count, offSet);
        Category[] categories = gson.fromJson(getLastJsonResponse(), Category[].class);
        return categories;
    }
}
