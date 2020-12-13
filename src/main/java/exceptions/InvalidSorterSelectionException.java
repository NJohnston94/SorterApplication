package exceptions;

/**
 * For use in ViewManager when user selects sorter
 * which is not in the list
 */
public class InvalidSorterSelectionException extends Exception {

    /**
     * Override Throwable.toString() to be thrown when user
     * makes an invalid input.
     * @return "PLEASE SELECT A VALUE FROM 1 TO 6"
     */
    @Override
    public String toString() {

        return "PLEASE SELECT A VALUE FROM 1 TO 6";

    }

}
