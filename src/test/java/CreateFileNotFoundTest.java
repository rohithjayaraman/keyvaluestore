import org.json.JSONObject;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class CreateFileNotFoundTest {
    KeyValueStore k = new KeyValueStore();
    String key="abcysutersjdfg432abcsd";
    String jsonValue = "{\"name\":\"test\", \"type\":\"family\"}";
    JSONObject json = new JSONObject(jsonValue);
    @Test(expected = FileNotFoundException.class)
    public void testQ() throws FileNotFoundException, VariableBeyondSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {
        assertEquals(true,k.apocalypseNow());
        assertEquals(null,k.create(key,json));
    }
}
