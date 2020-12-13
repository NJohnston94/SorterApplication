package sorters;

import interfaces.Sorter;
import managers.OutputManager;

/**
 * This class implements the merge sort algorithm.
 * See https://www.toptal.com/developers/sorting-algorithms/merge-sort
 * for an explanation of the merge sort algorithm.
 */
public class MergeSort implements Sorter {

    /**
     * Override Sorter interface method to initiate bubble sort.
     * @param arrayToSort unsorted array of random integers.
     * @return sorted array
     */
    @Override
    public int[] sortArray(int[] arrayToSort) {

        return mergeSort(arrayToSort);
    }

    /**
     * Override Sorter interface method to return name of sorting method.
     * @return "Bubble Sorter"
     */
    @Override
    public String getSorterName() {

        return "Merge Sorter";
    }

    /**
     * Call mergeSortSplit with initial high and low parameters. From here
     * it will call itself recursively to merge and sort the array.
     * @param arrayToSort unsorted array
     * @return sorted array
     */
    public static int[] mergeSort(int[] arrayToSort) {

        mergeSortSplit(arrayToSort, 0, arrayToSort.length -1);

        return arrayToSort;
    }

    /**
     * Implementation from https://stackabuse.com/merge-sort-in-java
     *
     * @param array unsorted array
     * @param low low boundary
     * @param high high boundary
     */
    public static void mergeSortSplit(int[] array, int low, int high) {
        if (high <= low) return;

        int mid = (low+high)/2;
        mergeSortSplit(array, low, mid);
        mergeSortSplit(array, mid+1, high);

        OutputManager.logger.debug("low:: " + low +
                                        ", mid:: " + mid +
                                        ", high:: " + high);
        merge(array, low, mid, high);
    }

    /**
     * Implementation from https://stackabuse.com/merge-sort-in-java
     *
     * @param array unsorted array
     * @param low low boundary
     * @param mid mid point
     * @param high high boundary
     */
    public static void merge(int[] array, int low, int mid, int high) {
        // Creating temporary subarrays
        int[] leftArray = new int[mid - low + 1];
        int[] rightArray = new int[high - mid];

        // Copying our subarrays into temporaries
        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = array[low + i];
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array[mid + i + 1];

        // Iterators containing current index of temp subarrays
        int leftIndex = 0;
        int rightIndex = 0;

        // Copying from leftArray and rightArray back into array
        for (int i = low; i < high + 1; i++) {
            // If there are still uncopied elements in R and L, copy minimum of the two
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                // If all elements have been copied from rightArray, copy rest of leftArray
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                // If all elements have been copied from leftArray, copy rest of rightArray
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
