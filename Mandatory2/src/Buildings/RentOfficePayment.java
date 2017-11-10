package Buildings;

import Game.GameObject;
import Game.State;

/**
 * This class is responsible for rent payments.
 */
public class RentOfficePayment extends GameObject {

    protected RentOffice parent;
    protected int amount;
    protected int rentDays;

    public RentOfficePayment(RentOffice parent, int amount, int rentDays) {
        this.parent = parent;
        this.amount = amount;
        this.rentDays = rentDays;
        this.addAccessibleObject(this.parent);
    }

    @Override
    public Boolean canExecute(State state) {
        return (state.getMoney() >= amount);
    }

    public void execute(State state) {
        payRent(state);
    }

    /**
     * This method takes money for user and sets rent deadline.
     */
    private void payRent(State state) {

        state.setMoney(state.getMoney() - amount);
        state.setRentDeadline(Math.max(state.getDayCounter(), state.getRentDeadline()) + rentDays);
    }


    public String getOptionMessage() {
        return "Pay rent for " + rentDays + " days for " + amount + "$";
    }
}
