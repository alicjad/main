package Buildings;

import Game.GameObject;
import Game.State;

public class BankWithdrawMoney extends GameObject {
    protected Bank parent;
    protected int amount;

    public BankWithdrawMoney(Bank parent, int amount){
        this.parent = parent;
        this.amount = amount;
        this.addAccessibleObject(this.parent);
    }

    @Override
    public Boolean canExecute(State state) {
        if (parent.getBalance() < amount){
            return false;
        }
        else {
            return true;
        }
    }

    public void execute(State state){
        state.setSteps(state.getSteps() - this.getNumberOfSteps());
        withdrawMoney(this, state);

    }
    protected int getNumberOfSteps()
    {
        return 0;
    }

    private void withdrawMoney (BankWithdrawMoney chosenWithdraw, State state){
        state.setMoney(state.getMoney()+ amount);
        parent.setBalance(parent.getBalance()- amount);
    }

    public String getOptionMessage()
    {
        return "Withdraw "+ amount + " $";
    }
}
