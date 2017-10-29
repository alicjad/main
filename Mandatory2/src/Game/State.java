package Game;

public class State {
    private int steps;
    private int hungerPoints;
    private int happinessPoints;
    private int educationPoints;
    private int money;

    State(){
        setSteps(50);
        setHungerPoints(50);
        setHappinessPoints(50);
        setEducationPoints(0);
        setMoney(200);
    }

    private HungerStateStatus getHungerLevel (){
        if (hungerPoints < 20){
            return HungerStateStatus.starving;
        }
        if (hungerPoints <= 30){
            return HungerStateStatus.veryHungry;
        }
        if (hungerPoints > 35 && hungerPoints <= 40){
            return HungerStateStatus.hungry;
        }
        if (hungerPoints < 40 && hungerPoints <= 50){
            return HungerStateStatus.notHungry;
        }
        if (hungerPoints > 50 && hungerPoints <= 75){
            return HungerStateStatus.quiteFull;
        }
        else {
            return HungerStateStatus.Full;}
    }

    private HappinessStateStatus getHappinessLevel(){
        if (happinessPoints < 20){
            return HappinessStateStatus.depressed;
        }
        if (happinessPoints <= 35){
            return HappinessStateStatus.notHappy;
        }
        if (happinessPoints > 35 && happinessPoints < 50){
            return HappinessStateStatus.normal;
        }
        if (happinessPoints >= 50 && happinessPoints < 75){
            return HappinessStateStatus.quiteHappy;
        }
        else {
            return HappinessStateStatus.veryHappy;
        }
    }

    private EducationStateStatus getEducationLevel(){
        if (educationPoints <= 20){
            return EducationStateStatus.notEducated;
        }
        if (educationPoints > 20 && educationPoints <= 40){
            return EducationStateStatus.quiteEducated;
        }
        if (educationPoints > 40 && educationPoints <= 60){
            return EducationStateStatus.educated;
        }
        if (educationPoints > 60 && educationPoints <= 80){
            return EducationStateStatus.wellEducated;
        }
        else{
            return EducationStateStatus.fullyEducated;
        }
    }

    private FinancialStateStatus getFinancialLevel(){
        if (money < 500){
            return FinancialStateStatus.poor;
        }
        if (money >= 1000){
            return FinancialStateStatus.quitePoor;
        }
        if (money >= 1500){
            return FinancialStateStatus.averageWageReceiver;
        }
        if (money >= 2000){
            return FinancialStateStatus.growingRich;
        }
        else {
            return FinancialStateStatus.rich;
        }
    }

    public void setMoney(int money){
        this.money = money;
    }
    public int getMoney(){
        return money;
    }

    public int getSteps(){
        return steps;
    }
    public void setSteps(int steps){
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
}
