package tests;

import GetJsonData.RandomQuestionsRepository;
import Questions.RandomQuestion;
import org.junit.Before;

import java.io.IOException;


public class RandomQuestionTest {

    private RandomQuestion question;
    private RandomQuestionsRepository questionsJson;

    @Before
    public void setUp() throws IOException {
        questionsJson = new RandomQuestionsRepository();
        question = new RandomQuestion(questionsJson.getRandomClueObject());
    }

}