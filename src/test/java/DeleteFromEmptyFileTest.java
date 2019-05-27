import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class DeleteFromEmptyFileTest {
    KeyValueStore k = new KeyValueStore();
    String key="asdasd232asddasdasd";
    @Test(expected=EmptyFileException.class)
    public void testB() throws EmptyFileException, MissingKeyException, FileNotFoundException
    {
        assertEquals(null,k.delete(key));
    }
}
