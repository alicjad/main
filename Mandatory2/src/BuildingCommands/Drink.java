package BuildingCommands;

/**
 * The class Drink represents an drinks in the RestaurantMenu.
 */
class Drink extends Food {

    public Drink(String name, int price, int hungerPoints, int happinessPoints, RestaurantMenu parent) {
        super(name, price, hungerPoints, happinessPoints, parent);
    }

}
