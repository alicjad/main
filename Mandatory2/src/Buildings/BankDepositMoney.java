package Buildings;

import Game.GameObject;
import Game.State;

/**
 * This class is responsible for depositMoney function.
 */
public class BankDepositMoney extends GameObject {
    private final Bank parent;
    private final int amount;

    public BankDepositMoney(Bank parent, int amount) {
        this.parent = parent;
        this.amount = amount;
        this.addAccessibleObject(this.parent);
    }

    @Override
    public Boolean canExecute(State state) {
        return state.getMoney() >= amount;
    }

    public void execute(State state) {
        this.depositMoney(state);
    }

    private void depositMoney(State state) {
        state.setMoney(state.getMoney() - amount);
        parent.setBalance(parent.getBalance() + amount);
    }

    public String getOptionMessage() {
        return "Deposit " + amount + " $";
    }
}
