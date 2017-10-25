package Game;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObject{
    public void execute(State state)
    {

    }

    public List<GameObject> getAccessibleObjects()
    {
        return new ArrayList<GameObject>();
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

