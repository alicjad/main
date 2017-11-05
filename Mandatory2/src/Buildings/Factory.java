package Buildings;

import Game.GameObject;
import Game.State;

public class Factory extends Building {
    public Factory()
    {
        this.addAccessibleObject(this);
    }
    @Override
    public Boolean canExecute(State state) {
        if (state.getSteps() < this.getNumberOfSteps() || state.currentOccupation == null && state.getSteps() < 5){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void execute(State state) {
        if (state.currentOccupation == null){
            super.execute(state);
        }
        else {
            work(state);
        }
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
        state.setHungerPoints(state.getHungerPoints() - 5);
    }

    public String getWelcomeMessage()
    {
        return "Welcome to the Factory.";
    }
    public String getOptionMessage(){
        return "Go to Factory.";
    }
}
