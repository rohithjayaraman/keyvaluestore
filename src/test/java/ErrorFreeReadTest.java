import kvstore.*;
import org.json.JSONObject;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class ErrorFreeReadTest {
    KeyValueStore k = new KeyValueStore();
    String key="asdasdfddkjsj23skduk";
    String jsonValue = "{\"name\":\"test\", \"type\":\"family\"}";
    JSONObject json = new JSONObject(jsonValue);
    @Test
    public void ReadValue() throws FileNotFoundException, ExceededSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {
        assertEquals(key, k.create(key, json, 2));
        assertEquals(json.toString(),k.read(key).toString());
    }

}
