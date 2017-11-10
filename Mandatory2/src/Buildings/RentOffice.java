package Buildings;

import Game.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows the user to choose from rent payment option.
 */
public class RentOffice extends Building {

    public RentOffice() {
        this.addAccessibleObjects(getAvailableOptions());
    }

    protected int getNumberOfSteps() {
        return 5;
    }

    /**
     * This method adds possible rent payments to the RentOffice's accessibleObjects.
     *
     * @return list of options to choose from when entering RentOffice.
     */
    private List<GameObject> getAvailableOptions() {

        List<GameObject> availableOptions = new ArrayList<>();
        availableOptions.add(new RentOfficePayment(this, 550, 7));
        availableOptions.add(new RentOfficePayment(this, 900, 14));
        availableOptions.add(new RentOfficePayment(this, 1800, 30));

        return availableOptions;
    }

    public String getWelcomeMessage() {
        return "Welcome to the Rent Office!";
    }

    public String getOptionMessage() {
        return "Go to Rent Office.";
    }
}
