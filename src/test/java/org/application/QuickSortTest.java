package org.application;

import sorters.QuickSort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSortTest {

    @Test
    void doesQuickSort() {
        Assertions.assertArrayEquals(new int[] {1,2,3,4,5},
                QuickSort.quickSort(0, 4, new int[] {3,5,2,4,1}));
    }

    @Test
    void doesQuickSortHandleDuplicates() {
        Assertions.assertArrayEquals(new int[] {1,1,1,2,2,2,3,3,3,},
                QuickSort.quickSort(0, 8, new int[] {3,2,1,3,2,1,3,2,1}));
    }
}