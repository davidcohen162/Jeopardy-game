package tests;

import Game.GameInRandomCategory;
import Questions.Category;
import Questions.Question;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class GameInRandomCategoryTest {

    GameInRandomCategory randomCategory;

    @Before
    public void setUp() throws Exception {
        randomCategory = new GameInRandomCategory(10, 30);
    }

    @Test
    public void testSetUpQuestions() throws Exception {
        randomCategory.setUpQuestions();
        for (Question q : randomCategory.getGameQuestions().getQuestionsList()) {
            assertNotNull(q);
        }
    }

    @Test(timeout = 10000)
    public void testGetValidCategories() throws Exception {
        ArrayList<Category> categoryList = randomCategory.getValidCategories(1);
        for (Category c : categoryList) {
            assertTrue(c.getCluesCount() >= 10);
            assertNotNull(c);
        }
    }
}