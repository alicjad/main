package Game;

import java.util.List;

public class GameController {
    State state = new State();
    GameObject currentGameObject;
    UserInputHandle userInput = new UserInputHandle();
    GameBoardCreator gameBoardCreator = new GameBoardCreator();

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void askUserForNextStep()
    {
        currentGameObject = gameBoardCreator.getInitialGameObject();
        //GameObject endDayCommand = new EndDayCommand(currentGameObject);

        while (true) {
            List<GameObject> currentOptions = currentGameObject.getAccessibleObjects();
            //if(currentGameObject.isDisplayEndDayOptionAllowed()) {
          //      currentOptions.add(endDayCommand);
            //}
            currentGameObject.execute(state);
            System.out.println(ANSI_BLUE + "~~ Personal Status ~~");
            System.out.println("Remaining steps: "+state.getSteps());
            System.out.println("Remaining money: "+state.getMoney() + "$");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);

            System.out.println(ANSI_PURPLE+ currentGameObject.getWelcomeMessage() + ANSI_RESET);

            while (true) {
                for (int i = 0; i < currentOptions.size(); ++i) {
                    System.out.print(i + 1);
                    System.out.print(". ");
                    GameObject nextGameObject = currentOptions.get(i);
                    if (nextGameObject.canExecute(state)) {
                        System.out.println(ANSI_GREEN+ nextGameObject.getOptionMessage() +ANSI_RESET );
                    }
                    else {
                        System.out.println(nextGameObject.getOptionMessage());
                    }
                }
                int gameObjectNumber = userInput.askForGameObjectNumber();
                try {
                    GameObject nextGameObject = currentOptions.get(gameObjectNumber - 1);
                    if (nextGameObject.canExecute(state)) {
                        currentGameObject = nextGameObject;
                        break;
                    }
                    else {
                        System.out.println(ANSI_RED+ "You can not choose this option now." + ANSI_RESET);
                    }
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(ANSI_RED+ "There is no option with such number.");
                    System.out.println("Choose another number." + ANSI_RESET);
                }
            }
        }
    }
}
