package Game;

import Buildings.EmploymentOffice;
import Enums.EducationStateStatus;
import Enums.FinancialStateStatus;
import Enums.HappinessStateStatus;
import Enums.HungerStateStatus;

/**
 * This class ir responsible for setting game goals.
 */
public class GoalSetter extends GameObject {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private EmploymentOffice employmentOffice;
    private final UserInputHandle userInputHandle = new UserInputHandle();

    public void setEmploymentOffice(EmploymentOffice employmentOffice) {
        this.employmentOffice = employmentOffice;
    }

    @Override
    public Boolean canExecute(State state, GameObject previousGameObject) {
        return true;
    }

    @Override
    public void execute(State state, GameObject previousGameObject) {
        goalsMenu(state);
    }

    /**
     * This method prints possible goal sets.
     */
    private void printGoalOptions() {
        System.out.println(ANSI_PURPLE + "CHOOSE YOUR GOALS: " + ANSI_RESET);
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("1. I can be poor - I don't care about the money but I want to be as" + ANSI_BLUE + " happy and" + ANSI_RESET + " as" + ANSI_BLUE + " educated" + ANSI_RESET + " as possible.");
        System.out.println("2. I want to be " + ANSI_BLUE + "rich and happy!" + ANSI_RESET + " I don't have to be educated at all.");
        System.out.println("3. I want to be well " + ANSI_BLUE + "educated and " + ANSI_RESET + "I don't want be hungry ever again. Always " + ANSI_BLUE + "full!" + ANSI_RESET + " ;) ");
        System.out.println("4. I want to have the " + ANSI_BLUE + "best job" + ANSI_RESET + " possible and make" + ANSI_BLUE + " lots of money" + ANSI_RESET + " even if it will make me unhappy.");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

    /**
     * This method set the goals depending on user input.
     */
    private void goalsMenu(State state) {
        printGoalOptions();
        while (true) {
            System.out.print("Type your number: ");
            int choice = userInputHandle.getIntFromUser();
            switch (choice) {
                case 1:
                    state.setGoalEducationLevel(EducationStateStatus.fullyEducated);
                    state.setGoalHappinessLevel(HappinessStateStatus.veryHappy);
                    state.setGoalPackageNo(1);
                    return;
                case 2:
                    state.setGoalFinancialStatus(FinancialStateStatus.rich);
                    state.setGoalHappinessLevel(HappinessStateStatus.veryHappy);
                    state.setGoalPackageNo(2);
                    return;
                case 3:
                    state.setGoalEducationLevel(EducationStateStatus.fullyEducated);
                    state.setGoalHungerLevel(HungerStateStatus.Full);
                    state.setGoalPackageNo(3);
                    return;
                case 4:
                    state.setGoalFinancialStatus(FinancialStateStatus.rich);
                    state.setGoalJobVacancy(employmentOffice.getAvailableJobs().get(4));
                    state.setGoalPackageNo(4);
                    return;
                default:
                    System.out.println(ANSI_RED + "Sorry, you can only choose option from 1 to 4!" + ANSI_RESET);
                    userInputHandle.pressEnterToContinue();
            }
        }
    }

    public String getWelcomeMessage() {
        return "GREAT, YOU CHOSE YOUR GAME GOALS!";
    }
}
