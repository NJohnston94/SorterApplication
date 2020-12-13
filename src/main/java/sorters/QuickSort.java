package sorters;

import interfaces.Sorter;
import managers.OutputManager;

import java.util.Arrays;

/**
 * This class implements the quick sort algorithm.
 * See https://www.toptal.com/developers/sorting-algorithms/quick-sort
 * for an explanation of the quick sort algorithm.
 */
public class QuickSort implements Sorter {

    /**
     * Current index of the pivot.
     */
    private static int currentPivot;

    /**
     * Current index left of the pivot.
     */
    private static int currentLeftPoint;

    /**
     * Current index right of the pivot.
     */
    private static int currentRightPoint;

    /**
     * Override Sorter interface method to initiate bubble sort.
     * @param arrayToSort unsorted array of random integers.
     * @return sorted array
     */
    @Override
    public int[] sortArray(int[] arrayToSort) {
        return quickSort(0, arrayToSort.length - 1, arrayToSort);
    }

    /**
     * Override Sorter interface method to return name of sorting method.
     * @return "Quick Sorter"
     */
    @Override
    public String getSorterName() {
        return "Quick Sorter";
    }

    /**
     * A 'pivot' point is set as the midpoint in the array between the
     * two starting points, which by default are the first and last indexes
     * of the argument array. The left starting point increments up until
     * the value at that index is greater than the value at the pivot. The right
     * starting point decrements until it has a value less than the value at the pivot.
     * Swap these two values then recur the method using the new starting points
     * until the points 'meet in the middle'
     * @param startLeftPoint 0 by default
     * @param startRightPoint array.length -1 by default
     * @param arrayToSort unsorted array
     * @return sorted array
     */
    public static int[] quickSort(int startLeftPoint, int startRightPoint, int[] arrayToSort) {

        currentLeftPoint = startLeftPoint;
        OutputManager.logger.debug("starting left point:: " + currentLeftPoint);
        currentRightPoint = startRightPoint;
        OutputManager.logger.debug("starting right point:: " + currentRightPoint);
        currentPivot = arrayToSort[startLeftPoint + ((startRightPoint - startLeftPoint)/2)];
        OutputManager.logger.debug("current pivot:: " + currentPivot);

        findAndSwapValues(currentLeftPoint, currentRightPoint, currentPivot, arrayToSort);
        checkIfRecurrenceNeeded(startLeftPoint, startRightPoint, currentLeftPoint, currentRightPoint, arrayToSort);

        return arrayToSort;
    }

    /**
     * Find the next two values to be swapped and swap them using
     * Swap.swapCharacters.
     * @param leftPoint current index left of the pivot
     * @param rightPoint current index right of the pivot
     * @param pivot current pivot
     * @param arrayToSort unsorted array
     */
    private static void findAndSwapValues(int leftPoint, int rightPoint, int pivot, int[] arrayToSort) {

        currentLeftPoint = leftPoint;
        currentRightPoint = rightPoint;
        currentPivot = pivot;

        while(currentLeftPoint <= currentRightPoint) {
            while(arrayToSort[currentLeftPoint] < pivot) {
                currentLeftPoint++;
            }
            while(arrayToSort[currentRightPoint] > pivot) {
                currentRightPoint--;
            }

            if(currentLeftPoint <= currentRightPoint) {
                Swap.swapCharacters(currentLeftPoint, currentRightPoint, arrayToSort);
                currentLeftPoint++;
                currentRightPoint--;
            }
        }
    }

    /**
     * If the points either side of the pivot have not 'met' then the
     * quickSort method must be recurred.
     * @param startLeftPoint starting left index (0)
     * @param startRightPoint starting right index (length - 1)
     * @param leftPoint current left index
     * @param rightPoint current right index
     * @param arrayToSort unsorted array
     */
    private static void checkIfRecurrenceNeeded(int startLeftPoint, int startRightPoint, int leftPoint, int rightPoint, int[] arrayToSort) {

        currentLeftPoint = leftPoint;
        currentRightPoint = rightPoint;

        if(startLeftPoint < currentRightPoint) {
            OutputManager.logger.debug("QuickSort LEFT params:: " + startLeftPoint + ", " + currentRightPoint + ", " + Arrays.toString(arrayToSort));
            quickSort(startLeftPoint, currentRightPoint, arrayToSort);
        }
        if(currentLeftPoint < startRightPoint) {
            OutputManager.logger.debug("QuickSort RIGHT params:: " + currentLeftPoint + ", " + startRightPoint + ", " + Arrays.toString(arrayToSort));
            quickSort(currentLeftPoint, startRightPoint, arrayToSort);
        }
    }

}
