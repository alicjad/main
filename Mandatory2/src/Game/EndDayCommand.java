package Game;

import Enums.HappinessStateStatus;
import Enums.HungerStateStatus;
import Enums.RentOfficePaymentStatus;

/**
 * This class is responsible for checking goals progress and personal status.
 * Depending on user state - ending the game of resetting some variables.
 */
public class EndDayCommand extends GameObject {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    @Override
    public Boolean canExecute(State state, GameObject previousGameObject) {
        return true;
    }

    @Override
    public void execute(State state, GameObject previousGameObject) {
        if (checkGoals(state)) {
            throw new GameEndException();
        } else {
            enforceRent(state);
            startNewDay(state);
        }
    }

    /**
     * This method compares current state variables with user's goals.
     * Checks if goals are acheived.
     *
     * @return boolean
     */
    private Boolean checkGoals(State state) {
        int goalNumber = state.getGoalPackageNo();
        switch (goalNumber) {
            case 1:
                return state.getHappinessLevel() == state.getGoalHappinessLevel() && state.getEducationLevel() == state.getGoalEducationLevel();
            case 2:
                return state.getFinancialLevel() == state.getGoalFinancialStatus() && state.getHappinessLevel() == state.getGoalHappinessLevel();
            case 3:
                return state.getEducationLevel() == state.getGoalEducationLevel() && state.getGoalHungerLevel() == state.getGoalHungerLevel();
            case 4:
                return state.getFinancialLevel() == state.getGoalFinancialStatus() && state.getCurrentOccupation() == state.getGoalJobVacancy();
            default:
                return false;
        }
    }

    /**
     * This method implements the consequences of not paying rent.
     */
    private void enforceRent(State state) {

        if (state.getRentStatus() == RentOfficePaymentStatus.NotPaid) {
            printReminder(ANSI_RED + "REMEMBER to pay your rent!");
            printReminder("If you don't pay within 7 days you will be HOMELESS!" + ANSI_RESET);
            if (state.getRentStatus() == RentOfficePaymentStatus.Homeless) {
                state.setHappinessPoints(0);
            }
        }
    }

    private void startNewDay(State state) {

        state.setSteps(getNumberOfNextDaySteps(state));
        if (state.getHappinessLevel() == HappinessStateStatus.notHappy) {
            state.setSteps(state.getSteps() - 10);
        }
        if (state.getHappinessLevel() == HappinessStateStatus.depressed) {
            state.setSteps(state.getSteps() - 20);
        }
        state.setDayCounter(state.getDayCounter() + 1);
    }

    /**
     * This method prints reminding message.
     */
    private void printReminder(String reminder) {
        System.out.println(reminder);
    }

        /**
     * This method contains conditions based on which user gets certain amount of steps for the next day.
     *
     * @return int - number of steps for the next day.
     */
    private int getNumberOfNextDaySteps(State state) {

        if (state.getHungerLevel() == HungerStateStatus.Full) {
            return 155;
        }
        if (state.getHungerLevel() == HungerStateStatus.quiteFull) {
            return 145;
        }
        if (state.getHungerLevel() == HungerStateStatus.notHungry) {
            return 125;
        }
        if (state.getHungerLevel() == HungerStateStatus.hungry) {
            return 105;
        }
        if (state.getHungerLevel() == HungerStateStatus.veryHungry) {
            return 75;
        } else {
            return 45;
        }
    }

    public String getWelcomeMessage() {
        return "Ending day...";
    }

    public String getOptionMessage() {
        return "End Day.";
    }
}
