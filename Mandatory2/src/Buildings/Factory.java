package Buildings;

import Game.GameObject;
import Game.State;

import java.util.ArrayList;
import java.util.List;

public class Factory extends Building {

    @Override
    public Boolean canExecute(State state) {
        if (state.getSteps() < this.getNumberOfSteps()){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void execute(State state) {
        work(state);
    }

    public int getAmountOfMoney(State state){
        int amount = state.currentOccupation.getHourlyWage();
        return amount;
    }
    protected int getNumberOfSteps()
    {
        return 10;
    }

    private void work(State state){
        state.setSteps(state.getSteps() - this.getNumberOfSteps());
        state.setMoney(state.getMoney()+ getAmountOfMoney(state));
        state.setExperiencePoints(state.getExperiencePoints()+ 10);
        state.setHappinessPoints(state.getHappinessPoints()- 10);
    }
    public List<GameObject> getAccessibleObjects() {

        List<GameObject> goToObjectList = new ArrayList<GameObject>();

        goToObjectList.addAll(accessibleObjectList);
        goToObjectList.add(this);

        return goToObjectList;
    }

    public String getWelcomeMessage()
    {
        return "Welcome to the Factory.";
    }
    public String getOptionMessage(){
        return "Go to Factory.";
    }
}
