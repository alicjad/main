package Buildings;

import Game.State;

public class EmploymentOffice extends Building {

    @Override
    protected int getNumberOfSteps() {
        return 4;
    }

    @Override
    public void execute(State state) {
        super.execute(state);
        state.setMoney(state.getMoney()+ getAmountOfMoney());

    }

    public int getAmountOfMoney(){
        return 10;
   }

    public String getWelcomeMessage()
    {
        return "Welcome to the Employment Office";
    }
    public String getOptionMessage(){
        return "Go to Employment Office";
    }
}
