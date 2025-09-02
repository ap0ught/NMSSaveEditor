package nomanssave;

// Exception class for JSON parsing errors
public class eX extends Exception {
    public eX(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
