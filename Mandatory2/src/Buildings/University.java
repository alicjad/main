package Buildings;

import Game.GameObject;
import Game.State;

import java.util.ArrayList;
import java.util.List;

public class University extends GameObject {

    String name;
    GameObject parent;

    public void execute(State state)
    {
        state.setSteps(5);
    }

    public University (String name, GameObject parent)
    {
        this.name = name;
        this.parent = parent;
    }

    public List<GameObject> getAccessibleObjects()
    {
        List<GameObject> list = new ArrayList<GameObject>();
        list.add(parent);
        return list;
    }

    public String getWelcomeMessage()
    {
        return "Welcome to the "+name+ ".";
    }
    public String getOptionMessage(){
        return "Go to "+name;
    }
}
