package Game;
import Buildings.*;
/**
 * This class is responsible for creating board for the game.(=map with buildings)
 */
public class GameBoardCreator {

    protected GameObject EndDayCommand;
    protected GoalSetter GoalSetter;
    /**
     * This method created map with all buildings and determine connections between them.
     * @return EndDayCommand gameObject which is the first currentGameObject in the game.
     */
    public GameObject getInitialGameObject(){

        GameObject University = new University();
        GameObject Factory = new Factory();
        EmploymentOffice EmploymentOffice = new EmploymentOffice();
        GameObject Bank = new Bank();
        GameObject RentOffice = new RentOffice();
        GameObject PawnShop = new PawnShop();
        GameObject Restaurant = new Restaurant();
        Home Home = new Home();
        EndDayCommand = new EndDayCommand();
        GoalSetter = new GoalSetter();

        University.addAccessibleObject(Bank);
        University.addAccessibleObject(Factory);
        University.addAccessibleObject(RentOffice);

        Factory.addAccessibleObject(University);
        Factory.addAccessibleObject(RentOffice);
        Factory.addAccessibleObject(PawnShop);
        Factory.addAccessibleObject(EmploymentOffice);

        EmploymentOffice.addAccessibleObject(Factory);
        EmploymentOffice.addAccessibleObject(PawnShop);
        EmploymentOffice.addAccessibleObject(Restaurant);
        EmploymentOffice.addAccessibleObject(Home);

        Bank.addAccessibleObject(University);
        Bank.addAccessibleObject(RentOffice);

        RentOffice.addAccessibleObject(Bank);
        RentOffice.addAccessibleObject(University);
        RentOffice.addAccessibleObject(Factory);
        RentOffice.addAccessibleObject(PawnShop);

        PawnShop.addAccessibleObject(RentOffice);
        PawnShop.addAccessibleObject(Factory);
        PawnShop.addAccessibleObject(EmploymentOffice);
        PawnShop.addAccessibleObject(Restaurant);

        Restaurant.addAccessibleObject(PawnShop);
        Restaurant.addAccessibleObject(EmploymentOffice);
        Restaurant.addAccessibleObject(Home);

        Home.addAccessibleObject(EmploymentOffice);
        Home.addAccessibleObject(Restaurant);

        EndDayCommand.addAccessibleObject(Home);

        GoalSetter.addAccessibleObject(Home);
        GoalSetter.setEmploymentOffice(EmploymentOffice);

        return getGoalSetter();
    }

    public GameObject getEndDayCommand(){
        return this.EndDayCommand;
    }

    public GameObject getGoalSetter() {
        return GoalSetter;
    }
}
