package Buildings;
import Game.GameObject;
import Game.State;
/**
 * This class contains methods for buying and selling pawn shop items.
 */
public class PawnShopItem extends GameObject {

    protected String name;
    protected int price;
    protected int happinessPoints;
    protected PawnShopItemStatus itemStatus;
    protected PawnShop parent;

    public PawnShopItem (String name, int price, int happinessPoints, PawnShopItemStatus itemStatus, PawnShop parent){
        this.name = name;
        this.price = price;
        this.happinessPoints = happinessPoints;
        this.itemStatus = itemStatus;
        this.parent = parent;
        this.addAccessibleObject(parent);
    }

    @Override
    public Boolean canExecute(State state) {
        if (this.itemStatus == PawnShopItemStatus.ForSale && state.getMoney() < this.price){
            return false;
        }
        if (this.itemStatus == PawnShopItemStatus.Sold && state.getHappinessPoints() < this.happinessPoints/2){
            return false;
        }
        else {
            return true;
        }
    }

    public void execute(State state){

        if (itemStatus == PawnShopItemStatus.ForSale){
            buyItem(state);
        }
        else {
            sellItem(state);
        }
    }
    /**
     * This method allows the user to buy the item.
     * Marks chosen item as sold.
     */
    private void buyItem (State state){

        state.setMoney(state.getMoney() - this.price);
        state.setHappinessPoints(state.getHappinessPoints() + this.happinessPoints);
        this.itemStatus = PawnShopItemStatus.Sold;
    }
    /**
     * This method allows the user to sell the item.
     * Marks chosen item as for sale.
     */
    private void sellItem (State state){

        state.setMoney(state.getMoney() + this.price/2);
        state.setHappinessPoints(state.getHappinessPoints() - this.happinessPoints/2);
        this.itemStatus = PawnShopItemStatus.ForSale;
    }

    public String getOptionMessage(){

        if (this.itemStatus == PawnShopItemStatus.ForSale){
            return "Buy "+ name + " for "+price+"$ and gain "+happinessPoints+" happiness points!";
        }
        else {
            return "Sell "+name+" for "+(price/2)+"$ with lost of "+(happinessPoints/2)+"happiness points!";
        }

    }
}
