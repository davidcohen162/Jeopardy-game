package tests;

import GetJsonData.CategoryJson;
import Questions.Category;
import Questions.Clue;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CategoryJsonTest {

    private CategoryJson catJson;
    private String categoryJsonToTestAgainst = "{\"id\":6,\"title\":\"\\\"cat\\\" egory\",\"clues_count\":5,\"clues\":[{\"id\":6,\"answer\":\"cat people\",\"question\":\"Malcolm McDowell \\u0026 Nastassja Kinski's \\\"purr\\\"fect roles in 1982\",\"value\":100,\"airdate\":\"1985-02-08T12:00:00.000Z\",\"category_id\":6,\"game_id\":null,\"invalid_count\":null},{\"id\":12,\"answer\":\"a catapult\",\"question\":\"Ancient weapon kept a stone's throw from its target\",\"value\":200,\"airdate\":\"1985-02-08T12:00:00.000Z\",\"category_id\":6,\"game_id\":null,\"invalid_count\":null},{\"id\":18,\"answer\":\"a catalyst\",\"question\":\"It gets things going in a chemical reaction\",\"value\":300,\"airdate\":\"1985-02-08T12:00:00.000Z\",\"category_id\":6,\"game_id\":null,\"invalid_count\":null},{\"id\":24,\"answer\":\"Maggie the Cat\",\"question\":\"Elizabeth Taylor character that could have burnt her paws on a hot tin roof\",\"value\":400,\"airdate\":\"1985-02-08T12:00:00.000Z\",\"category_id\":6,\"game_id\":null,\"invalid_count\":null},{\"id\":30,\"answer\":\"a CAT scan\",\"question\":\"During one in a hospital, your brain should think \\\"cheese\\\"\",\"value\":500,\"airdate\":\"1985-02-08T12:00:00.000Z\",\"category_id\":6,\"game_id\":null,\"invalid_count\":null}]}";

    @Before
    public void setUp() throws Exception {
        catJson = new CategoryJson();
    }

    @Test
    public void testRequestCategoryJsonFromWeb() throws Exception {
        catJson.requestCategoryJsonFromWeb(6);
        assertEquals(categoryJsonToTestAgainst, catJson.getLastJsonResponse());
    }

    @Test
    public void testGetCategory() throws Exception {
        Category category = catJson.getCategory(6);
        assertNotNull(category);
    }

    @Test
    public void DoesGsonDeserializeClues() throws IOException {
        Category category = catJson.getCategory(6);
        for (Clue c : category.getClues()) {
            assertNotNull(c);
            assertNotNull(c.getQuestion());
        }
    }
}