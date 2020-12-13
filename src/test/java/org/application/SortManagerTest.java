package org.application;

import exceptions.InvalidSorterSelectionException;

import managers.SortManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortManagerTest {

    @Test
    void doesZeroGiveInvalidSorterSelectionException() {
        Assertions.assertThrows(InvalidSorterSelectionException.class,
                () -> {
                    SortManager.selectSorter(0);
                });
    }

    @Test
    void doesSevenGiveInvalidSorterSelectionException() {
        Assertions.assertThrows(InvalidSorterSelectionException.class,
                () -> {
                    SortManager.selectSorter(7);
                });
    }

}
