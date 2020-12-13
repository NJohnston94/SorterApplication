package managers;

import java.util.Scanner;

/**
 * Take user inputs via Scanner object.
 */
public class InputManager {

    /**
     * Scanner object to read user input.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * In this application, the only valid user inputs are integers.
     * Any other input characters are ignored by default, now.
     * @return The integer input by the user
     */
    public static int getUserInput() {

        return scanner.nextInt();
    }

}
