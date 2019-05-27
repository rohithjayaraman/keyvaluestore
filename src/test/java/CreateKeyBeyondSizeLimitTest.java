import kvstore.*;
import org.json.JSONObject;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class CreateKeyBeyondSizeLimitTest {
    KeyValueStore k = new KeyValueStore();
    String key="abcdefgh123456abcxysutersjdfg432abcsd";
    String jsonValue = "{\"name\":\"test\", \"type\":\"family\"}";
    JSONObject json = new JSONObject(jsonValue);
    @Test(expected = VariableBeyondSizeLimitException.class)
    public void testK() throws FileNotFoundException, VariableBeyondSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {
        assertEquals(null,k.create(key,json));
    }
}
