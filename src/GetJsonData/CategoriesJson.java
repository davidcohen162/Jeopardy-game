package GetJsonData;


import Questions.Category;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class CategoriesJson extends GetJSONData {

    public static final int MAX_OFFSET = 18416;
    //    The maximum categories you can request in one request.
    public static final int MAX_CATEGORIES_REQUEST = 100;
    //      countQuery: an optional parameter to request more than 1 category at a time. Currently limited to 100
    private static final String countQuery = "count";
    //    By default the request will always return the same categories starting from x. Setting the Offset will return
//    categories starting from the offset number.
    private static final String offsetQuery = "offset";
    private Random rand = new Random();

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

    public Category[] getArrayOfRandomCats(int amountOfCategoriesToGet) throws IOException {
        return getArrayOfCategories(amountOfCategoriesToGet, rand.nextInt(MAX_OFFSET - amountOfCategoriesToGet));
    }

    public ArrayList<Category> getArrayListOfCatsWithMoreThan_n_Clues(int amountOfCatsToGet, int amountOfClues) throws IOException {
        ArrayList<Category> cats = new ArrayList<>(amountOfCatsToGet);

//        Main loop will continue as long as we dont have the amount of categories that was requested.
        int amountOfCatsWeGot = 0;
        while (amountOfCatsWeGot < amountOfCatsToGet) {
            Category[] randomCategories = getArrayOfRandomCats(25);

/*          This loop iterates through the array the latest request we made for Categories.
            The loop will end when we get to the end of the array. It will then restart the main loop, which checks
            if we have enough Categories. The loop can also end if while iterating through the current batch of Categories
            we find that we have enough categories.
            */
            int i = 0;
            while (i < randomCategories.length && amountOfCatsWeGot < amountOfCatsToGet) {
                if (randomCategories[i].getCluesCount() >= amountOfClues) {
                    cats.add(randomCategories[i]);
                    amountOfCatsWeGot++;
                }
                i++;
            }
        }
        return cats;
    }

}
