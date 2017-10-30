package Buildings;

import Game.EducationStateStatus;
import Game.GameObject;
import Game.State;

import java.util.ArrayList;
import java.util.List;

public class JobVacancy extends GameObject {
    protected String name;
    public int hourlyWage;
    protected JobVacancyStatus status;
    protected EmploymentOffice parent;
    protected WorkExperienceStatus requiredExperienceStatus;
    protected WorkExperienceStatus experienceStatus;
    protected EducationStateStatus requiredEducationLevel;

    public JobVacancy (String name, int hourlyWage, EmploymentOffice parent, EducationStateStatus requiredEducationLevel, WorkExperienceStatus requiredExperienceStatus){
        this.name = name;
        this.hourlyWage = hourlyWage;
        this.parent = parent;
        this.requiredEducationLevel = requiredEducationLevel;
        this.requiredExperienceStatus = requiredExperienceStatus;
        this.status = JobVacancyStatus.notAvailable;
    }
    public void execute(State state){
        state.setSteps(state.getSteps() - this.getNumberOfSteps());
        chooseJobVacancy(this, state);
    }
    protected int getNumberOfSteps()
    {
        return 0;
    }

    private JobVacancyStatus getJobVacancyStatus(JobVacancy chosenJobVacancy, State state){
        if (chosenJobVacancy.requiredEducationLevel == state.getEducationLevel() && state.currentOccupation.experienceStatus == requiredExperienceStatus){
            chosenJobVacancy.status = JobVacancyStatus.available;
        }
        return chosenJobVacancy.status;
    }
    private void chooseJobVacancy (JobVacancy chosenJobVacancy, State state){
        if (this.getJobVacancyStatus(this, state) == JobVacancyStatus.available){
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
