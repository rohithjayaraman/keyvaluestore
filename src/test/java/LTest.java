import kvstore.*;
import org.json.JSONObject;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class LTest {
    KeyValueStore k = new KeyValueStore();
    String key="asdas2344skdis23";
    String key2="asdasdsddasd2312";
    String jsonValue = "{\"name\":\"test\", \"type\":\"family\"}";
    JSONObject json = new JSONObject(jsonValue);
    @Test(expected = MissingKeyException.class)
    public void deleteMissingKey() throws FileNotFoundException, ExceededSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {
        assertEquals(key,k.create(key,json));
        assertEquals(true,k.delete(key2));
    }
}
