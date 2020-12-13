package org.application;

import managers.ViewManager;

/**
 * Sorter Application
 *
 * Select a sorting method, select parameters for generation
 * of a random array, then see the sorted array and how long
 * it took the chosen method to sort the array.
 */
public class App {

    /**
     * Call a single method from the ViewManager which is the
     * application's central controller.
     * @param args args are null
     */
    public static void main(String[] args) {

        ViewManager.startSorter();

    }
}
