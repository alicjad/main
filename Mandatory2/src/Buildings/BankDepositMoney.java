package Buildings;

import Game.GameObject;
import Game.State;

import java.util.ArrayList;
import java.util.List;

public class BankDepositMoney extends GameObject {
    protected Bank parent;
    protected int amount;

    public BankDepositMoney(Bank parent, int amount){
        this.parent = parent;
        this.amount = amount;
    }

    @Override
    public Boolean canExecute(State state) {
        if (state.getMoney() < amount){
            return false;
        }
        else {
            return true;
        }
    }

    public void execute(State state){
        state.setSteps(state.getSteps() - this.getNumberOfSteps());
        depositMoney(this, state);
    }
    protected int getNumberOfSteps()
    {
        return 0;
    }

    private void depositMoney (BankDepositMoney chosenDeposit, State state){
        state.setMoney(state.getMoney() - amount);
        parent.setBalance(parent.getBalance()+amount);
    }

    public List<GameObject> getAccessibleObjects() {

        List<GameObject> goToObjectList = new ArrayList<GameObject>();
        goToObjectList.add(parent);

        return goToObjectList;
    }
    public String getOptionMessage()
    {
        return "Deposit "+ amount + " $";
    }
}
