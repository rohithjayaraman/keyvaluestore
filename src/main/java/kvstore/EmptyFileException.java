package kvstore;

public class EmptyFileException extends Throwable {
    String filename;

    public EmptyFileException(String x) {
        filename = x;
    }

   }
