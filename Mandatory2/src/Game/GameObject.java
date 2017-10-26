package Game;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObject{
    protected List<GameObject> accessibleObjectList;

    public GameObject (){
        this.accessibleObjectList = new ArrayList<GameObject>();
    }

    public void execute(State state)
    {

    }

    public void addAccessibleObject(GameObject chosenGameObject){
        this.accessibleObjectList.add(chosenGameObject);
    }

    public List<GameObject> getAccessibleObjects()
    {
        return accessibleObjectList;
    }

    public String getWelcomeMessage()
    {
        return "";
    }

    public String getOptionMessage()
    {
        return "";
    }
}

