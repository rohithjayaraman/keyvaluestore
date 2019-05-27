import kvstore.InvalidPathException;
import kvstore.KeyValueStore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LTest {
    @Test
    public void testX() throws InvalidPathException
    {
        KeyValueStore kv = new KeyValueStore("C:/");
    }
}
