package Buildings;

import Game.EducationStateStatus;
import Game.GameObject;
import Game.State;

import java.util.ArrayList;
import java.util.List;

public class JobVacancy extends GameObject {
    protected String name;
    protected int hourlyWage;
    protected JobVacancyStatus status;
    protected EmploymentOffice parent;
    protected int requiredExperiencePoints;

    protected EducationStateStatus requiredEducationLevel;

    public JobVacancy (String name, int hourlyWage, EmploymentOffice parent, EducationStateStatus requiredEducationLevel, int requiredExperiencePoints){
        this.name = name;
        this.hourlyWage = hourlyWage;
        this.parent = parent;
        this.requiredEducationLevel = requiredEducationLevel;
        this.requiredExperiencePoints = requiredExperiencePoints;
        this.status = JobVacancyStatus.notAvailable;

    }
    public void execute(State state){
        state.setSteps(state.getSteps() - this.getNumberOfSteps());
        chooseJobVacancy(state);
    }
    protected int getNumberOfSteps()
    {
        return 0;
    }

    public int getHourlyWage(){
        return this.hourlyWage;}

    private JobVacancyStatus getJobVacancyStatus(State state){
        if (this.requiredEducationLevel == state.getEducationLevel() && state.getEducationPoints() == this.requiredExperiencePoints){
            this.status = JobVacancyStatus.available;
        }
        return this.status;
    }
    private void chooseJobVacancy (State state){
        if (this.getJobVacancyStatus(state) == JobVacancyStatus.available){
            state.setCurrentOccupation(this);
        }
        if (this.status == JobVacancyStatus.currentOccupancy){
            //todo System.out.println("You already have this job.");
        }
        if (this.status == JobVacancyStatus.notAvailable){
            //todo System.out.println("You are not entitled to get this job.")
        }
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
}
