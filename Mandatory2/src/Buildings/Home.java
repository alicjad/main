package Buildings;

import Game.State;

public class Home extends Building {
    public void execute(State state) {
        super.execute(state);
        relax(state);
    }

    private void relax(State state){
        state.setHappinessPoints(state.getHappinessPoints()+ 10);
    }

    public String getWelcomeMessage()
    {
        return "Home sweet home!";
    }
    public String getOptionMessage(){
        return "Go home.";
    }
}
