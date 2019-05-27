package kvstore;

public class InvalidPathException extends Throwable{
    String path;

    public InvalidPathException(String x)
    {
        this.path=x;
    }
}
