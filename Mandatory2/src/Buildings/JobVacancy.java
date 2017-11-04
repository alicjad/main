package Buildings;

import Game.EducationStateStatus;
import Game.GameObject;
import Game.State;

import java.util.ArrayList;
import java.util.List;

public class JobVacancy extends GameObject {
    protected String name;
    protected int hourlyWage;
    protected EmploymentOffice parent;
    protected int requiredExperiencePoints;

    protected EducationStateStatus requiredEducationLevel;

    public JobVacancy (String name, int hourlyWage, EmploymentOffice parent, EducationStateStatus requiredEducationLevel, int requiredExperiencePoints){
        this.name = name;
        this.hourlyWage = hourlyWage;
        this.parent = parent;
        this.requiredEducationLevel = requiredEducationLevel;
        this.requiredExperiencePoints = requiredExperiencePoints;
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
        state.setSteps(state.getSteps() - this.getNumberOfSteps());
        state.setCurrentOccupation(this);
    }
    protected int getNumberOfSteps()
    {
        return 0;
    }

    public int getHourlyWage(){
        return this.hourlyWage;
    }

    public List<GameObject> getAccessibleObjects() {

        List<GameObject> goToObjectList = new ArrayList<GameObject>();
        goToObjectList.add(parent);

        return goToObjectList;
    }
    public String getOptionMessage()
    {
        return "Get position of "+name+".";
    }
    public String getWelcomeMessage()
    {
        return "Congratulations you have got the job!";
    }
}
