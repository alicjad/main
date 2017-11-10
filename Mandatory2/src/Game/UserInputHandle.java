package Game;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It is responsible for displaying the menu and handling the user input.
 */
class UserInputHandle {
    /**
     * Waits for user to hit Enter.
     */
    public void pressEnterToContinue() {
        System.out.println("Press Enter to continue");
        Scanner k = new Scanner(System.in);
        k.nextLine();
    }

    /**
     * Gets integer form user.
     *
     * @return integer from user.
     */
    public int getIntFromUser() {
        while (true) {
            try {
                Scanner a = new Scanner(System.in);
                return a.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("This is not a number");
                System.out.println("Try again");
            }
        }
    }

    /**
     * Asks the user in which object(=option) he is interested in
     *
     * @return number of object user wants to choose.
     */
    public int askForGameObjectNumber() {
        System.out.println("Type your number: ");
        return getIntFromUser();
    }
}
