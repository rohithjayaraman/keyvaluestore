import kvstore.InvalidPathException;
import kvstore.KeyValueStore;
import org.junit.Test;

public class ValidPathKeyValueStoreCreationTest {
    @Test
    public void testX() throws InvalidPathException
    {
        KeyValueStore kv = new KeyValueStore("C:/");
    }
}
