import kvstore.*;
import org.json.JSONObject;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class CreateWithKeySizeBeyondLimitTest {
    KeyValueStore k = new KeyValueStore();
    String key="abcdefgh123456abcxysutersjdfg432abcsd";
    String jsonValue = "{\"name\":\"test\", \"type\":\"family\"}";
    JSONObject json = new JSONObject(jsonValue);
    @Test(expected = ExceededSizeLimitException.class)
    public void createWithKeySizeOverLimit() throws FileNotFoundException, ExceededSizeLimitException, NonUniqueKeyException
    {
        assertEquals(null,k.create(key,json));
    }
}
