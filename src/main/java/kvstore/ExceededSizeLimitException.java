package kvstore;

public class ExceededSizeLimitException extends Throwable {
    String item;

    public ExceededSizeLimitException(String x) {
        item = x;
    }

   }
