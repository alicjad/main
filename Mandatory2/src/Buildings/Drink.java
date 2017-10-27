package Buildings;

import Game.GameObject;
import Game.State;

import java.util.ArrayList;
import java.util.List;

public class Drink extends GameObject {
    protected String name;
    protected int price;

    public Drink(String drinkName, int drinkPrice) {
        this.name = drinkName;
        this.price = drinkPrice;
    }
    //this overriding prevents taking steps when choosing burgers from restaurant menu
    public void execute(State state){

        state.setSteps(state.getSteps() - this.getNumberOfSteps());
    }
    protected int getNumberOfSteps()
    {
        return 0;
    }

    public List<GameObject> getAccessibleObjects() {

        List<GameObject> goToObjectList = new ArrayList<GameObject>();
        goToObjectList.add(new RestaurantMenu());
        goToObjectList.add(new Restaurant());

        return goToObjectList;
    }
    public String getOptionMessage()
    {
        return name+" "+price;
    }
}
