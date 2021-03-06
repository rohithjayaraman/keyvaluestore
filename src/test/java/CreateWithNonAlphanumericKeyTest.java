import kvstore.*;
import org.json.JSONObject;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class CreateWithNonAlphanumericKeyTest {
    KeyValueStore k = new KeyValueStore();
    String key="abc!asdasdasd";
    String jsonValue = "{\"name\":\"test\", \"type\":\"family\"}";
    JSONObject json = new JSONObject(jsonValue);
    @Test(expected = IllegalArgumentException.class)
    public void createWithIllegalKey() throws FileNotFoundException, ExceededSizeLimitException, NonUniqueKeyException
    {
        assertEquals(null,k.create(key,json));
    }
}
