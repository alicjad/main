package Buildings;

import Game.GameObject;
import Game.State;

/**
 * The class Home is the only accessible object after using EndDayCommand. It is adding happiness points when user enters home.
 */
public class Home extends Building {

    public void execute(State state, GameObject previousGameObject) {
        super.execute(state, previousGameObject);
        relax(state);
    }

    private void relax(State state) {
        state.setHappinessPoints(state.getHappinessPoints() + 10);
    }

    public String getWelcomeMessage() {
        return "Home sweet home!";
    }

    public String getOptionMessage() {
        return "Go home.";
    }
}
