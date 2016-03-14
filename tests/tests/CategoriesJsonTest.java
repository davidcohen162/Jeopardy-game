package tests;

import GetJsonData.CategoriesJson;
import Questions.Category;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;


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

    @Test
    public void testGetArrayOfRandomCats() throws IOException {
        Category[] cats = categoriesJson.getArrayOfRandomCats(1);
        assertEquals(1, cats.length);
    }

    @Test
    public void testGetArrayOfRandomCatsWithZero() throws IOException {
        Category[] cats = categoriesJson.getArrayOfRandomCats(0);
        assertEquals(0, cats.length);
    }

    @Test
    public void testGetArrayOfRandomCatsWithMoreThan1() throws IOException {
        Category[] cats = categoriesJson.getArrayOfRandomCats(5);
        assertEquals(5, cats.length);
    }

    @Test
    public void testGetArrayListOfCatsWithMoreThan_n_Clues() throws IOException {
        ArrayList<Category> cats = categoriesJson.getArrayListOfCatsWithMoreThan_n_Clues(1, 20);
        assertEquals(1, cats.size());
        for (Category c : cats) {
            assertTrue(c.getCluesCount() >= 20);
        }
    }

    @Test
    public void TestGetArrayListOfCatsWithMoreThan_n_CluesWhenRequesting5Clues() throws IOException {
        ArrayList<Category> cats = categoriesJson.getArrayListOfCatsWithMoreThan_n_Clues(5, 20);
        assertEquals(5, cats.size());
        for (Category c : cats) {
            assertTrue(c.getCluesCount() >= 20);
        }
    }

    @Test
    public void TestGetArrayListOfCatsWithMoreThan_n_CluesWhenRequesting0Clues() throws IOException {
        ArrayList<Category> cats = categoriesJson.getArrayListOfCatsWithMoreThan_n_Clues(0, 20);
        assertEquals(0, cats.size());
    }

}