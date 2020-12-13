package exceptions;

/**
 * For use in ViewManager to handle invalid exit option input
 * by the user.
 */
public class InvalidExitSelectionException extends Exception {

    /**
     * Override Throwable.toString() to be thrown when user
     * makes an invalid input.
     * @return "PLEASE SELECT 1 OR 2"
     */
    @Override
    public String toString() {
        return "PLEASE SELECT 1 OR 2";
    }

}
