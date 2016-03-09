package tests;

import GetJsonData.RandomQuestionsJson;
import Questions.Clue;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class RandomQuestionsJsonTest {

    RandomQuestionsJson json;
    Gson gson = new Gson();

    @Before
    public void setUp() throws Exception {
        json = new RandomQuestionsJson();
    }

    @Test
    public void testRequestRandomClueJsonFromWeb() throws Exception {
        json.requestJsonFromWeb();
        assertNotNull(json.getLastJsonResponse());
    }

    @Test
    public void testRequestMultipleRandomCluesJson() throws Exception {
        json.requestMultipleRandomCluesJson(1);
        Clue[] clues = gson.fromJson(json.getLastJsonResponse(), Clue[].class);
        assertNotNull(clues);
    }

    @Test
    public void testGetRandomClueObject() throws Exception {
        assertNotNull(json.getRandomClueObject());
    }

    @Test
    public void testGetManyRandomClueObjects() throws Exception {
        assertNotNull(json.getManyRandomClueObjects(1));
    }
}