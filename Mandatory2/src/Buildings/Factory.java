package Buildings;

import Game.State;

public class Factory extends Building {

    @Override
    public void execute(State state) {
        super.execute(state);
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
        state.setEducationPoints(state.getEducationPoints()+ 10);
    }

    public String getWelcomeMessage()
    {
        return "Welcome to the Factory.";
    }
    public String getOptionMessage(){
        return "Go to Factory.";
    }
}
