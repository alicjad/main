package Game;

import java.util.ArrayList;
import java.util.List;

/**
 * This superclass contains all necessary methods and array list for GameObject type.
 */
public abstract class GameObject {

    private List<GameObject> accessibleObjectList;

    public GameObject() {
        this.accessibleObjectList = new ArrayList<GameObject>();
    }

    /**
     * This method checks given conditions,
     *
     * @param state gives information saved in State class,
     * @return boolean
     */
    public abstract Boolean canExecute(State state);

    /**
     * This function calls other methods - they differ depending on object.
     * It is responsible for action connected to game objects.
     */
    public void execute(State state) {

    }

    /**
     * This method checks if EndDayCommand can be added to the accessibleObjectList.
     *
     * @return boolean
     */
    public Boolean isEndDayOptionAllowed() {
        return false;
    }

    /**
     * This method adds single GameObject to the accessibleObjectList.
     */
    public void addAccessibleObject(GameObject chosenGameObject) {
        this.accessibleObjectList.add(chosenGameObject);
    }

    /**
     * This method adds many GameObjects to the accessibleObjectList.
     */
    public void addAccessibleObjects(List<GameObject> chosenGameObject) {
        this.accessibleObjectList.addAll(chosenGameObject);
    }

    /**
     * This method returns accessibleObjectList.
     *
     * @return list of possible nextGameObject for chosen game object.
     */
    public final List<GameObject> getAccessibleObjects() {

        List<GameObject> accessibleObjectListCopy = new ArrayList<>();
        accessibleObjectListCopy.addAll(this.accessibleObjectList);

        return accessibleObjectListCopy;
    }

    /**
     * This method returns welcome message.
     *
     * @return welcome message saved in String type variable.
     */
    public String getWelcomeMessage() {
        return "";
    }

    /**
     * This method returns option message, it presents chosen game object.
     *
     * @return option message saved in String type variable
     */
    public String getOptionMessage() {
        return "";
    }
}

