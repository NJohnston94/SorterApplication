package sorters;

/**
 * Swap characters in an array using a placeholder.
 */
public class Swap {

    /**
     * Swap characters in an array using a placeholder.
     * @param i arbitrary index
     * @param j arbitrary index
     * @param arrayToSort array in which characters will be swapped
     */
    public static void swapCharacters(int i, int j, int[] arrayToSort) {
        int placeholder = arrayToSort[i];
        arrayToSort[i] = arrayToSort[j];
        arrayToSort[j] = placeholder;
    }
}
