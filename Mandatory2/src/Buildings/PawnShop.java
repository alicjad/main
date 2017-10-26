package Buildings;

import Game.GameObject;
import Game.State;

public class PawnShop extends GameObject {

    public void execute(State state)
    {
        state.setSteps(5);
    }

    public String getWelcomeMessage()
    {
        return "Welcome to the Pawn Shop!";
    }
    public String getOptionMessage(){
        return "Go to Pawn Shop";
    }
}
