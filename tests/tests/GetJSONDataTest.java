package tests;

import GetJsonData.GetJSONData;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.*;


public class GetJSONDataTest {

    private GetJSONData JsonData;
    private String baseUrlOfAPI = "http://jservice.io/api/category?id=5";
    private static String jsonForCategory5 = "";

    @BeforeClass
    public static void setJsonForCategory5() throws FileNotFoundException {
        java.io.File file = new java.io.File("D:\\My Documents\\Code\\IDEA Projects\\Jeopardy\\Jeopardy-game\\JsonForCategory5.json");
        Scanner input = new Scanner(file);

        if (!input.hasNext()) {
            jsonForCategory5 = null;
        } else {
            jsonForCategory5 += input.next();
            while (input.hasNext()) {
                jsonForCategory5 += " " + input.next();
            }
        }
        input.close();
    }

    @Before
    public void setUp() throws Exception {
        JsonData = new GetJSONData(baseUrlOfAPI);
    }

    @Test
    public void testGetBaseUrlString() throws Exception {
        assertEquals(baseUrlOfAPI, JsonData.getBaseUrlString());
    }

    @Test
    public void testSetBaseUrlStringUrl() throws Exception {
        String newBaseUrl = "http://jservice.io/api/random";
        JsonData.setBaseUrlStringUrl(newBaseUrl);
        assertEquals(newBaseUrl, JsonData.getBaseUrlString());
    }

    @Test
    public void testRequestJsonFromWeb() throws Exception {
        JsonData.requestJsonFromWeb();
        assertEquals(jsonForCategory5, JsonData.getLastJsonResponse());
    }

    @Test
    public void testRequestJsonFromWebWithQueries() throws Exception {
        baseUrlOfAPI = "http://jservice.io/api/";
        JsonData.addParameterQuery("id", "5");
        JsonData.requestJsonFromWebWithQueries(JsonData.getParametersMap().keySet());

        assertEquals(jsonForCategory5, JsonData.getLastJsonResponse());
    }

    @Test
    public void testAddParameterQuery() throws Exception {
        baseUrlOfAPI = "http://jservice.io/api/";
        JsonData.addParameterQuery("id", "5");

        assertTrue(JsonData.getParametersMap().containsKey("id"));
        assertEquals("5", JsonData.getParametersMap().get("id"));
    }

    @Test
    public void testRemoveQueryParameter() throws Exception {
        baseUrlOfAPI = "http://jservice.io/api/";
        JsonData.addParameterQuery("id", "5");
        JsonData.removeQueryParameter("id");

        assertFalse(JsonData.getParametersMap().containsKey("id"));
    }

    @Test
    public void testGetQueryValue() throws Exception {
        baseUrlOfAPI = "http://jservice.io/api/";
        JsonData.addParameterQuery("id", "5");
        assertEquals("5", JsonData.getParametersMap().get("id"));
    }

    @Test
    public void testGetParametersMap() throws Exception {
        JsonData.addParameterQuery("id", "5");
        HashMap<String, String> parametersClone = new HashMap<>();
        parametersClone.put("id", "5");

        assertEquals(parametersClone, JsonData.getParametersMap());
    }

    @Test
    public void testGetLastJsonResponse() throws Exception {
        JsonData.requestJsonFromWeb();
        assertEquals(jsonForCategory5, JsonData.getLastJsonResponse());
    }
}