package Buildings;
import Game.EducationStateStatus;
import Game.GameObject;
import Game.State;
/**
 * The class JobVacancy is represents a job vacancy.
 */
public class JobVacancy extends GameObject {

    protected String name;
    protected int hourlyWage;
    protected int requiredExperiencePoints;
    protected EducationStateStatus requiredEducationLevel;

    public JobVacancy (String name, int hourlyWage, EmploymentOffice parent, EducationStateStatus requiredEducationLevel, int requiredExperiencePoints){
        this.name = name;
        this.hourlyWage = hourlyWage;
        this.requiredEducationLevel = requiredEducationLevel;
        this.requiredExperiencePoints = requiredExperiencePoints;
        this.addAccessibleObject(parent);
    }

    @Override
    public Boolean canExecute(State state) {
        if (this.requiredEducationLevel != state.getEducationLevel() || state.getExperiencePoints() != this.requiredExperiencePoints){
            return false;
        }
        if (state.getCurrentOccupation() == this){
            return false;
        }
        else {
            return true;
        }
    }

    public void execute(State state){
        state.setCurrentOccupation(this);
        state.setHappinessPoints(state.getHappinessPoints() + 15);
    }

    public int getHourlyWage(){
        return this.hourlyWage;
    }

    public String getOptionMessage(){
        return "Get position of "+name+".";
    }
    public String getWelcomeMessage(){
        return "Congratulations you have got the job!";
    }
}
