package Buildings;

import Game.GameObject;
import Game.State;

public class Building extends GameObject {
    @Override
    public Boolean isEndDayOptionAllowed() {
        return true;
    }

    @Override
    public Boolean canExecute(State state) {
        if (state.getSteps() < this.getNumberOfSteps()){
            return false;
        }
        else {
            return true;
        }
    }
    public void execute(State state)
    {
        state.setSteps(state.getSteps() - this.getNumberOfSteps());
    }
    protected int getNumberOfSteps()
    {
        return 5;
    }
}
