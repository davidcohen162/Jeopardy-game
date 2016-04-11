package tests;

import GetJsonData.RandomQuestionsRepository;
import Questions.Clue;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;


public class RandomQuestionsRepositoryTest {

    private RandomQuestionsRepository json;
    private Gson gson = new Gson();

    @Before
    public void setUp() throws Exception {
        json = new RandomQuestionsRepository();
    }

    @Test
    public void testRequestRandomClueFromWeb() throws IOException {
        json.requestJsonFromWeb();
//        Because lastJsonResponse is initialized to null, if the request was successful then it should not
//        be null.
        assertNotNull(json.getLastJsonResponse());
    }

    @Test
    public void testRequestMultipleRandomCluesFromWeb() throws Exception {
        json.requestMultipleRandomCluesFromWeb(5);
        Clue[] clues = gson.fromJson(json.getLastJsonResponse(), Clue[].class);

        for (Clue clue : clues) {
            assertNotNull(clue);
        }
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