package tests;

import Game.GameInRandomCategory;
import org.junit.Before;


public class GameInRandomCategoryTest {

    GameInRandomCategory randomCategory;

    @Before
    public void setUp() throws Exception {
        randomCategory = new GameInRandomCategory(10);
    }


}