package Game;

import Buildings.City;
import Buildings.Restaurant;

import java.util.List;

public class GameController {
    State state;
    GameObject currentGameObject;

    public void askUserForNextStep()
    {
        currentGameObject = new City("Wasteland");

        List<GameObject> currentOptions = currentGameObject.getAccessibleObjects();

        System.out.println(currentGameObject.getWelcomeMessage());

        for (int i = 0; i< currentOptions.size(); ++i){
            System.out.print(i+1);
            System.out.print(" ");
            System.out.println(currentOptions.get(i).getOptionMessage());
        }
        // wczytaj int
        //zamien int na gameobject uzywajac currentOptions, przypisz n-ty element z currentOptions do currentGameObject
    }
}
