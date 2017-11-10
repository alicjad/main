package Buildings;

import Game.GameObject;
import Game.State;

/**
 * The class FactoryWork contains work method.
 */
public class FactoryWork extends GameObject {

    public FactoryWork(Factory parent) {
        this.addAccessibleObject(parent);
    }

    @Override
    public Boolean canExecute(State state) {
        return (state.getSteps() >= this.getNumberOfSteps());
    }

    @Override
    public void execute(State state) {
        work(state);
    }

    /**
     * This method checks what job user have and gets proper amount of money.
     *
     * @return int hourly wage.
     */
    private int getAmountOfMoney(State state) {
        return state.currentOccupation.getHourlyWage();
    }

    private int getNumberOfSteps() {
        return 10;
    }

    private void work(State state) {

        state.setSteps(state.getSteps() - this.getNumberOfSteps());
        state.setMoney(state.getMoney() + getAmountOfMoney(state));
        state.setExperiencePoints(state.getExperiencePoints() + 10);
        state.setHappinessPoints(state.getHappinessPoints() - 10);
        state.setHungerPoints(state.getHungerPoints() - 5);
    }

    public String getWelcomeMessage() {
        return "It was a long shift...";
    }

    public String getOptionMessage() {
        return "Work in Factory.";
    }
}
