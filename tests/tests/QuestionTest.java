package tests;

import GetJsonData.CategoryJson;
import GetJsonData.RandomQuestionsJson;
import Questions.Clue;
import Questions.Question;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class QuestionTest {

    private Question question;
    private RandomQuestionsJson questionsJson = new RandomQuestionsJson();
    private Gson gson = new Gson();

    @Before
    public void setUp() throws IOException {
        question = new Question(questionsJson.getRandomClueObject());
    }

    @Test
    public void testSetAnswers() throws IOException {
        CategoryJson categoryJson = new CategoryJson();
        question.setAnswers((ArrayList<Clue>) categoryJson.getCategory(question.getCLUE().getCategoryId()).getClues());
        for (int i = 0; i < question.INCORRECT_ANSWER_CHOICES + 1; i++) {
            assertNotNull(question.getAnswerFromMultipleChoice(i));
        }
    }

    @Test
    public void AnswerListIsSameCategory() {
        fail();
    }

    @Test
    public void testSetAnsweredCorrectly() throws IOException {
        CategoryJson categoryJson = new CategoryJson();
        question.setAnswers((ArrayList<Clue>) categoryJson.getCategory(question.getCLUE().getCategoryId()).getClues());

        question.setAnsweredCorrectly(question.getCLUE().getAnswer());

        assertTrue(question.isAnsweredCorrectly());
    }

    @Test
    public void answeredCorrectlyIsFalseWhenPassedAWrongAnswer() throws IOException {
        CategoryJson categoryJson = new CategoryJson();
        question.setAnswers((ArrayList<Clue>) categoryJson.getCategory(question.getCLUE().getCategoryId()).getClues());

        question.setAnsweredCorrectly("The truth is like poetry. And most people hates poetry");
        assertFalse(question.isAnsweredCorrectly());
    }

    @Test
    public void answeredCorrectlyIsFalseByDefault() {
        assertFalse(question.isAnsweredCorrectly());
    }

}