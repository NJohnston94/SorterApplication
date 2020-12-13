package managers;

import exceptions.InvalidSorterSelectionException;
import interfaces.Sorter;
import sorters.*;

/**
 * Contains SortFactory which is used to instantiate sorter object depending
 * on user input. Also contains method to call main sort method from each class
 * which is implemented by a common sorter interface. System.nanoTime is used to
 * calculate how long the selected method takes to sort the array.
 */
public class SortManager {

    /**
     * Sorter object is an interface implemented by each sorter class which means
     * they all have the same method call implemented in their own way.
     */
    public static  Sorter  sorter;

    /**
     * System.nanoTime used to store calculation time here.
     */
    public static  long    sortTime;

    /**
     * Nanoseconds (System.nanoTime) converted to microseconds or milliseconds
     * to keep the time displayed to the user concise.
     */
    public static  String  timeUnits;

    /**
     * Accepts user input to instantiate a new sorter object.
     * @param sortMethod user input corresponds to selected method
     * @return return new sorter object
     */
    public static Sorter SorterFactory(int sortMethod) {

        switch(sortMethod) {
            case 1 :
                return new BinaryTreeSort();
            case 2 :
                return new BubbleSort();
            case 3 :
                return new CollectionSort();
            case 4 :
                return new InsertionSort();
            case 5 :
                return new MergeSort();
            case 6 :
                return new QuickSort();
        }

        return null;
    }

    /**
     * Show the selection of sort methods available, and select which will be
     * used by corresponding number which will be read by the scanner object.
     * Display the method the user has chosen.
     * @param scannedInt user input
     * @throws InvalidSorterSelectionException Thrown if user inputs invalid value
     */
    public static void selectSorter(int scannedInt) throws InvalidSorterSelectionException {

        if((scannedInt < 1) || (scannedInt > 6)) {
            OutputManager.logger.debug("InvalidSorterSelectionException thrown");
            throw new InvalidSorterSelectionException();
        } else {
            sorter = SorterFactory(scannedInt);
        }
    }

    /**
     * Sort the array using the method selected and measure how long it takes using
     * System.nanoTime().
     * @return  The sorted array.
     */
    public static int[] timedArraySort() {

        long start = System.nanoTime();
        int[] sortedArray = SortManager.sorter.sortArray(ArrayManager.unsortedArray);
        long finish = System.nanoTime();

        sortTime = calculateTimeToSort(start, finish);

        return sortedArray;

    }

    /**
     * Format the time taken to sort and give appropriate units.
     * @param start     Starting nanoTime()
     * @param finish    Ending nanoTime()
     * @return          return the time in ms, us or ns
     */
    public static long calculateTimeToSort(long start, long finish) {
        long totalTime = finish - start;
        if(totalTime > 999_999) {
            timeUnits = "ms";
            totalTime = totalTime/1_000_000;
        } else if(totalTime > 999) {
            timeUnits = "us";
            totalTime = totalTime/1_000;
        } else {
            timeUnits = "ns";
        }

        return totalTime;
    }

}
