package kvstore;

public class NonUniqueKeyException extends Throwable {
    String key;

    public NonUniqueKeyException(String x) {
        key = x;
    }
}
