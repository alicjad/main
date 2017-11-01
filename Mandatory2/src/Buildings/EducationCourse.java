package Buildings;

import Game.GameObject;
import Game.State;

import java.util.ArrayList;
import java.util.List;

public class EducationCourse extends GameObject {
    protected String name;
    protected int price;
    protected University parent;
    protected EducationCourseStatus status;
    protected int studyCounter = 0;

    public EducationCourse (String name, int price, University parent) {
        this.name = name;
        this.price = price;
        this.parent = parent;
        this.status = EducationCourseStatus.NotEnrolled;
    }
    public void execute(State state){
        state.setSteps(state.getSteps() - this.getNumberOfSteps());
        study(state);
    }
    protected int getNumberOfSteps()
    {
        return 0;
    }
    protected int getPrice() {return price;}

    private void study(State state){
        if (this.status == EducationCourseStatus.NotEnrolled && state.getMoney() >= this.getPrice()){
            state.setMoney(state.getMoney() - this.getPrice());
            this.status = EducationCourseStatus.Enrolled;
        }
        else if (state.getMoney() < getPrice()){
           //todo System.out.println("Sorry, you don't have enough money.");
        }
        else {
            state.setSteps(state.getSteps() - 10);
            if (studyCounter == 4){
                this.status = EducationCourseStatus.Finished;
                state.setEducationPoints(state.getEducationPoints()+20);
            }
            else{ studyCounter += 1;}
        }
    }

    public List<GameObject> getAccessibleObjects() {

        List<GameObject> goToObjectList = new ArrayList<GameObject>();
        goToObjectList.add(parent);

        return goToObjectList;
    }
    public String getOptionMessage()
    {
        return "Choose "+name+" course.";
    }
}
