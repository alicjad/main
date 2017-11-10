package Buildings;
import Game.EducationStateStatus;
import Game.GameObject;
import java.util.ArrayList;
import java.util.List;

public class EmploymentOffice extends Building {

    public EmploymentOffice (){
        this.addAccessibleObjects(getAvailableJobs());
    }

    public List<GameObject> getAvailableJobs(){

        List<GameObject> availableJobs = new ArrayList<GameObject>();
        availableJobs.add(new JobVacancy("Factory Worker", 80,this, EducationStateStatus.notEducated, 0));
        availableJobs.add(new JobVacancy("Shift Manager", 120,this, EducationStateStatus.quiteEducated, 50));
        availableJobs.add(new JobVacancy("Engineer", 180,this, EducationStateStatus.educated, 100));
        availableJobs.add(new JobVacancy("Production Manager", 210, this, EducationStateStatus.wellEducated, 150));
        availableJobs.add(new JobVacancy("Factory Executive Manager", 300,this, EducationStateStatus.fullyEducated,200));

        return availableJobs;
    }

    public String getWelcomeMessage(){
        return "Welcome to the Employment Office";
    }
    public String getOptionMessage(){
        return "Go to Employment Office.";
    }
}
