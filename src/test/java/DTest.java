import kvstore.*;
import org.json.JSONObject;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class DTest {
    KeyValueStore k = new KeyValueStore();
    String key="abcdefgh123456fg432abcsd";
    JSONObject json = new JSONObject();
    @Test(expected = ExceededSizeLimitException.class)
    public void createWithJsonValueOverLimit() throws FileNotFoundException, ExceededSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {   for(int i=0;i<2052;i++)
        json.put("adsd"+i,2);
        assertEquals(key,k.create(key,json));
    }
}
