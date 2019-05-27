import org.junit.Test;

public class ValidPathKeyValueStoreCreationTest {
    @Test
    public void testX() throws InvalidPathException
    {
        KeyValueStore kv = new KeyValueStore("C:/");
    }
}
