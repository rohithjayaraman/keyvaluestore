import kvstore.*;
import org.json.JSONObject;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class CreateWithNonUniqueKeyTest {
    KeyValueStore k = new KeyValueStore();
    String key="asdas2344sk44disdss23";
    String jsonValue = "{\"name\":\"test\", \"type\":\"family\"}";
    JSONObject json = new JSONObject(jsonValue);
    @Test(expected = NonUniqueKeyException.class)
public void createWithNonUniqueKey() throws FileNotFoundException, ExceededSizeLimitException, NonUniqueKeyException
{
    assertEquals(key,k.create(key,json));
    assertEquals(key,k.create(key,json));
}
}
