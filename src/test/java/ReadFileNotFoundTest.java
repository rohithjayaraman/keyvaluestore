import kvstore.*;
import org.json.JSONObject;
import org.junit.Test;

import java.io.FileNotFoundException;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class ReadFileNotFoundTest {
    KeyValueStore k = new KeyValueStore();
    String key="abcdefgh123456asd";
    String jsonValue = "{\"name\":\"test\", \"type\":\"family\"}";
    JSONObject json = new JSONObject(jsonValue);
    @Test(expected = FileNotFoundException.class)
    public void testN() throws InterruptedException, FileNotFoundException, VariableBeyondSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {
        assertEquals(key,k.create(key,json,3));
        assertEquals(true,k.apocalypseNow());
        sleep(3000);
        assertEquals(null, k.read(key));
    }
}
