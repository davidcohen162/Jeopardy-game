package tests;

import GetJsonData.CategoryRepository;
import Questions.Category;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class CategoryRepositoryTest {
    private CategoryRepository categoryRepository;
    private Gson gson = new Gson();
    private CategoryRepository mockCategoryRepo = mock(CategoryRepository.class);

    private String categoryJsonToTestAgainst =
            "{" +
                    "\"id\":6," +
                    "\"title\":\"\\\"cat\\\" egory\"," +
                    "\"clues_count\":5," +
                    "\"clues\":[" +
                    "{" +
                    "\"id\":6," +
                    "\"answer\":\"cat people\"," +
                    "\"question\":\"Malcolm McDowell \\u0026 Nastassja Kinski's \\\"purr\\\"fect roles in 1982\"," +
                    "\"value\":100," +
                    "\"airdate\":\"1985-02-08T12:00:00.000Z\"," +
                    "\"category_id\":6," +
                    "\"game_id\":null," +
                    "\"invalid_count\":null" +
                    "}," +
                    "{" +
                    "\"id\":12," +
                    "\"answer\":\"a catapult\"," +
                    "\"question\":\"Ancient weapon kept a stone's throw from its target\"," +
                    "\"value\":200," +
                    "\"airdate\":\"1985-02-08T12:00:00.000Z\"," +
                    "\"category_id\":6," +
                    "\"game_id\":null," +
                    "\"invalid_count\":null" +
                    "}," +
                    "{" +
                    "\"id\":18,\"answer\":\"a catalyst\"," +
                    "\"question\":\"It gets things going in a chemical reaction\"," +
                    "\"value\":300," +
                    "\"airdate\":\"1985-02-08T12:00:00.000Z\"," +
                    "\"category_id\":6," +
                    "\"game_id\":null," +
                    "\"invalid_count\":null" +
                    "}," +
                    "{" +
                    "\"id\":24,\"answer\":\"Maggie the Cat\"," +
                    "\"question\":\"Elizabeth Taylor character that could have burnt her paws on a hot tin roof\"," +
                    "\"value\":400,\"airdate\":\"1985-02-08T12:00:00.000Z\"," +
                    "\"category_id\":6," +
                    "\"game_id\":null," +
                    "\"invalid_count\":null" +
                    "}," +
                    "{" +
                    "\"id\":30," +
                    "\"answer\":\"a CAT scan\"," +
                    "\"question\":\"During one in a hospital, your brain should think \\\"cheese\\\"\"," +
                    "\"value\":500," +
                    "\"airdate\":\"1985-02-08T12:00:00.000Z\"," +
                    "\"category_id\":6," +
                    "\"game_id\":null," +
                    "\"invalid_count\":null" +
                    "}" +
                    "]" +
                    "}";

    @Before
    public void setUp() throws Exception {
        categoryRepository = new CategoryRepository();
    }

    @Test
    public void testRequestCategoryJsonFromWeb() throws IOException {
        categoryRepository.requestCategoryJsonFromWeb("6");
        assertEquals(categoryJsonToTestAgainst, categoryRepository.getLastJsonResponse());
    }

    @Test
    public void testGetCategory() throws Exception {
        Category category = categoryRepository.getCategory("6");
        assertNotNull(category);
    }

    @Test
    public void DoesGsonDeserializeClues() throws IOException {
        when(mockCategoryRepo.getCategory(contains("6")))
                .thenReturn(gson.fromJson(categoryJsonToTestAgainst, Category.class));

        Category category = mockCategoryRepo.getCategory("6");

        assertEquals(6, category.getClues().get(0).getId());
        assertEquals("cat people", category.getClues().get(0).getAnswer());
        assertEquals("Malcolm McDowell \u0026 Nastassja Kinski's \"purr\"fect roles in 1982",
                category.getClues().get(0).getQuestion());
        assertEquals(100, category.getClues().get(0).getValue());
        assertEquals(6, category.getClues().get(0).getCategoryId());

        assertEquals(12, category.getClues().get(1).getId());
        assertEquals("a catapult", category.getClues().get(1).getAnswer());
        assertEquals("Ancient weapon kept a stone's throw from its target",
                category.getClues().get(1).getQuestion());
        assertEquals(200, category.getClues().get(1).getValue());
        assertEquals(6, category.getClues().get(1).getCategoryId());

        assertEquals(18, category.getClues().get(2).getId());
        assertEquals("a catalyst", category.getClues().get(2).getAnswer());
        assertEquals("It gets things going in a chemical reaction",
                category.getClues().get(2).getQuestion());
        assertEquals(300, category.getClues().get(2).getValue());
        assertEquals(6, category.getClues().get(2).getCategoryId());

        assertEquals(24, category.getClues().get(3).getId());
        assertEquals("Maggie the Cat", category.getClues().get(3).getAnswer());
        assertEquals("Elizabeth Taylor character that could have burnt her paws on a hot tin roof",
                category.getClues().get(3).getQuestion());
        assertEquals(400, category.getClues().get(3).getValue());
        assertEquals(6, category.getClues().get(3).getCategoryId());

        assertEquals(30, category.getClues().get(4).getId());
        assertEquals("a CAT scan", category.getClues().get(4).getAnswer());
        assertEquals("During one in a hospital, your brain should think \"cheese\"",
                category.getClues().get(4).getQuestion());
        assertEquals(500, category.getClues().get(4).getValue());
        assertEquals(6, category.getClues().get(4).getCategoryId());
    }

    @Test
    public void testGetRandomCatWith_n_Clues() throws IOException {
        Category category = categoryRepository.getRandomCatWith_n_Clues(20);
        assertTrue(category.getCluesCount() >= 20);
        assertTrue(category.getClues().size() >= 20);
    }
}