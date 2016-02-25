import GetJsonData.CategoryJson;
import GetJsonData.RandomQuestionsJson;
import Questions.Category;
import Questions.Clue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class RandomQuestion extends Question{

    private static RandomQuestionsJson RandClueJson = new RandomQuestionsJson();


    public RandomQuestion(RandomQuestionsJson RandClueJson) throws IOException {
        super(RandClueJson);
    }
}