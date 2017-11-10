package Buildings;

import BuildingCommands.RestaurantMenu;

/**
 * This class contains restaurant menu.
 */
public class Restaurant extends Building {

    public Restaurant() {
        this.addAccessibleObject(new RestaurantMenu(this));
    }

    public String getWelcomeMessage() {
        return "Welcome to the Burger Palace restaurant!";
    }

    public String getOptionMessage() {
        return "Go to Burger Palace.";
    }

}
