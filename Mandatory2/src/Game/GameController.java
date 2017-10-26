package Game;

import Buildings.City;

import java.util.List;

public class GameController {
    State state;
    GameObject currentGameObject;
    UserInputHandle userInput;

    public void askUserForNextStep()
    {
        currentGameObject = new City("Wasteland");

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
                break;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("There is no option with such number.");
                System.out.println("Choose another number.");
            }
        }
    }
        // wczytaj int
        //zamien int na gameobject uzywajac currentOptions, przypisz n-ty element z currentOptions do currentGameObject
}
