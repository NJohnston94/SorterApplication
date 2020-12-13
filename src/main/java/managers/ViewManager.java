package managers;

import exceptions.InvalidExitSelectionException;
import exceptions.InvalidLengthParameterException;
import exceptions.InvalidSizeParameterException;
import exceptions.InvalidSorterSelectionException;

import java.util.Arrays;

/**
 * The central controller of the application. Manages what the user can
 * see and communicates with other managers in the background.
 */
public class ViewManager {

    /**
     * False by default, set to true if the user chooses to
     * close the application
     */
    private static Boolean exit;

    /**
     * False by default, set to true after user chooses a valid
     * option at the end of the application otherwise they are
     * prompted to try again
     */
    private static Boolean validExit;

    /**
     * Call private methods which call public methods from public classes
     * to set parameters of a random array, choose the method it will be sorted by,
     * see the results and how long it took to achieve the result. The user can then
     * decide if they want to run  the application again with new parameters
     * or close it
     */
    public static void startSorter() {

        do {
            exit = false;

            welcomeMessage();
            showSorterSelection();
            selectSorter();
            selectParameters();
            randomiseArray();
            showUnsortedArray();
            showSortedArray();
            exitSorter();

        } while(!exit);
    }

    /**
     * Welcome message
     */
    private static void welcomeMessage() {

        OutputManager.userMessage("Welcome to the Sort Factory");
        OutputManager.doubleLineSpacing();
    }

    /**
     * Show all available sorter methods.
     */
    private static void showSorterSelection() {
        OutputManager.userMessage("Choose from the following sorters:");
        OutputManager.userMessage("1. Binary Tree Sorter");
        OutputManager.userMessage("2. Bubble Sorter");
        OutputManager.userMessage("3. Collection Sorter");
        OutputManager.userMessage("4. Insertion Sorter");
        OutputManager.userMessage("5. Merge Sorter");
        OutputManager.userMessage("6. Quick Sorter");

        OutputManager.doubleLineSpacing();
    }

    /**
     * User is prompted to choose a sorting method via numbered list.
     * If a valid selection is made, the sorter is selected and a new instance
     * of it is created by SortManager, otherwise the user is prompted to
     * try again
     */
    private static void selectSorter() {

        do {

            try {
                OutputManager.userSelection("Select Sorter by number::  ");
                SortManager.selectSorter(InputManager.getUserInput());
            } catch (InvalidSorterSelectionException e) {
                OutputManager.logger.debug(e.toString());
                OutputManager.doubleLineSpacing();
            }

        } while (SortManager.sorter == null);

        OutputManager.userMessage("You have selected " + SortManager.sorter.getSorterName());
        OutputManager.doubleLineSpacing();
    }

    /**
     * Call methods which each handle user input to set parameters of
     * the random array to be generated
     */
    private static void selectParameters() {

        selectNumberOfValues();
        selectMaximumValue();
    }

    /**
     * User is prompted to enter a number which will be the length of the array.
     * The array can have a length 2 - 10,000 integers, if the user selects a
     * number outside of these bounds they will be prompted to try again.
     */
    private static void selectNumberOfValues() {

        do {
            try {
                OutputManager.userSelection("How many integers would you like to sort?::  ");
                ArrayManager.selectNumberOfValues(InputManager.getUserInput());
            } catch (InvalidLengthParameterException e) {
                OutputManager.logger.debug(e.toString());
                OutputManager.doubleLineSpacing();
            }

        } while (!ArrayManager.isValidValue);

        ArrayManager.isValidValue = false;
        OutputManager.doubleLineSpacing();

    }

    /**
     * User is prompted to enter a number which will be the maximum value of a
     * randomly generated integer. An integer can have a value 2 - 10,000.
     * If the user selects a number outside of these bounds they
     * will be prompted to try again.
     */
    private static void selectMaximumValue() {

        do {
            try {
                OutputManager.userSelection("What should the maximum value of any integer be?::  ");
                ArrayManager.selectMaximumValue(InputManager.getUserInput());
            } catch (InvalidSizeParameterException e) {
                OutputManager.logger.debug(e.toString());
                OutputManager.doubleLineSpacing();
            }

        } while (!ArrayManager.isValidValue);

        ArrayManager.isValidValue = false;
        OutputManager.doubleLineSpacing();

    }

    /**
     * Randomise the array via Array Manager. This method purely improves readability
     * of startSorter().
     */
    private static void randomiseArray() {
        ArrayManager.unsortedArray = ArrayManager.randomArray(ArrayManager.numberOfValuesToSort,
                                                              ArrayManager.maximumValue);

    }

    /**
     * Display the unsorted array and wait for the user to press a key before sorting the array.
     */
    private static void showUnsortedArray() {

        OutputManager.userMessage("The following array will be sorted::  " + Arrays.toString(ArrayManager.unsortedArray));
        OutputManager.userMessage("Press any key to start.");

        try{
            System.in.read(); //won't compile without exception handling
        }catch(Exception e){
            e.printStackTrace();
        }

        OutputManager.doubleLineSpacing();
    }

    /**
     * Display the sorted array and how long it took to sort.
     */
    private static void showSortedArray() {

        ArrayManager.sortedArray = SortManager.timedArraySort();
        OutputManager.userMessage("The array has been sorted::  " + Arrays.toString(ArrayManager.sortedArray));
        OutputManager.userMessage("It took " + SortManager.sortTime + SortManager.timeUnits + " to sort the array");
        OutputManager.doubleLineSpacing();
    }

    /**
     * Prompt the user to select an option which will either exit the
     * application or run it again, where the user can select new parameters.
     * If the user doesn't select a valid option they will be prompted to
     * try again.
     */
    private static void exitSorter() {
        OutputManager.userMessage("What would you like to do now?");
        OutputManager.userMessage("1. Close application");
        OutputManager.userMessage("2. Sort again");
        OutputManager.doubleLineSpacing();
        do {
            try {
                OutputManager.userSelection("Select option by number:: ");
                OutputManager.doubleLineSpacing();
                isExit(InputManager.getUserInput());
            }catch (InvalidExitSelectionException e) {
                OutputManager.logger.debug(e.toString());
                OutputManager.doubleLineSpacing();
            }
        } while(!validExit);

    }

    /**
     * Check if the user has selected a valid exit option.
     *
     * @param userInput Scanner reads the next integer input by the user.
     * @throws InvalidExitSelectionException Thrown if the user doesn't choose 1 or 2.
     */
    public static void isExit(int userInput) throws InvalidExitSelectionException {
        if(userInput < 1 || userInput > 2){
            validExit = false;
            throw new InvalidExitSelectionException();
        }
        else if(userInput == 1) {
            validExit = true;
            exit = true;
        }
        else {
            validExit = true;
            exit = false;
        }
    }

}
