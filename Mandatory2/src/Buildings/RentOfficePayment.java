package Buildings;
import Game.GameObject;
import Game.State;

public class RentOfficePayment extends GameObject {

    protected RentOffice parent;
    protected int amount;
    protected int rentDays;

    public RentOfficePayment (RentOffice parent, int amount, int rentDays){
        this.parent = parent;
        this.amount = amount;
        this.rentDays = rentDays;
        this.addAccessibleObject(this.parent);
    }

    @Override
    public Boolean canExecute(State state){

        if (state.getMoney() < amount){
            return false;
        }
        else {
            return true;
        }
    }
    public void execute(State state){

        state.setSteps(state.getSteps() - this.getNumberOfSteps());
        payRent(state);
    }
    protected int getNumberOfSteps(){
        return 0;
    }

    private void payRent (State state){

        state.setMoney(state.getMoney() - amount);
        state.setRentDeadline(state.getRentDeadline()+rentDays);
    }

    public String getOptionMessage(){
        return "Pay rent for "+rentDays+" days for "+amount+"$";
    }
}
