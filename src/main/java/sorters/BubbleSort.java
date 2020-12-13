package sorters;

import interfaces.Sorter;

/**
 * This class implements the bubble sort algorithm.
 * See https://www.toptal.com/developers/sorting-algorithms/bubble-sort
 * for explanation of bubble sort algorithm.
 */
public class BubbleSort implements Sorter {

    /**
     * Override Sorter interface method to initiate bubble sort.
     * @param arrayToSort unsorted array of random integers.
     * @return sorted array
     */
    @Override
    public int[] sortArray(int[] arrayToSort) {

        return bubbleSort(arrayToSort);
    }

    /**
     * Override Sorter interface method to return name of sorting method.
     * @return "Bubble Sorter"
     */
    @Override
    public String getSorterName() {

        return "Bubble Sorter";
    }

    /**
     * Accepts array of random integers and iterates through them, swapping
     * smaller ones with larger ones at the preceeding index.
     * Uses Swap.swapCharacters to concisely swap any integers which satisfy
     * above condition.
     * @param arrayToSort unsorted array of random integers
     * @return sorted array
     */
    public static int[] bubbleSort(int[] arrayToSort) {
        int arrayLength = arrayToSort.length;

        for(int i = 0; i < arrayLength; i++) {
            for(int j = 1; j < arrayLength; j++) {
                if(arrayToSort[j-1] > arrayToSort[j]) {
                    Swap.swapCharacters(j-1, j, arrayToSort);
                }
            }
        }

        return arrayToSort;
    }

}
