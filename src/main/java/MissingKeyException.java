public class MissingKeyException extends Throwable {
    String key;

    public MissingKeyException(String x) {
        key = x;
    }
}
