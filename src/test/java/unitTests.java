import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.FileNotFoundException;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class unitTests {
    static kvstore k,k2;
    static String jsonValue, key, key2, key3, key4, key6;
    static JSONObject json,json2;
    @BeforeClass
    public static void setup() {
        k = new kvstore();
        k2 = new kvstore("C:/Users/iamrj/Desktop");
        jsonValue = "{\"name\":\"test\", \"type\":\"family\"}";
        json = new JSONObject(jsonValue);
        key = "abcdefgh123456abcxysutersjdfg432";
        json2 = new JSONObject();
        key2 = "x1iskdfjyy3uip98jfgixkjlop38opuy";
        key3 = "skdjfgiop9354er22tjxkjiopkmnhg23";
        key4 = "asdasdasd23123asdfasd";
        key6="asjdkasiduaiud231231";
    }
   @Test(expected = MissingKeyException.class)
   public void testG() throws FileNotFoundException, VariableBeyondSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {
        assertEquals(key,k.create(key,json));
        assertEquals(json.toString(),k.read(key).toString());
        assertEquals(true,k.delete(key));
        assertEquals(true,k.delete(key4));
    }
    @Test
    public void testC() throws FileNotFoundException, VariableBeyondSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {
        assertEquals(key6, k.create(key6, json, 2));
        assertEquals(true,k.delete(key6));
    }
    @Test(expected = FileNotFoundException.class)
    public void testN() throws InterruptedException, FileNotFoundException, VariableBeyondSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {
        assertEquals("akjhg123asdasda",k.create("akjhg123asdasda",json,3));
        assertEquals(true,k.apocalypseNow());
        sleep(3000);
        assertEquals(null, k.read(key));
    }
    @Test(expected = FileNotFoundException.class)
    public void testP() throws FileNotFoundException, VariableBeyondSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {
        assertEquals(null,k.delete(key));
    }
    @Test(expected = FileNotFoundException.class)
    public void testQ() throws FileNotFoundException, VariableBeyondSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {
        assertEquals(null,k.create(key,json));
    }
    @Test(expected = MissingKeyException.class)
    public void testH() throws  InterruptedException, VariableBeyondSizeLimitException, NonUniqueKeyException, MissingKeyException, FileNotFoundException, EmptyFileException
    {
            assertEquals(key2, k.create(key2, json, 2));
            sleep(3000);
            assertEquals(null, k.read(key2));

    }
    @Test(expected = NonUniqueKeyException.class)
    public void testI() throws FileNotFoundException, VariableBeyondSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {
        assertEquals(key,k.create(key,json));
        assertEquals(key,k.create(key,json));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testJ() throws FileNotFoundException, VariableBeyondSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {
        assertEquals(null,k.create("abc!",json));
    }

    @Test(expected = VariableBeyondSizeLimitException.class)
    public void testK() throws FileNotFoundException, VariableBeyondSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {
        assertEquals(null,k.create("abcdefgh123456abcxysutersjdfg432abcsd",json));
    }
    @Test(expected = VariableBeyondSizeLimitException.class)
    public void testL() throws FileNotFoundException, VariableBeyondSizeLimitException, NonUniqueKeyException, MissingKeyException, EmptyFileException
    {   for(int i=0;i<2001;i++)
        json2.put("adsd"+i,2);
        assertEquals("abcdefgh123456fg432abcsd",k.create("abcdefgh123456fg432abcsd",json2));
    }
    @Test(expected=EmptyFileException.class)
    public void testA() throws EmptyFileException, MissingKeyException, FileNotFoundException
    {
        assertEquals(null,k.read(key));
    }

    @Test(expected=EmptyFileException.class)
    public void testB() throws EmptyFileException, MissingKeyException, FileNotFoundException
    {
        assertEquals(null,k.delete(key));
    }
}
