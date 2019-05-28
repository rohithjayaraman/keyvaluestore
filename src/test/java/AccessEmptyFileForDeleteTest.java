import kvstore.EmptyFileException;
import kvstore.KeyValueStore;
import kvstore.MissingKeyException;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class AccessEmptyFileForDeleteTest {
    KeyValueStore k = new KeyValueStore();
    String key="asdasd232asddasdasd";
    @Test(expected= EmptyFileException.class)
    public void deleteFromEmptyFile() throws EmptyFileException, MissingKeyException, FileNotFoundException
    {
        assertEquals(null,k.delete(key));
    }
}
