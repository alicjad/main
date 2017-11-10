package Buildings;

/**
 * The class Extra represents an extra type of food in the RestaurantMenu.
 */
public class Extra extends Food {

    public Extra(String name, int price, int hungerPoints, int happinessPoints, RestaurantMenu parent) {
        super(name, price, hungerPoints, happinessPoints, parent);
    }

}
