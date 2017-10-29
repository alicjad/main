package Buildings;

import Game.GameObject;
import Game.State;

import java.util.ArrayList;
import java.util.List;

public class BankWithdrawMoney extends GameObject {
    protected Bank parent;
    protected int amount;

    public BankWithdrawMoney(Bank parent, int amount){
        this.parent = parent;
        this.amount = amount;
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
        if (parent.getBalance() >= amount){
            state.setMoney(state.getMoney()+ amount);
            parent.setBalance(parent.getBalance()- amount);
        }
        else {
            //todo alternative option to send the user back because he doesn't have enough money
        }
    }

    public List<GameObject> getAccessibleObjects() {

        List<GameObject> goToObjectList = new ArrayList<GameObject>();
        goToObjectList.add(parent);

        return goToObjectList;
    }
    public String getOptionMessage()
    {
        return "Withdraw "+ amount + " $";
    }
}
