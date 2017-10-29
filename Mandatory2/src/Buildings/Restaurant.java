package Buildings;

import Game.GameObject;

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends Building{
    @Override
    public List<GameObject> getAccessibleObjects() {

        List<GameObject> accessibleObjectList2 = new ArrayList<GameObject>();
        accessibleObjectList2.add(new RestaurantMenu(this));
        accessibleObjectList2.addAll(super.getAccessibleObjects());

        return accessibleObjectList2;
    }

    public String getWelcomeMessage()
        {
            return "Welcome to the Burger Palace restaurant!";
        }
    public String getOptionMessage(){
            return "Go to Burger Palace";
        }

}
