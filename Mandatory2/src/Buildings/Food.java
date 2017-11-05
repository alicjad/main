package Buildings;

import Game.GameObject;
import Game.State;

import java.util.ArrayList;
import java.util.List;

public class Food extends GameObject {

    protected String name;
    protected int price;
    protected int hungerPoints;
    protected int happinessPoints;
    protected RestaurantMenu parent;

    public Food(String name, int price, int hungerPoints, int happinessPoints, RestaurantMenu parent) {
        this.name = name;
        this.price = price;
        this.hungerPoints = hungerPoints;
        this.happinessPoints = happinessPoints;
        this.parent = parent;
    }

    @Override
    public Boolean canExecute(State state) {
        if (state.getMoney() < this.price){
            return false;
        }
        else {
            return true;
        }
    }

    public void execute(State state){
        state.setSteps(state.getSteps() - this.getNumberOfSteps());
        state.setMoney(state.getMoney() - this.price);
        state.setHungerPoints(state.getHungerPoints() + hungerPoints);
        state.setHappinessPoints(state.getHappinessPoints() + happinessPoints);
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
        return name+" for "+price+"$"; //--> get "+hungerPoints+" hunger points and "+happinessPoints+" happiness points!";
    }
}
