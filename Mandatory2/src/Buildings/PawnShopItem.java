package Buildings;
import Game.GameObject;
import Game.State;

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

        state.setSteps(state.getSteps() - this.getNumberOfSteps());
        if (itemStatus == PawnShopItemStatus.ForSale){
            buyItem(state);
        }
        else {
            sellItem(state);
        }
    }

    protected int getNumberOfSteps(){
        return 0;
    }

    private void buyItem (State state){

        state.setMoney(state.getMoney() - this.price);
        state.setHappinessPoints(state.getHappinessPoints() + this.happinessPoints);
        this.itemStatus = PawnShopItemStatus.Sold;
    }

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
