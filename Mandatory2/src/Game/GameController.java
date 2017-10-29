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

        while (true) {
            List<GameObject> currentOptions = currentGameObject.getAccessibleObjects();
            currentGameObject.execute(state);
            System.out.println(currentGameObject.getWelcomeMessage());
            System.out.println("Remaining steps: "+state.getSteps());
            System.out.println("Remaining money: "+state.getMoney());

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
