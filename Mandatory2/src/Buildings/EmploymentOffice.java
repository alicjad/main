package Buildings;

import Game.EducationStateStatus;
import Game.GameObject;
import Game.State;

import java.util.ArrayList;
import java.util.List;

public class EmploymentOffice extends Building {

    public EmploymentOffice(){
        this.setAvailableJobs(availableJobs);
    }

    @Override
    public void execute(State state) {
        super.execute(state);
        state.setCurrentOccupation(getStartVacancy());
    }

    public JobVacancy startVacancy = new JobVacancy("Unemployed", 0, this, EducationStateStatus.notEducated, WorkExperienceStatus.fresher);
    public JobVacancy getStartVacancy(){
        return startVacancy;
    }
    public List<GameObject> availableJobs = new ArrayList<GameObject>();

    public void setAvailableJobs(List<GameObject> availableJobs) {
        availableJobs.add(new JobVacancy("Factory Worker", 80, this, EducationStateStatus.notEducated, WorkExperienceStatus.fresher));
        availableJobs.add(new JobVacancy("Shift Manager", 120, this, EducationStateStatus.quiteEducated, WorkExperienceStatus.quiteExperienced ));
        availableJobs.add(new JobVacancy("Engineer", 180, this, EducationStateStatus.educated, WorkExperienceStatus.quiteExperienced));
        availableJobs.add(new JobVacancy("Production Manager", 210, this, EducationStateStatus.wellEducated, WorkExperienceStatus.veryExperienced));
        availableJobs.add(new JobVacancy("Factory Executive Manager", 300, this, EducationStateStatus.fullyEducated, WorkExperienceStatus.veryExperienced));
    }

    public List<GameObject> getAccessibleObjects() {

        List<GameObject> availableOptions = new ArrayList<GameObject>();
        availableOptions.addAll(this.getAvailableJobs());
        availableOptions.addAll(super.getAccessibleObjects());

        return availableOptions;
    }

    public List<GameObject> getAvailableJobs() {
        return availableJobs;
    }

    public String getWelcomeMessage()
    {
        return "Welcome to the Employment Office";
    }
    public String getOptionMessage(){
        return "Go to Employment Office.";
    }
}
