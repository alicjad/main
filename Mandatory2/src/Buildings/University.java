package Buildings;

import Game.GameObject;
import Game.State;

public class University extends GameObject {

    public void execute(State state)
    {
        state.setSteps(5);
    }

    public String getWelcomeMessage()
    {
        return "Welcome to the University!";
    }
    public String getOptionMessage(){
        return "Go to University";
    }
}
