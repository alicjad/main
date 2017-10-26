package Buildings;

import Game.GameObject;
import Game.State;

public class Home extends GameObject {

    public void execute(State state)
    {
        state.setSteps(5);
    }

    public String getWelcomeMessage()
    {
        return "Home sweet home!";
    }
    public String getOptionMessage(){
        return "Go home.";
    }
}
