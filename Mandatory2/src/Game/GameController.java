package Game;

import java.util.List;

/**
 * This class is responsible for the flow of the game.
 */
class GameController {

    //for colors
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_RESET = "\u001B[0m";

    private final State state = new State();
    private final UserInputHandle userInput = new UserInputHandle();
    private final GameBoardCreator gameBoardCreator = new GameBoardCreator();

    /**
     * Operates on variables currentGameObject and nextGameObject.
     * Calls a method to create the map.
     * After user's choice change nextGameObject to currentGameObject and calls execute method on it - if possible.
     * Catches an EndGameException - prints message.
     */
    public void askUserForNextStep() {
        //gets map
        GameObject currentGameObject = gameBoardCreator.getInitialGameObject();
        GameObject previousGameObject = null;

        while (true) {
            List<GameObject> currentOptions = currentGameObject.getAccessibleObjects();
            //adds EndDayCommand to the list - if possible
            if (currentGameObject.isEndDayOptionAllowed()) {
                currentOptions.add(gameBoardCreator.getEndDayCommand());
            }
            try {
                currentGameObject.execute(state, previousGameObject);
            }
            //Ending the game
            catch (GameEndException ex) {
                System.out.println(ANSI_RED + "---> CONGRATULATIONS <---");
                System.out.println("ALL GOALS ACHEIVED! YOU WON!" + ANSI_RESET);
                return;
            }
            //Printing information for user
            printState();

            System.out.println(ANSI_PURPLE + currentGameObject.getWelcomeMessage() + ANSI_RESET);

            while (true) {
                //printing the list
                for (int i = 0; i < currentOptions.size(); ++i) {
                    System.out.print(i + 1);
                    System.out.print(". ");
                    GameObject nextGameObject = currentOptions.get(i);
                    //available options in green
                    if (nextGameObject.canExecute(state, previousGameObject)) {
                        System.out.println(ANSI_GREEN + nextGameObject.getOptionMessage() + ANSI_RESET);
                    } else {
                        System.out.println(nextGameObject.getOptionMessage());
                    }
                }
                int gameObjectNumber = userInput.askForGameObjectNumber();
                //changes nextGameObject to currentGameObject if possible
                try {
                    GameObject nextGameObject = currentOptions.get(gameObjectNumber - 1);
                    if (nextGameObject.canExecute(state, previousGameObject)) {
                        previousGameObject = currentGameObject;
                        currentGameObject = nextGameObject;
                        break;
                    } else {
                        System.out.println(ANSI_RED + "You can not choose this option now." + ANSI_RESET);
                    }
                }
                //catches error from user input
                catch (IndexOutOfBoundsException ex) {
                    System.out.println(ANSI_RED + "There is no option with such number.");
                    System.out.println("Choose another number." + ANSI_RESET);
                }
            }
        }
    }

    private void printState() {
        System.out.println(ANSI_BLUE + "~~~~~~~~~~ Personal Status ~~~~~~~~~~");
        System.out.println("Remaining steps:       " + state.getSteps());
        System.out.println("Remaining money:       " + state.getMoney() + "$");
        System.out.println("Your hunger status:    " + state.getHungerLevel());
        System.out.println("Your happiness status: " + state.getGoalHappinessLevel());
        System.out.println("Day no:                " + state.getDayCounter());
        System.out.println("Rent deadline, day:    " + state.getRentDeadline());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
    }
}
