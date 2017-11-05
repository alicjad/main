package Game;

public class EndDayCommand extends GameObject {

    @Override
    public Boolean canExecute(State state) {
        return true;
    }

    public void execute(State state){
        state.setSteps(state.getSteps() - this.getNumberOfSteps());
        //checkGoals - return boolean - if true - winGameMessage/endProgram - if false go to next method (startNewDay)
        startNewDay(state);
    }

    private void startNewDay (State state){
        state.setSteps(getNumberOfNextDaySteps(state));
        if (state.getHappinessLevel() == HappinessStateStatus.notHappy){
            state.setSteps(state.getSteps() - 10);
        }
        if (state.getHappinessLevel() == HappinessStateStatus.depressed){
            state.setSteps(state.getSteps() - 20);
        }
        state.setDayCounter(state.getDayCounter() + 1);
    }
    protected int getNumberOfSteps()
    {
        return 0;
    }

    protected int getNumberOfNextDaySteps(State state){
        if (state.getHungerLevel() == HungerStateStatus.Full){
            return 155;
        }
        if (state.getHungerLevel() == HungerStateStatus.quiteFull){
            return 145;
        }
        if (state.getHungerLevel() == HungerStateStatus.notHungry){
            return 125;
        }
        if (state.getHungerLevel() == HungerStateStatus.hungry){
            return 105;
        }
        if (state.getHungerLevel() == HungerStateStatus.veryHungry){
            return 75;
        }
        else {
            return 45;
        }
    }

    public String getWelcomeMessage()
    {
        return "Ending day...";
    }
    public String getOptionMessage(){
        return "End Day.";
    }
}
