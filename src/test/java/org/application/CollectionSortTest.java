package org.application;

import sorters.CollectionSort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectionSortTest {

    @Test
    void doesCollectionSort() {
        Assertions.assertArrayEquals(new int[] {1,2,3,4,5},
                CollectionSort.collectionSort(new int[] {3,5,2,4,1}));
    }

    @Test
    void doesCollectionSortHandleDuplicates() {
        Assertions.assertArrayEquals(new int[] {1,1,1,2,2,2,3,3,3,},
                CollectionSort.collectionSort(new int[] {3,2,1,3,2,1,3,2,1}));
    }
}