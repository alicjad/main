package Buildings;

import Game.GameObject;
import Game.State;

public class Restaurant extends GameObject{

        public void execute(State state)
        {
            state.setSteps(5);
        }

        public String getWelcomeMessage()
        {
            return "Welcome to the Burger Palace restaurant!";
        }
        public String getOptionMessage(){
            return "Go to Burger Palace";
        }

}
