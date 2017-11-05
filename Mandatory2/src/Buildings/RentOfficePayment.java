package Buildings;

import Game.GameObject;
import Game.State;

import java.util.ArrayList;
import java.util.List;

public class RentOfficePayment extends GameObject {

    protected RentOffice parent;
    protected int amount;
    protected int rentDays;

    public RentOfficePayment(RentOffice parent, int amount, int rentDays){
        this.parent = parent;
        this.amount = amount;
        this.rentDays = rentDays;
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
        payRent(state);
    }
    protected int getNumberOfSteps()
    {
        return 0;
    }

    private void payRent (State state){
        state.setMoney(state.getMoney() - amount);
    }

    public List<GameObject> getAccessibleObjects() {

        List<GameObject> goToObjectList = new ArrayList<GameObject>();
        goToObjectList.add(parent);

        return goToObjectList;
    }
    public String getOptionMessage()
    {
        return "Pay rent for "+rentDays+" days for "+amount+"$";
    }
}
