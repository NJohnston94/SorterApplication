package exceptions;

/**
 * For use in ViewManager when user selects array length too long
 * or too short.
 */
public class InvalidLengthParameterException extends Exception {

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
