package org.application;

import exceptions.InvalidExitSelectionException;

import managers.ViewManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ViewManagerTest {

    @Test
    void doesZeroGiveInvalidExitException() {
        Assertions.assertThrows(InvalidExitSelectionException.class,
                () -> {ViewManager.isExit(0);
                });
    }

    @Test
    void doesThreeGiveInvalidExitException() {
        Assertions.assertThrows(InvalidExitSelectionException.class,
                () -> {ViewManager.isExit(3);
                });
    }
}
