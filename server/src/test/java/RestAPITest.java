import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;


public class RestAPITest {

    @Test
    public void TestPersonalInfo() throws IOException {
        JSONObject json = getJSONFromURL("http://localhost:8080/cv/personalinfo");
        Assert.assertTrue(json.has("name"));
        Assert.assertTrue(json.has("birthDay"));
        Assert.assertTrue(json.has("description"));
        Assert.assertTrue(json.has("mail"));
        Assert.assertTrue(json.has("phone"));
        Assert.assertTrue(json.has("skype"));
    }

    @Test
    public void TestSkills() throws IOException {
        JSONArray jsonArray = getJSONArrayFromURL("http://localhost:8080/cv/skills");
        Assert.assertTrue(jsonArray.length() > 0);
        for(Object jsonObj : jsonArray){
            JSONObject json = (JSONObject) jsonObj;
            Assert.assertTrue(json.has("name"));
            Assert.assertTrue(json.has("description"));
        }
    }

    @Test
    public void TestJobs() throws IOException {
        JSONArray jsonArray = getJSONArrayFromURL("http://localhost:8080/cv/jobs");
        Assert.assertTrue(jsonArray.length() > 0);
    }

    @Test
    public void TestEducations() throws IOException {
        JSONArray jsonArray = getJSONArrayFromURL("http://localhost:8080/cv/educations");
        Assert.assertTrue(jsonArray.length() > 0);
    }


    private JSONObject getJSONFromURL(String urlString) throws IOException {
        URL url = new URL(urlString);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("UTF-8")));
        return new JSONObject(readAll(reader));
    }

    private JSONArray getJSONArrayFromURL(String urlString) throws IOException {
        URL url = new URL(urlString);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("UTF-8")));
        return new JSONArray(readAll(reader));
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
