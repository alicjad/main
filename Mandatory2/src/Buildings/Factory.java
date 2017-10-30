package Buildings;

import Game.State;

public class Factory extends Building {

    protected int workCounter;

    @Override
    public void execute(State state) {
        super.execute(state);
        work(state);
    }
    public int getAmountOfMoney(State state){
        return state.getCurrentOccupation().hourlyWage;
    }
    protected int getNumberOfSteps()
    {
        return 10;
    }

    private void work(State state){
        state.setSteps(state.getSteps() - this.getNumberOfSteps());
        state.setMoney(state.getMoney()+ getAmountOfMoney(state));
        if (workCounter == 5){
            state.currentOccupation.experienceStatus = WorkExperienceStatus.quiteExperienced;
        }
        if (workCounter > 5 && workCounter >= 10){
            state.currentOccupation.experienceStatus = WorkExperienceStatus.veryExperienced;
        }
    }

    public String getWelcomeMessage()
    {
        return "Welcome to the Factory.";
    }
    public String getOptionMessage(){
        return "Go to Factory.";
    }
}
