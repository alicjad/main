package Buildings;

import Game.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains a list of items user can find int the pawn shop.
 */
public class PawnShop extends Building {

    public PawnShop() {
        this.addAccessibleObjects(getItems());
    }

    /**
     * This method creates a list of item user can find in the pawn shop. Adds them to the PawnShop's accessibleObjectList.
     *
     * @return list of items
     */
    public List<GameObject> getItems() {

        List<GameObject> items = new ArrayList<GameObject>();
        items.add(new PawnShopItem("plant", 50, 10, PawnShopItemStatus.ForSale, this));
        items.add(new PawnShopItem("book", 70, 12, PawnShopItemStatus.ForSale, this));
        items.add(new PawnShopItem("MP3 player", 200, 18, PawnShopItemStatus.ForSale, this));
        items.add(new PawnShopItem("Bosch fridge", 1000, 26, PawnShopItemStatus.ForSale, this));
        items.add(new PawnShopItem("Samsung TV set", 1200, 30, PawnShopItemStatus.ForSale, this));
        items.add(new PawnShopItem("baby benz MERCEDES car", 5000, 50, PawnShopItemStatus.ForSale, this));

        return items;
    }

    public String getWelcomeMessage() {
        return "Welcome to the Pawn Shop!";
    }

    public String getOptionMessage() {
        return "Go to Pawn Shop.";
    }
}
