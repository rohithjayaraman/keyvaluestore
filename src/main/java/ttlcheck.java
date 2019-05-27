import java.io.FileNotFoundException;
import java.util.TimerTask;

public class ttlcheck extends TimerTask
{
    private String key,filename;

    public ttlcheck(String key, String filename){
        this.key = key;
        this.filename = filename;
    }

    @Override
    public void run() {
        if(this.key != null & this.key.length() > 0){
            try {
                kvstore.delete(this.key, this.filename);
            }catch(FileNotFoundException e){}
             catch(MissingKeyException e){}
             catch(EmptyFileException e){}
        }
    }

}
