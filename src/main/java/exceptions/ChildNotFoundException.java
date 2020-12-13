package exceptions;

/**
 * For use in BinaryTreeSort class.
 */
public class ChildNotFoundException extends Exception{

    /**
     * Override Throwable.toString() to be called when
     * node in binary tree has no child node on specified
     * side (left or right).
     * @return "CHILD NOT FOUND"
     */
    @Override
    public String toString() {
        return "CHILD NOT FOUND";
    }

}
