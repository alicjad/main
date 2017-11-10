package Buildings;

import Game.GameObject;
import Game.State;

/**
 * The class Food determine conditions and requirements for all food extending game objects classes. It is a superclass.
 */
public class Food extends GameObject {

    private final String name;
    private final int price;
    private final int hungerPoints;
    private final int happinessPoints;

    Food(String name, int price, int hungerPoints, int happinessPoints, RestaurantMenu parent) {
        this.name = name;
        this.price = price;
        this.hungerPoints = hungerPoints;
        this.happinessPoints = happinessPoints;
        this.addAccessibleObject(parent);
    }

    @Override
    public Boolean canExecute(State state) {
        return (state.getMoney() >= this.price);
    }

    public void execute(State state) {
        state.setMoney(state.getMoney() - this.price);
        state.setHungerPoints(state.getHungerPoints() + hungerPoints);
        state.setHappinessPoints(state.getHappinessPoints() + happinessPoints);
    }

    public String getOptionMessage() {
        return name + " for " + price + "$"; //--> get "+hungerPoints+" hunger points and "+happinessPoints+" happiness points!";
    }
}
