import kvstore.InvalidPathException;
import kvstore.KeyValueStore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidPathKeyValueStoreCreationTest {
    @Test
    public void testX() throws InvalidPathException
    {
        KeyValueStore kv = new KeyValueStore("C:/");
        assertEquals(true,kv.apocalypseNow());
    }
}
