package Game;

public class State {
    private int steps;
    private int hungerPoints;
    private String hunger;
    private int happinessPoints;
    private String happiness;
    private int educationPoints;
    private String education;
    private int money;
    private String financialStatus;

    public void setMoney(int money){
        this.money = money;
    }
    public int getMoney(){
        return money;
    }

    public void setFinancialStatus(String financialStatus){
        this.financialStatus = financialStatus;
    }
    public String getFinancialStatus(){
        return financialStatus;
    }

    public int getSteps(){
        return steps;
    }
    public void setSteps(int steps){
        this.steps = steps;
    }

    public int getGetHungerPoints() {
        return hungerPoints;
    }
    public void setGetHungerPoints(int hungerPoints) {
        this.hungerPoints = hungerPoints;
    }

    public String getHunger() {
        return hunger;
    }
    public void setHunger(String hunger) {
        this.hunger = hunger;
    }

    public int getHappinessPoints() {
        return happinessPoints;
    }
    public void setHappinessPoints(int happinessPoints) {
        this.happinessPoints = happinessPoints;
    }

    public String getHappiness() {
        return happiness;
    }
    public void setHappiness(String happiness) {
        this.happiness = happiness;
    }

    public int getEducationPoints() {
        return educationPoints;
    }
    public void setEducationPoints(int educationPoints) {
        this.educationPoints = educationPoints;
    }

    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
}
