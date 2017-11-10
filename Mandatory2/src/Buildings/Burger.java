package Buildings;
/**
 * The class Burger represents burgers in the RestaurantMenu.
 */
public class Burger extends Food {

    public Burger(String name, int price, int hungerPoints, int happinessPoints, RestaurantMenu parent) {
        super(name + " Burger", price, hungerPoints, happinessPoints, parent);
    }
}
