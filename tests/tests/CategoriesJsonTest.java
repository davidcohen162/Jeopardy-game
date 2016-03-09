package tests;

import GetJsonData.CategoriesJson;
import Questions.Category;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CategoriesJsonTest {

    private CategoriesJson categoriesJson;
    private String categoriesJsonToTestAgainst = "[{\"id\":10044,\"title\":\"classic lit\",\"clues_count\":10}]";
    private int amountOfCategoriesToGet = 1;
    private int offset = 0;

    @Before
    public void setUp() {
        categoriesJson = new CategoriesJson();
    }

    @Test
    public void testGetCountAmount() throws IOException {
        categoriesJson.requestCategoriesJsonFromWeb(amountOfCategoriesToGet, offset);

        assertEquals(amountOfCategoriesToGet, categoriesJson.getCountAmount());
    }

    @Test
    public void GetCountAmountReturnsNegativeOneWhenCountWasntSet() {
        assertEquals(-1, categoriesJson.getCountAmount());
    }

    @Test
    public void testGetOffsetAmount() throws IOException {
        categoriesJson.requestCategoriesJsonFromWeb(amountOfCategoriesToGet, offset);

        assertEquals(offset, categoriesJson.getOffsetAmount());
    }

    @Test
    public void testRequestCategoriesJsonFromWeb() throws IOException {
        categoriesJson.requestCategoriesJsonFromWeb(amountOfCategoriesToGet, offset);
        assertEquals(categoriesJsonToTestAgainst, categoriesJson.getLastJsonResponse());
    }

    @Test
    public void testGetArrayOfCategories() throws IOException {
        Category[] categories = categoriesJson.getArrayOfCategories(amountOfCategoriesToGet, offset);
        assertNotNull(categories[0]);
    }

    @Test
    public void GetArrayOfManyCategories() throws IOException {
        Category[] categories = categoriesJson.getArrayOfCategories(10, offset);

        for (Category c : categories) {
            assertNotNull(c);
        }
    }
}