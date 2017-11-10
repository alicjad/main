package BuildingCommands;

import Buildings.PawnShop;
import Enums.PawnShopItemStatus;
import Game.GameObject;
import Game.State;

/**
 * This class contains methods for buying and selling pawn shop items.
 */
public class PawnShopItem extends GameObject {

    private final String name;
    private final int price;
    private final int happinessPoints;
    private PawnShopItemStatus itemStatus;

    public PawnShopItem(String name, int price, int happinessPoints, PawnShopItemStatus itemStatus, PawnShop parent) {
        this.name = name;
        this.price = price;
        this.happinessPoints = happinessPoints;
        this.itemStatus = itemStatus;
        this.addAccessibleObject(parent);
    }

    @Override
    public Boolean canExecute(State state, GameObject previousGameObject) {
        return this.itemStatus != PawnShopItemStatus.ForSale || state.getMoney() >= this.price && (this.itemStatus != PawnShopItemStatus.Sold || state.getHappinessPoints() >= this.happinessPoints / 2);
    }

    @Override
    public void execute(State state, GameObject previousGameObject) {

        if (itemStatus == PawnShopItemStatus.ForSale) {
            buyItem(state);
        } else {
            sellItem(state);
        }
    }

    /**
     * This method allows the user to buy the item.
     * Marks chosen item as sold.
     */
    private void buyItem(State state) {

        state.setMoney(state.getMoney() - this.price);
        state.setHappinessPoints(state.getHappinessPoints() + this.happinessPoints);
        this.itemStatus = PawnShopItemStatus.Sold;
    }

    /**
     * This method allows the user to sell the item.
     * Marks chosen item as for sale.
     */
    private void sellItem(State state) {

        state.setMoney(state.getMoney() + this.price / 2);
        state.setHappinessPoints(state.getHappinessPoints() - this.happinessPoints / 2);
        this.itemStatus = PawnShopItemStatus.ForSale;
    }

    public String getOptionMessage() {

        if (this.itemStatus == PawnShopItemStatus.ForSale) {
            return "Buy " + name + " for " + price + "$ and gain " + happinessPoints + " happiness points!";
        } else {
            return "Sell " + name + " for " + (price / 2) + "$ with lost of " + (happinessPoints / 2) + "happiness points!";
        }

    }
}
