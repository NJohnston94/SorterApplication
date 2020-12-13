package sorters;

import interfaces.Sorter;

/**
 * This class implements the insertion sort algorithm.
 * See https://www.toptal.com/developers/sorting-algorithms/insertion-sort
 * for an explanation of the insertion sort algorithm.
 */
public class InsertionSort implements Sorter {

    /**
     * Override Sorter interface method to initiate bubble sort.
     * @param arrayToSort unsorted array of random integers.
     * @return sorted array
     */
    @Override
    public int[] sortArray(int[] arrayToSort) {
        return insertionSort(arrayToSort);
    }

    /**
     * Override Sorter interface method to return name of sorting method.
     * @return "Insertion Sorter"
     */
    @Override
    public String getSorterName() {
        return "Insertion Sorter";
    }

    /**
     * Starting from the second (1st) value in the array. Compare every
     * preceeding value and swap values to move smaller values
     * to the front of the array. Then increment the value to be compared
     * against.
     * @param arrayToSort unsorted array
     * @return sorted array
     */
    public static int[] insertionSort(int[] arrayToSort) {
        for(int i = 1; i < arrayToSort.length; i++) {
            int placeholder = arrayToSort[i];
            int j = i - 1;

            while(j >= 0 && placeholder <= arrayToSort[j]) {
                arrayToSort[j + 1] = arrayToSort[j];
                j--;
            }

            arrayToSort[j + 1] = placeholder;
        }

        return arrayToSort;
    }

}
