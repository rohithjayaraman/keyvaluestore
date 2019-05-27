public class VariableBeyondSizeLimitException extends Throwable {
    String item;

    public VariableBeyondSizeLimitException(String x) {
        item = x;
    }

   }
