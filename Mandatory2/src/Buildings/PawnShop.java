package Buildings;

import Game.GameObject;

import java.util.ArrayList;
import java.util.List;

public class PawnShop extends Building {
    public PawnShop(){
        this.setItems(items); ;
    }

    public List<GameObject> items = new ArrayList<GameObject>();

    public void setItems(List<GameObject> items) {
        items.add(new PawnShopItem("plant", 50, 10, PawnShopItemStatus.ForSale, this));
        items.add(new PawnShopItem("book", 70, 12, PawnShopItemStatus.ForSale, this));
        items.add(new PawnShopItem("MP3 player", 200, 18, PawnShopItemStatus.ForSale, this));
        items.add(new PawnShopItem("Bosh fridge", 1000, 26, PawnShopItemStatus.ForSale, this));
        items.add(new PawnShopItem("Samsung TV set", 1200, 30, PawnShopItemStatus.ForSale, this));
        items.add(new PawnShopItem("baby benz MERCEDES car", 5000, 50, PawnShopItemStatus.ForSale, this));
    }

    public List<GameObject> getAccessibleObjects() {

        List<GameObject> availableOptions = new ArrayList<GameObject>();
        availableOptions.addAll(this.getItems());
        availableOptions.addAll(super.getAccessibleObjects());

        return availableOptions;
    }

    public List<GameObject> getItems() {
        return items;
    }

    public String getWelcomeMessage()
    {
        return "Welcome to the Pawn Shop!";
    }
    public String getOptionMessage(){
        return "Go to Pawn Shop.";
    }
}
