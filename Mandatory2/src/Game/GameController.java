package Game;

import java.util.List;

public class GameController {
    State state = new State();
    GameObject currentGameObject;
    UserInputHandle userInput = new UserInputHandle();
    GameBoardCreator gameBoardCreator = new GameBoardCreator();

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
            System.out.println("~~ Personal Status ~~");
            System.out.println("Remaining steps: "+state.getSteps());
            System.out.println("Remaining money: "+state.getMoney() + "$");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
            //happiness points or level?
            //hunger points or level?
            //educationPoints and experience points?
            // Should they all be included here?
            System.out.println(currentGameObject.getWelcomeMessage());

            while (true) {
                for (int i = 0; i < currentOptions.size(); ++i) {
                    System.out.print(i + 1);
                    System.out.print(". ");
                    System.out.println(currentOptions.get(i).getOptionMessage());
                }
                int gameObjectNumber = userInput.askForGameObjectNumber();
                try {
                    GameObject nextGameObject = currentOptions.get(gameObjectNumber - 1);
                    if (nextGameObject.canExecute(state)) {
                        currentGameObject = nextGameObject;
                        break;
                    }
                    else {
                        System.out.println("You can not choose this option now.");
                    }
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println("There is no option with such number.");
                    System.out.println("Choose another number.");
                }
            }
        }
    }
}
