package tests;

import GetJsonData.GetJSONData;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import static org.junit.Assert.*;


public class GetJSONDataTest {

    private GetJSONData JsonData;
    private String baseUrlOfAPI = "http://jservice.io/api/categories";
    private static String jsonToTestAgainst = "";

    @BeforeClass
    public static void setJsonForCategory5() throws FileNotFoundException {
        java.io.File file = new java.io.File("D:\\My Documents\\Code\\IDEA Projects\\Jeopardy\\Jeopardy-game\\jsonToTestAgainst.json");
        Scanner input = new Scanner(file);

        if (!input.hasNext()) {
            jsonToTestAgainst = null;
        } else {
            jsonToTestAgainst += input.next();
            while (input.hasNext()) {
                jsonToTestAgainst += " " + input.next();
            }
        }
        input.close();
    }

    @Before
    public void setUp() {
        JsonData = new GetJSONData(baseUrlOfAPI);
    }

    @Test
    public void testGetBaseUrlString() {
        assertEquals(baseUrlOfAPI, JsonData.getBaseUrlString());
    }

    @Test
    public void testSetBaseUrlStringUrl() {
        String newBaseUrl = "http://jservice.io/api/random";
        JsonData.setBaseUrlStringUrl(newBaseUrl);
        assertEquals(newBaseUrl, JsonData.getBaseUrlString());
    }

    @Test
    public void testRequestJsonFromWeb() throws IOException {
        JsonData.setBaseUrlStringUrl("http://jservice.io/api/categories?count=50");
        JsonData.requestJsonFromWeb();
        assertEquals(jsonToTestAgainst, JsonData.getLastJsonResponse());
    }

    @Test
    public void testRequestJsonFromWebWithQueries() throws IOException {
        JsonData.addParameterQuery("count", "50");
        JsonData.requestJsonFromWebWithQueries(JsonData.getParametersMap().keySet());

        assertEquals(jsonToTestAgainst, JsonData.getLastJsonResponse());
    }

    @Test
    public void RequestWithQueriesIgnoresParametersNotPassedByKeyset() throws IOException {
        JsonData.addParameterQuery("count", "50");
        JsonData.addParameterQuery("offset", "100");

        HashSet<String> set = new HashSet<>();
        set.add("count");

        JsonData.requestJsonFromWebWithQueries(set);
        assertEquals(jsonToTestAgainst, JsonData.getLastJsonResponse());
    }

    @Test
    public void testAddParameterQuery() {
        JsonData.addParameterQuery("count", "50");

        assertTrue(JsonData.getParametersMap().containsKey("count"));
        assertEquals("50", JsonData.getParametersMap().get("count"));
    }

    @Test
    public void testRemoveQueryParameter() {
        JsonData.addParameterQuery("count", "50");
        JsonData.removeQueryParameter("count");

        assertFalse(JsonData.getParametersMap().containsKey("count"));
    }

    @Test
    public void testGetQueryValue() {
        JsonData.addParameterQuery("count", "50");
        assertEquals("50", JsonData.getParametersMap().get("count"));
    }

    @Test
    public void testGetParametersMap() {
        JsonData.addParameterQuery("count", "50");
        HashMap<String, String> parametersClone = new HashMap<>();
        parametersClone.put("count", "50");

        assertEquals(parametersClone, JsonData.getParametersMap());
    }

    @Test
    public void testGetLastJsonResponse() throws IOException {
        JsonData.setBaseUrlStringUrl("http://jservice.io/api/categories?count=50");
        JsonData.requestJsonFromWeb();
        assertEquals(jsonToTestAgainst, JsonData.getLastJsonResponse());
    }

    @Test
    public void LastJsonResponseStartsNull() {
        assertNull(JsonData.getLastJsonResponse());
    }

    @Test
    public void LastJsonResponseStringGetsUpdatedFollowingANewRequest() throws IOException {
        JsonData.setBaseUrlStringUrl("http://jservice.io/api/random");
        JsonData.requestJsonFromWeb();
        String oldJson = JsonData.getLastJsonResponse();
        JsonData.requestJsonFromWeb();
        assertNotEquals(oldJson, JsonData.getLastJsonResponse());
    }
}