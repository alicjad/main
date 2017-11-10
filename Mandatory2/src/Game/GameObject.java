package Game;
import java.util.ArrayList;
import java.util.List;

public abstract class GameObject {

    private List<GameObject> accessibleObjectList;

    public GameObject (){
        this.accessibleObjectList = new ArrayList<GameObject>();
    }

    public abstract Boolean canExecute(State state);

    public void execute(State state){

    }

    public Boolean isEndDayOptionAllowed(){
        return false;
    }

    public void addAccessibleObject(GameObject chosenGameObject){
        this.accessibleObjectList.add(chosenGameObject);
    }

    public void addAccessibleObjects(List<GameObject> chosenGameObject){
        this.accessibleObjectList.addAll(chosenGameObject);
    }

    public final List<GameObject> getAccessibleObjects(){

        List<GameObject> accessibleObjectListCopy = new ArrayList<>();
        accessibleObjectListCopy.addAll(this.accessibleObjectList);

        return accessibleObjectListCopy;
    }

    public String getWelcomeMessage(){
        return "";
    }

    public String getOptionMessage(){
        return "";
    }
}

