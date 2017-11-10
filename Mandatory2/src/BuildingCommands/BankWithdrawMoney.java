package BuildingCommands;

import Buildings.Bank;
import Game.GameObject;
import Game.State;

/**
 * This class is responsible for withdrawMoney function.
 */
public class BankWithdrawMoney extends GameObject {
    private final Bank parent;
    private final int amount;

    public BankWithdrawMoney(Bank parent, int amount) {
        this.parent = parent;
        this.amount = amount;
        this.addAccessibleObject(this.parent);
    }

    @Override
    public Boolean canExecute(State state, GameObject previousGameObject) {
        return (parent.getBalance() >= amount);
    }

    @Override
    public void execute(State state, GameObject previousGameObject) {
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
