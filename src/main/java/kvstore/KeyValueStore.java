package kvstore;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Timer;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class KeyValueStore
{

    private HashMap<String, String> storageMemory;
    private String pid;
    private String path;

    public KeyValueStore()
    {
        storageMemory = new HashMap<String, String>();
        pid= ManagementFactory.getRuntimeMXBean().getName();
        path=pid+"-keystore.ser";
        File file = new File(path);
        try {
            file.createNewFile();
        }catch (Exception e){e.printStackTrace();}
        System.out.println(path);
    }

    public KeyValueStore(String path) throws InvalidPathException
    {
        storageMemory = new HashMap<String, String>();
        pid=ManagementFactory.getRuntimeMXBean().getName();
        String fileSeparator = System.getProperty("file separator");
        File file = new File(path);
        if(!file.exists())
            throw new InvalidPathException(path);
        this.path=path+fileSeparator+pid+"-keystore.ser";
        File file2 = new File(this.path);
        try {
            file.createNewFile();
        }catch (Exception e){e.printStackTrace();}
    }

    private static synchronized void writeToFile(String filename, HashMap<String, String> kvstore)
    {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try
        {
             fos = new FileOutputStream(filename);
             oos = new ObjectOutputStream(fos);
            oos.writeObject(kvstore);
            oos.close();
            fos.close();
        }catch(Exception e){e.printStackTrace();}
        finally {
            fos = null;
            oos = null;
            System.gc();
        }
    }

    private static synchronized HashMap<String, String> readFromFile(String filename)
    {
        FileInputStream fis;
        ObjectInputStream ois;
        HashMap<String, String> kvstorage = null;
        try
        {
             fis = new FileInputStream(filename);
             ois = new ObjectInputStream(fis);
            kvstorage = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        }catch(Exception e){e.printStackTrace();}
        finally {
            fis = null;
            ois = null;
            System.gc();
        }
        return kvstorage;
    }

    public synchronized String create(String key, JSONObject value) throws FileNotFoundException, NonUniqueKeyException, VariableBeyondSizeLimitException, IllegalArgumentException
    {
        return create(key, value, 0);
    }

    public synchronized String create(String key, JSONObject value, long ttl) throws FileNotFoundException, NonUniqueKeyException, IllegalArgumentException , VariableBeyondSizeLimitException
    {
        File file = new File(path);
        if(key.length()>32)
            throw new VariableBeyondSizeLimitException("key");
        else if(!StringUtils.isAlphanumeric(key))
            throw new IllegalArgumentException();
        else if(((value.length()*8)/1000)>=16)
            throw new VariableBeyondSizeLimitException("value");
        else if(!file.exists())
            throw new FileNotFoundException();

        if(file.length()>0)
        {
            storageMemory = readFromFile(path);
            if (storageMemory.containsKey(key))
               throw new NonUniqueKeyException(key);
        }
        storageMemory.put(key, value.toString());

        writeToFile(path,storageMemory);

        if(ttl > 0)
            new Timer().schedule(new TimeToLive(key,path), ttl*1000);

        return key;
    }

    public synchronized JSONObject read(String key) throws FileNotFoundException, EmptyFileException, MissingKeyException
    {
        File file = new File(path);
        if(!file.exists())
            throw new FileNotFoundException();
        else if(file.length()>0)
        {
            storageMemory = readFromFile(path);
            if(storageMemory.containsKey(key)==true)
                return new JSONObject(storageMemory.get(key));
            else
                throw new MissingKeyException(key);
        }
        else
            throw new EmptyFileException(path);
    }

    public synchronized boolean delete(String key) throws EmptyFileException, MissingKeyException, FileNotFoundException
    {
        return delete(key, path);
    }

    public static synchronized boolean delete(String key, String filename) throws FileNotFoundException, EmptyFileException, MissingKeyException
    {
        File file = new File(filename);
        if(!file.exists())
            throw new FileNotFoundException();
        else if(file.length()>0)
        {
            HashMap<String, String> storage = readFromFile(filename);

            if (storage.containsKey(key))
            {
                storage.remove(key);
                writeToFile(filename, storage);
                return true;
            }
            else
                throw new MissingKeyException(key);
        }
        else
            throw new EmptyFileException(filename);
    }
    public synchronized boolean apocalypseNow()
    {
        System.gc();
        File file = new File(path);
        return file.delete();
    }
}
