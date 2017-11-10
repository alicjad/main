package Buildings;
import Game.GameObject;
import Game.State;

public class Food extends GameObject {

    protected String name;
    protected int price;
    protected int hungerPoints;
    protected int happinessPoints;

    public Food (String name, int price, int hungerPoints, int happinessPoints, RestaurantMenu parent) {
        this.name = name;
        this.price = price;
        this.hungerPoints = hungerPoints;
        this.happinessPoints = happinessPoints;
        this.addAccessibleObject(parent);
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
    protected int getNumberOfSteps(){
        return 0;
    }

    public String getOptionMessage(){
        return name+" for "+price+"$"; //--> get "+hungerPoints+" hunger points and "+happinessPoints+" happiness points!";
    }
}
