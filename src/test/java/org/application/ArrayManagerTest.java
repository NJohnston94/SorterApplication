package org.application;

import exceptions.InvalidLengthParameterException;
import exceptions.InvalidSizeParameterException;

import managers.ArrayManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayManagerTest {

    @Test
    void doesZeroGiveLengthException() {
        Assertions.assertThrows(InvalidLengthParameterException.class,
                () -> {
            ArrayManager.selectNumberOfValues(0);
        });
    }

    @Test
    void does10_001GiveLengthException() {
        Assertions.assertThrows(InvalidLengthParameterException.class,
                () -> {
            ArrayManager.selectNumberOfValues(10_001);
        });
    }

    @Test
    void doesZeroGiveSizeException() {
        Assertions.assertThrows(InvalidSizeParameterException.class,
                () -> {
            ArrayManager.selectMaximumValue(0);
        });
    }

    @Test
    void does10_001GiveSizeException() {
        Assertions.assertThrows(InvalidSizeParameterException.class,
                () -> {
            ArrayManager.selectMaximumValue(10_001);
        });
    }


}
