package sorters;

import interfaces.Sorter;

import managers.OutputManager;

/**
 * This class implements the collection sort algorithm.
 * See https://www.toptal.com/developers/sorting-algorithms/selection-sort
 * for an explanation of collection sort algorithm.
 */
public class CollectionSort implements Sorter {

    /**
     * Override Sorter interface method to initiate bubble sort.
     * @param arrayToSort unsorted array of random integers.
     * @return sorted array
     */
    @Override
    public int[] sortArray(int[] arrayToSort) {

        return collectionSort(arrayToSort);
    }

    /**
     * Override Sorter interface method to return name of sorting method.
     * @return "Collection Sorter"
     */
    @Override
    public String getSorterName() {
        return "Collection Sorter";
    }

    /**
     * The placeholder holds the index of the smallest value in the
     * iteration which starts at placeholder = i = 0 of arrayToSort
     * by default. With each iteration, the value at i is swapped
     * with the placeholder unless i is the smallest value. Then i
     * (and therefore j) is incremented by 1 and the rest of the
     * unsorted array is checked for the smallest value.
     * @param arrayToSort unsorted array.
     * @return sorted array.
     */
    public static int[] collectionSort(int[] arrayToSort) {

        for(int i = 0; i < arrayToSort.length; i++) {
            int placeholder = i;
            OutputManager.logger.debug("i::  " + i);
            OutputManager.logger.debug("array[i]::  " + arrayToSort[i]);

            for(int j = i + 1; j < arrayToSort.length; j++) {
                OutputManager.logger.debug("j::  " + j);
                OutputManager.logger.debug("array[j]::  " + arrayToSort[j]);

                if(arrayToSort[j] < arrayToSort[placeholder]) {
                    placeholder = j;
                    OutputManager.logger.debug("placeholder index::  " + placeholder);
                }
            }

            OutputManager.logger.debug("ints to swap::  " + arrayToSort[i] + ", " + arrayToSort[placeholder]);
            Swap.swapCharacters(i, placeholder, arrayToSort);
        }

        return arrayToSort;
    }

}
