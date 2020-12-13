package org.application;

import sorters.InsertionSort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InsertionSortTest {

    @Test
    void doesBubbleSort() {
        Assertions.assertArrayEquals(new int[] {1,2,3,4,5},
                InsertionSort.insertionSort(new int[] {3,5,2,4,1}));
    }

    @Test
    void doesBubbleSortHandleDuplicates() {
        Assertions.assertArrayEquals(new int[] {1,1,1,2,2,2,3,3,3,},
                InsertionSort.insertionSort(new int[] {3,2,1,3,2,1,3,2,1}));
    }
}