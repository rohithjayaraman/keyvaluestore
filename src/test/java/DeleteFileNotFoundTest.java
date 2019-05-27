import kvstore.EmptyFileException;
import kvstore.KeyValueStore;
import kvstore.MissingKeyException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class DeleteFileNotFoundTest {
    KeyValueStore k = new KeyValueStore();
    String key="abcdefgh1232abcsd";
    String jsonValue = "{\"name\":\"test\", \"type\":\"family\"}";
    JSONObject json = new JSONObject(jsonValue);
    @Test(expected = FileNotFoundException.class)
    public void testP() throws FileNotFoundException, MissingKeyException, EmptyFileException
    {
        assertEquals(true,k.apocalypseNow());
        assertEquals(null,k.delete(key));
    }
}
