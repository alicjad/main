package Buildings;

import Game.GameObject;
import Game.State;

public class EmploymentOffice extends GameObject {

    public void execute(State state)
    {
        state.setSteps(5);
    }

    public String getWelcomeMessage()
    {
        return "Welcome to the Employment Office";
    }
    public String getOptionMessage(){
        return "Go to Employment Office";
    }
}
