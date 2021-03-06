package BuildingCommands;

/**
 * The class Burger represents burgers in the RestaurantMenu.
 */
class Burger extends Food {

    public Burger(String name, int price, int hungerPoints, int happinessPoints, RestaurantMenu parent) {
        super(name + " Burger", price, hungerPoints, happinessPoints, parent);
    }
}
