package Buildings;

import Game.GameObject;
import Game.State;

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends GameObject{

        String name;
        GameObject parent;

        public void execute(State state)
        {
            state.setSteps(5);
        }

        public Restaurant(String name, GameObject parent)
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
            return "Welcome to the "+name+ " restaurant.";
        }
        public String getOptionMessage(){
            return "Go to "+name;
        }

}
