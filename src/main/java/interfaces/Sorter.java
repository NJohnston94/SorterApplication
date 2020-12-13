package interfaces;

/**
 * Common interface for all sorter classes. Contains method for
 * taking unsorted array and sorting it and method for returning
 * the name of the sorter.
 */
public interface Sorter {

    /**
     * Accepts an array of randomly generated integers and will be
     * uniquely implemented by each sorter class to return a
     * sorted array.
     * @param arrayToSort unsorted array of random integers.
     * @return sorted array in ascending order by default.
     */
    int[] sortArray(int[] arrayToSort);

    /**
     * Convenient method for getting the name of the sorter
     * to display to the user.
     * @return name of sorter class.
     */
    String getSorterName();
}
