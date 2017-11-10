package Game;

import BuildingCommands.JobVacancy;
import Enums.*;

/**
 * This class contains all variables connected to user accomplishments.
 */
public class State {

    public JobVacancy currentOccupation;
    private int steps;
    private int hungerPoints;
    private int happinessPoints;
    private int educationPoints;
    private int experiencePoints;
    private int money;
    private int dayCounter;
    private int rentDeadline;

    private GameObject goalJobVacancy;
    private HungerStateStatus goalHungerLevel;
    private HappinessStateStatus goalHappinessLevel;
    private EducationStateStatus goalEducationLevel;
    private FinancialStateStatus goalFinancialStatus;
    private int goalPackageNo;

    /**
     * This constructor sets start values of given variables.
     */
    State() {
        setSteps(125);
        setHungerPoints(50);
        setHappinessPoints(40);
        setEducationPoints(0);
        setMoney(500);
        setDayCounter(0);
    }

    public JobVacancy getCurrentOccupation() {
        return currentOccupation;
    }

    public void setCurrentOccupation(JobVacancy currentOccupation) {
        this.currentOccupation = currentOccupation;
    }

    public int getDayCounter() {
        return dayCounter;
    }

    public void setDayCounter(int dayCounter) {
        this.dayCounter = dayCounter;
    }

    public RentOfficePaymentStatus getRentStatus() {

        if (dayCounter <= rentDeadline) {
            return RentOfficePaymentStatus.Paid;
        } else {
            if (dayCounter > rentDeadline + 7) {
                return RentOfficePaymentStatus.Homeless;
            }
        }
        return RentOfficePaymentStatus.NotPaid;
    }

    public HungerStateStatus getHungerLevel() {

        if (hungerPoints < 20) {
            return HungerStateStatus.starving;
        }
        if (hungerPoints <= 30) {
            return HungerStateStatus.veryHungry;
        }
        if (hungerPoints <= 40) {
            return HungerStateStatus.hungry;
        }
        if (hungerPoints <= 50) {
            return HungerStateStatus.notHungry;
        }
        if (hungerPoints <= 75) {
            return HungerStateStatus.quiteFull;
        } else {
            return HungerStateStatus.Full;
        }
    }

    public HappinessStateStatus getHappinessLevel() {

        if (happinessPoints < 20) {
            return HappinessStateStatus.depressed;
        }
        if (happinessPoints <= 35) {
            return HappinessStateStatus.notHappy;
        }
        if (happinessPoints <= 50) {
            return HappinessStateStatus.normal;
        }
        if (happinessPoints <= 75) {
            return HappinessStateStatus.quiteHappy;
        } else {
            return HappinessStateStatus.veryHappy;
        }
    }

    public EducationStateStatus getEducationLevel() {

        if (educationPoints <= 20) {
            return EducationStateStatus.notEducated;
        }
        if (educationPoints <= 40) {
            return EducationStateStatus.quiteEducated;
        }
        if (educationPoints <= 60) {
            return EducationStateStatus.educated;
        }
        if (educationPoints <= 80) {
            return EducationStateStatus.wellEducated;
        } else {
            return EducationStateStatus.fullyEducated;
        }
    }

    public FinancialStateStatus getFinancialLevel() {

        if (money < 500) {
            return FinancialStateStatus.poor;
        }
        if (money <= 2000) {
            return FinancialStateStatus.quitePoor;
        }
        if (money <= 5000) {
            return FinancialStateStatus.averageWageReceiver;
        }
        if (money <= 10000) {
            return FinancialStateStatus.growingRich;
        } else {
            return FinancialStateStatus.rich;
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getHungerPoints() {
        return hungerPoints;
    }

    public void setHungerPoints(int hungerPoints) {
        this.hungerPoints = hungerPoints;
    }

    public int getHappinessPoints() {
        return happinessPoints;
    }

    public void setHappinessPoints(int happinessPoints) {
        this.happinessPoints = happinessPoints;
    }

    public int getEducationPoints() {
        return educationPoints;
    }

    public void setEducationPoints(int educationPoints) {
        this.educationPoints = educationPoints;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public GameObject getGoalJobVacancy() {
        return goalJobVacancy;
    }

    public void setGoalJobVacancy(GameObject goalJobVacancy) {
        this.goalJobVacancy = goalJobVacancy;
    }

    public HungerStateStatus getGoalHungerLevel() {
        return goalHungerLevel;
    }

    public void setGoalHungerLevel(HungerStateStatus goalHungerLevel) {
        this.goalHungerLevel = goalHungerLevel;
    }

    public HappinessStateStatus getGoalHappinessLevel() {
        return goalHappinessLevel;
    }

    public void setGoalHappinessLevel(HappinessStateStatus goalHappinessLevel) {
        this.goalHappinessLevel = goalHappinessLevel;
    }

    public EducationStateStatus getGoalEducationLevel() {
        return goalEducationLevel;
    }

    public void setGoalEducationLevel(EducationStateStatus goalEducationLevel) {
        this.goalEducationLevel = goalEducationLevel;
    }

    public FinancialStateStatus getGoalFinancialStatus() {
        return goalFinancialStatus;
    }

    public void setGoalFinancialStatus(FinancialStateStatus goalFinancialStatus) {
        this.goalFinancialStatus = goalFinancialStatus;
    }

    public int getGoalPackageNo() {
        return goalPackageNo;
    }

    public void setGoalPackageNo(int goalPackageNo) {
        this.goalPackageNo = goalPackageNo;
    }

    public int getRentDeadline() {
        return rentDeadline;
    }

    public void setRentDeadline(int rentDeadline) {
        this.rentDeadline = rentDeadline;
    }
}
