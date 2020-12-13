package managers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Handle output messages and instructions issued to user via Console.
 */
public class OutputManager {

    /**
     * Logger (log4j) used for debug and exception error messages.
     */
    public static final Logger logger = LogManager.getLogger(OutputManager.class);

    /**
     * Used to display information and options to the user.
     * @param userMessage message to the user.
     */
    public static void userMessage(String userMessage) {

        System.out.println(userMessage);
    }

    /**
     * Used after an instruction to the user, so their input can
     * be made on the same line as the instruction.
     * @param userSelection prompt for the user.
     */
    public static void userSelection(String userSelection) {

        System.out.print(userSelection);
    }

    /**
     * Shortcut for adding two line spaces between messages
     */
    public static void doubleLineSpacing() {

        System.out.println(" ");
        System.out.println(" ");

    }

}
