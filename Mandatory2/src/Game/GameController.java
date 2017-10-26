package Game;

import Buildings.City;

import java.util.List;

public class GameController {
    //State state;
    GameObject currentGameObject;
    UserInputHandle userInput = new UserInputHandle();
    GameBoardCreator gameBoardCreator = new GameBoardCreator();

    public void askUserForNextStep()
    {
        currentGameObject = gameBoardCreator.getInitialGameObject();

        while (true) {
            List<GameObject> currentOptions = currentGameObject.getAccessibleObjects();
            System.out.println(currentGameObject.getWelcomeMessage());

            for (int i = 0; i < currentOptions.size(); ++i) {
                System.out.print(i + 1);
                System.out.print(". ");
                System.out.println(currentOptions.get(i).getOptionMessage());
            }
            int gameObjectNumber = userInput.askForGameObjectNumber();
            try {
                currentGameObject = currentOptions.get(gameObjectNumber-1);
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("There is no option with such number.");
                System.out.println("Choose another number.");
            }
        }
    }
}
