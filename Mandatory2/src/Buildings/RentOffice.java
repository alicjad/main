package Buildings;

import Game.GameObject;
import Game.State;

public class RentOffice extends GameObject {

    public void execute(State state)
    {
        state.setSteps(5);
    }

    public String getWelcomeMessage()
    {
        return "Welcome to the Rent Office!";
    }
    public String getOptionMessage(){
        return "Go to Rent Office";
    }
}
