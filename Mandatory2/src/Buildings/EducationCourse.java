package Buildings;
import Game.GameObject;
import Game.State;

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
        this.addAccessibleObject(this.parent);
        this.addAccessibleObject(this);
    }

    @Override
    public Boolean canExecute(State state) {
        if (state.getMoney() < this.getPrice() && this.status == EducationCourseStatus.NotEnrolled){
            return false;
        }
        if (this.status == EducationCourseStatus.Enrolled && state.getSteps() < 10){
            return false;
        }
        if (this.status == EducationCourseStatus.Finished){
            return false;
        }
        else {
            return true;
        }
    }

    public void execute(State state){
        state.setSteps(state.getSteps() - this.getNumberOfSteps());
        study(state);
    }
    protected int getNumberOfSteps(){
        return 0;
    }
    protected int getPrice(){
        return price;
    }

    private void study(State state){
        if (this.status == EducationCourseStatus.NotEnrolled){
            state.setMoney(state.getMoney() - this.getPrice());
            this.status = EducationCourseStatus.Enrolled;
        }
        else {
            state.setSteps(state.getSteps() - 10);
            state.setHappinessPoints(state.getHappinessPoints() - 10);
            state.setHungerPoints(state.getHungerPoints() - 5);
            if (studyCounter == 4){
                this.status = EducationCourseStatus.Finished;
                state.setEducationPoints(state.getEducationPoints()+20);
                state.setHappinessPoints(state.getHappinessPoints() + 20);
            }
            else{
                studyCounter += 1;
            }
        }
    }

    public String getOptionMessage(){
        if (this.status == EducationCourseStatus.NotEnrolled){
            return "Start "+name+" course for "+price+" $";
        }
        else {
            return "Study "+name+".";
        }
    }
}
