package BuildingCommands;

/**
 * The class Extra represents an extra type of food in the RestaurantMenu.
 */
class Extra extends Food {

    public Extra(String name, int price, int hungerPoints, int happinessPoints, RestaurantMenu parent) {
        super(name, price, hungerPoints, happinessPoints, parent);
    }

}
