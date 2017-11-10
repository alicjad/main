package Buildings;

import Game.GameObject;
import Game.State;

/**
 * This class is a superclass for all buildings, it contains main methods for extending classes.
 */
public class Building extends GameObject {
    @Override
    public Boolean isEndDayOptionAllowed() {
        return true;
    }

    @Override
    public Boolean canExecute(State state) {
        if (state.getSteps() < this.getNumberOfSteps()) {
            return false;
        } else {
            return true;
        }
    }

    public void execute(State state) {
        state.setSteps(state.getSteps() - this.getNumberOfSteps());
    }

    protected int getNumberOfSteps() {
        return 5;
    }
}
