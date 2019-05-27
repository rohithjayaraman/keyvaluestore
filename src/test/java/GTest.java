import kvstore.*;
import org.json.JSONObject;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class GTest {
    KeyValueStore k = new KeyValueStore();
    String key="asdasdkjsj23skduk";
    String jsonValue = "{\"name\":\"test\", \"type\":\"family\"}";
    JSONObject json = new JSONObject(jsonValue);
    @Test
    public void createAndDelete() throws FileNotFoundException, ExceededSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {
        assertEquals(key, k.create(key, json, 2));
        assertEquals(true,k.delete(key));
    }
}
