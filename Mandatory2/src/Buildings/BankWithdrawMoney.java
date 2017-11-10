package Buildings;

import Game.GameObject;
import Game.State;

/**
 * This class is responsible for withdrawMoney function.
 */
public class BankWithdrawMoney extends GameObject {
    protected Bank parent;
    protected int amount;

    public BankWithdrawMoney(Bank parent, int amount) {
        this.parent = parent;
        this.amount = amount;
        this.addAccessibleObject(this.parent);
    }

    @Override
    public Boolean canExecute(State state) {
        return (parent.getBalance() >= amount);
    }

    public void execute(State state) {
        this.withdrawMoney(state);

    }

    private void withdrawMoney(State state) {
        state.setMoney(state.getMoney() + amount);
        parent.setBalance(parent.getBalance() - amount);
    }

    public String getOptionMessage() {
        return "Withdraw " + amount + " $";
    }
}
