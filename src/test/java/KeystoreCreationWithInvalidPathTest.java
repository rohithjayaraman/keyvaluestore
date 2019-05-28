import kvstore.InvalidPathException;
import kvstore.KeyValueStore;
import org.json.JSONObject;
import org.junit.Test;

public class KeystoreCreationWithInvalidPathTest {
    KeyValueStore k = new KeyValueStore();
    String key="abcdefgh123456abcxysutersjdfg432abcsd";
    String jsonValue = "{\"name\":\"test\", \"type\":\"family\"}";
    JSONObject json = new JSONObject(jsonValue);
    @Test(expected = InvalidPathException.class)
    public void initWithInvalidPath() throws InvalidPathException
    {
        KeyValueStore kvs = new KeyValueStore("CY:/Random");
    }
}
