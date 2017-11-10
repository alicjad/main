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
    public Boolean canExecute(State state, GameObject previousGameObject) {
        if (previousGameObject == null) {
            return state.getSteps() >= this.getNumberOfSteps();
        }
        if (previousGameObject.isNextObjectForFree()){
            return true;
        }
        else {
            return state.getSteps() >= this.getNumberOfSteps();

        }
    }
    @Override
    public boolean isNextObjectForFree() {
        return false;
    }
    @Override
    public void execute(State state, GameObject previousGameObject) {
        if (previousGameObject == null) {
            state.setSteps(state.getSteps() - this.getNumberOfSteps());
        }
        if (!previousGameObject.isNextObjectForFree()) {
            state.setSteps(state.getSteps() - this.getNumberOfSteps());
        }
    }

    int getNumberOfSteps() {
        return 5;
    }
}
