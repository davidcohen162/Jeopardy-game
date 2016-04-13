package tests;

import GetJsonData.CategoriesRepository;
import Questions.Category;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CategoriesRepositoryTest {

    String firstTenCats = "[{\"id\":10044,\"title\":\"classic lit\",\"clues_count\":10},{\"id\":11507,\"title\":\"bay o' wolf\",\"clues_count\":5},{\"id\":11508,\"title\":\"gullible travels\",\"clues_count\":5},{\"id\":11509,\"title\":\"little women\",\"clues_count\":5},{\"id\":11510,\"title\":\"pair of dice, lost\",\"clues_count\":5},{\"id\":11511,\"title\":\"the scarlet letters\",\"clues_count\":5},{\"id\":11531,\"title\":\"mixed bag\",\"clues_count\":5},{\"id\":11532,\"title\":\"let's \\\"ch\\\"at\",\"clues_count\":5},{\"id\":5412,\"title\":\"prehistoric times\",\"clues_count\":10},{\"id\":11496,\"title\":\"acting families\",\"clues_count\":5}]";
    private CategoriesRepository categoriesRepository;
    private String categoriesJsonToTestAgainst = "[{\"id\":10044,\"title\":\"classic lit\",\"clues_count\":10}]";
    private Gson gson = new Gson();
    private String amountOfCategoriesToGet = "1";
    private int offset = 0;

    @Before
    public void setUp() {
        categoriesRepository = new CategoriesRepository();
    }

    @Test
    public void testGetCountAmount() throws IOException {
        categoriesRepository.requestCategoriesJsonFromWeb(amountOfCategoriesToGet, offset);

        assertEquals(amountOfCategoriesToGet, Integer.toString(categoriesRepository.getCountAmount()));
    }

    @Test
    public void GetCountAmountReturnsNegativeOneWhenCountWasntSet() {
        assertEquals(-1, categoriesRepository.getCountAmount());
    }

    @Test
    public void testGetOffsetAmount() throws IOException {
        categoriesRepository.requestCategoriesJsonFromWeb(amountOfCategoriesToGet, offset);

        assertEquals(offset, categoriesRepository.getOffsetAmount());
    }

    @Test
    public void testRequestCategoriesJsonFromWeb() throws IOException {
        categoriesRepository.requestCategoriesJsonFromWeb(amountOfCategoriesToGet, offset);
        assertEquals(categoriesJsonToTestAgainst, categoriesRepository.getLastJsonResponse());
    }

    @Test
    public void testGetArrayOfCategories() throws IOException {
        Category[] categories = categoriesRepository.getArrayOfCategories(amountOfCategoriesToGet, offset);
        assertNotNull(categories[0]);
    }

    @Test
    public void GetArrayOfManyCategories() throws IOException {
        Category[] categories = categoriesRepository.getArrayOfCategories("10", offset);

        for (Category c : categories) {
            assertNotNull(c);
        }
    }

    @Test
    public void ArrayOfManyCategoriesDeserialize() throws IOException {
        CategoriesRepository mockCatsRepo = mock(CategoriesRepository.class);
        when(mockCatsRepo.getArrayOfCategories("10", offset))
                .thenReturn(gson.fromJson(firstTenCats, Category[].class));

        Category[] categories = mockCatsRepo.getArrayOfCategories("10", offset);

        assertEquals(10044, categories[0].getId());
        assertEquals("classic lit", categories[0].getTitle());
        assertEquals(10, categories[0].getCluesCount());

        assertEquals(11507, categories[1].getId());
        assertEquals("bay o' wolf", categories[1].getTitle());
        assertEquals(5, categories[1].getCluesCount());

        assertEquals(11508, categories[2].getId());
        assertEquals("gullible travels", categories[2].getTitle());
        assertEquals(5, categories[2].getCluesCount());

        assertEquals(11509, categories[3].getId());
        assertEquals("little women", categories[3].getTitle());
        assertEquals(5, categories[3].getCluesCount());

        assertEquals(11510, categories[4].getId());
        assertEquals("pair of dice, lost", categories[4].getTitle());
        assertEquals(5, categories[4].getCluesCount());

        assertEquals(11511, categories[5].getId());
        assertEquals("the scarlet letters", categories[5].getTitle());
        assertEquals(5, categories[5].getCluesCount());

        assertEquals(11531, categories[6].getId());
        assertEquals("mixed bag", categories[6].getTitle());
        assertEquals(5, categories[6].getCluesCount());

        assertEquals(11532, categories[7].getId());
        assertEquals("let's \"ch\"at", categories[7].getTitle());
        assertEquals(5, categories[7].getCluesCount());

        assertEquals(5412, categories[8].getId());
        assertEquals("prehistoric times", categories[8].getTitle());
        assertEquals(10, categories[8].getCluesCount());

        assertEquals(11496, categories[9].getId());
        assertEquals("acting families", categories[9].getTitle());
        assertEquals(5, categories[9].getCluesCount());
    }

    @Test
    public void testGetArrayOfRandomCats() throws IOException {
        Category[] cats = categoriesRepository.getArrayOfRandomCats("1");
        assertEquals(1, cats.length);
    }

    @Test
    public void testGetArrayOfRandomCatsWithZero() throws IOException {
        Category[] cats = categoriesRepository.getArrayOfRandomCats("0");
        assertEquals(0, cats.length);
    }

    @Test
    public void testGetArrayOfRandomCatsWithMoreThan1() throws IOException {
        Category[] cats = categoriesRepository.getArrayOfRandomCats("5");
        assertEquals(5, cats.length);
    }

    @Test
    public void testGetArrayListOfCatsWithMoreThan_n_Clues() throws IOException {
        ArrayList<Category> cats = categoriesRepository.getArrayListOfCatsWithMoreThan_n_Clues(1, 20);
        assertEquals(1, cats.size());
        for (Category c : cats) {
            assertTrue(c.getCluesCount() >= 20);
        }
    }

    @Test
    public void TestGetArrayListOfCatsWithMoreThan_n_CluesWhenRequesting5Clues() throws IOException {
        ArrayList<Category> cats = categoriesRepository.getArrayListOfCatsWithMoreThan_n_Clues(5, 20);
        assertEquals(5, cats.size());
        for (Category c : cats) {
            assertTrue(c.getCluesCount() >= 20);
        }
    }

    @Test
    public void TestGetArrayListOfCatsWithMoreThan_n_CluesWhenRequesting0Clues() throws IOException {
        ArrayList<Category> cats = categoriesRepository.getArrayListOfCatsWithMoreThan_n_Clues(0, 20);
        assertEquals(0, cats.size());
    }

}