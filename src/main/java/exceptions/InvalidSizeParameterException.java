package exceptions;

/**
 * For use in ViewManager when user selects integer size too big
 * or too small.
 */
public class InvalidSizeParameterException extends Exception {

    /**
     * Override Throwable.toString() to be thrown when user
     * makes an invalid input.
     * @return "PLEASE SELECT A VALUE FROM 2 TO 10,000"
     */
    @Override
    public String toString() {

        return "PLEASE SELECT A VALUE FROM 2 TO 10,000";

    }
}
