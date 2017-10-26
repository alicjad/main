package Buildings;

import Game.GameObject;
import Game.State;

public class Building extends GameObject {
    public void execute(State state){

        state.setSteps(state.getSteps() - this.getNumberOfSteps());
    }
    protected int getNumberOfSteps()
    {
        return 5;
    }
}
