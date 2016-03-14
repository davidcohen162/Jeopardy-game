package tests;

import GetJsonData.RandomQuestionsJson;
import Questions.RandomQuestion;
import org.junit.Before;

import java.io.IOException;


public class RandomQuestionTest {

    private RandomQuestion question;
    private RandomQuestionsJson questionsJson;

    @Before
    public void setUp() throws IOException {
        questionsJson = new RandomQuestionsJson();
        question = new RandomQuestion(questionsJson.getRandomClueObject());
    }

}