import kvstore.*;
import org.json.JSONObject;
import org.junit.Test;

import java.io.FileNotFoundException;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class ReadMissingKeyTest {
    KeyValueStore k = new KeyValueStore();
    String key="asdas2344sk44dis23";
    String key2="asdasdsd23dasd2312";
    String jsonValue = "{\"name\":\"test\", \"type\":\"family\"}";
    JSONObject json = new JSONObject(jsonValue);
    @Test(expected = MissingKeyException.class)
    public void testH() throws  InterruptedException, VariableBeyondSizeLimitException, NonUniqueKeyException, MissingKeyException, FileNotFoundException, EmptyFileException
    {
        assertEquals(key2, k.create(key2, json, 2));
        sleep(3000);
        assertEquals(null, k.read(key2));

    }
}
