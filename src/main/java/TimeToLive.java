import java.io.FileNotFoundException;
import java.util.TimerTask;

public class TimeToLive extends TimerTask
{
    private String key,filename;

    public TimeToLive(String key, String filename){
        this.key = key;
        this.filename = filename;
    }

    @Override
    public void run() {
        if(this.key != null & this.key.length() > 0){
            try {
                KeyValueStore.delete(this.key, this.filename);
            }catch(FileNotFoundException e){e.printStackTrace();}
             catch(MissingKeyException e){e.printStackTrace();}
             catch(EmptyFileException e){e.printStackTrace();}
        }
    }

}
