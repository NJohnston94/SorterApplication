package org.application;

import sorters.BubbleSort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {

    @Test
    void doesBubbleSort() {
        Assertions.assertArrayEquals(new int[] {1,2,3,4,5},
                                     BubbleSort.bubbleSort(new int[] {3,5,2,4,1}));
    }

    @Test
    void doesBubbleSortHandleDuplicates() {
        Assertions.assertArrayEquals(new int[] {1,1,1,2,2,2,3,3,3,},
                                     BubbleSort.bubbleSort(new int[] {3,2,1,3,2,1,3,2,1}));
    }
}
