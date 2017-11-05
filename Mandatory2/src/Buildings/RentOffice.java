package Buildings;

import Game.GameObject;

import java.util.ArrayList;
import java.util.List;

public class RentOffice extends Building {

    protected int getNumberOfSteps()
    {
        return 5;
    }

    public List<GameObject> getAccessibleObjects() {

        List<GameObject> availableOptions = new ArrayList<GameObject>();
        availableOptions.add(new RentOfficePayment(this, 550, 7));
        availableOptions.add(new RentOfficePayment(this, 900, 14));
        availableOptions.add(new RentOfficePayment(this, 1800, 30));
        availableOptions.addAll(super.getAccessibleObjects());

        return availableOptions;
    }

    public String getWelcomeMessage()
    {
        return "Welcome to the Rent Office!";
    }
    public String getOptionMessage(){
        return "Go to Rent Office.";
    }
}
