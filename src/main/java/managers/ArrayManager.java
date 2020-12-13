package managers;

import exceptions.InvalidLengthParameterException;
import exceptions.InvalidSizeParameterException;
import java.util.Random;

/**
 * Accept input values from the user to generate an array of
 * random integers. The array can have a length 2 - 10,000.
 * Any integer can have a value 2 -10,000.
 */
public class ArrayManager {

    /**
     * Array of unsorted values
     */
    public static int[]     unsortedArray;

    /**
     * Array of sorted values
     */
    public static int[]     sortedArray;

    /**
     * User-set length of array
     */
    public static int       numberOfValuesToSort = 0;

    /**
     * User-set maximum value of an integer
     */
    public static int       maximumValue         = 0;

    /**
     * Checks the user has made valid inputs. False by default,
     * true when the user has made a valid input.
     */
    public static boolean   isValidValue         = false;

    /**
     * Generate a random array of a fixed number of integers; each integer has a maximum value.
     * @param numberOfValuesToSort  The size of the array.
     * @param maximumValue          The maximum value any integer can have.
     * @return                      The random, unsorted array.
     */
    public static int[] randomArray(int numberOfValuesToSort, int maximumValue) {

        Random random = new Random();
        unsortedArray = new int[numberOfValuesToSort];

        for (int i = 0; i < numberOfValuesToSort; i++) {
            unsortedArray[i] = random.nextInt(maximumValue + 1);
        }

        return unsortedArray;
    }

    /**
     * Accepts user input for length of array. Throws exception for an invalid input.
     * @param userInput user input
     * @throws InvalidLengthParameterException Thrown if value outside 2 - 10,000 is input
     */
    public static void selectNumberOfValues(int userInput) throws InvalidLengthParameterException {

        if (userInput < 2 || userInput > 10_000) {

            OutputManager.logger.debug("InvalidLengthParameterException thrown");
            throw new InvalidLengthParameterException();

        } else {

            isValidValue = true;
            numberOfValuesToSort = userInput;
        }
    }

    /**
     * Accepts user input for length of array. Throws exception for an invalid input.
     * @param userInput user input
     * @throws InvalidSizeParameterException Thrown if value outside 2 - 10,000 is input
     */
    public static void selectMaximumValue(int userInput) throws InvalidSizeParameterException {

        if (userInput < 2 || userInput > 10_000) {

            OutputManager.logger.debug("InvalidSizeParameterException thrown");
            throw new InvalidSizeParameterException();

        } else {

            isValidValue = true;
            maximumValue = userInput;
        }
    }

}
