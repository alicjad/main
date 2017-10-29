package Buildings;

public class Burger extends Food {

    public Burger(String name, int price, RestaurantMenu parent) {
        super(name + " Burger", price, parent);
    }
}
