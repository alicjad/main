package Buildings;

import Game.GameObject;

import java.util.ArrayList;
import java.util.List;

public class University extends Building {
    public University(){
        this.setAvailableCourses(availableCourses); ;
    }

    public List<GameObject> availableCourses = new ArrayList<GameObject>();

    public void setAvailableCourses(List<GameObject> availableCourses) {
        availableCourses.add(new EducationCourse("Math", 100,  this));
        availableCourses.add(new EducationCourse("Physics", 110, this));
        availableCourses.add(new EducationCourse("Logistics", 140,  this));
        availableCourses.add(new EducationCourse("Production Engineering", 180, this));
        availableCourses.add(new EducationCourse("Marketing and Finance", 200, this));
    }

    public List<GameObject> getAccessibleObjects() {

        List<GameObject> availableOptions = new ArrayList<GameObject>();
        availableOptions.addAll(this.getAvailableCourses());
        availableOptions.addAll(super.getAccessibleObjects());

        return availableOptions;
    }

    public List<GameObject> getAvailableCourses() {
        return availableCourses;
    }

    public String getWelcomeMessage()
    {
        return "Welcome to the Wasteland University!";
    }
    public String getOptionMessage(){
        return "Go to University";
    }
}
