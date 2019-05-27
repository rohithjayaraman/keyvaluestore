public class MissingKeyException extends Throwable {
    String key;

    public MissingKeyException(String x) {
        key = x;
    }

    public String toString() {
        return "Key " + key + " is not present in the key-value store";
    }
}
