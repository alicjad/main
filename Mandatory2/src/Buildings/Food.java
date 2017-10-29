package Buildings;

import Game.GameObject;
import Game.State;

import java.util.ArrayList;
import java.util.List;

public class Food extends GameObject {

    protected String name;
    protected int price;
    protected RestaurantMenu parent;

    public Food(String name, int price, RestaurantMenu parent) {
        this.name = name;
        this.price = price;
        this.parent = parent;
    }
    public void execute(State state){
        state.setSteps(state.getSteps() - this.getNumberOfSteps());
    }
    protected int getNumberOfSteps()
    {
        return 0;
    }

    public List<GameObject> getAccessibleObjects() {

        List<GameObject> goToObjectList = new ArrayList<GameObject>();
        goToObjectList.add(parent);

        return goToObjectList;
    }
    public String getOptionMessage()
    {
        return name+" "+price;
    }
}
