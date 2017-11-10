package Buildings;
/**
 * This class contains FactoryWork class.
 */
public class Factory extends Building {

    public Factory (){
        this.addAccessibleObject(new FactoryWork(this));
    }

    public String getWelcomeMessage(){
        return "Welcome to the Factory.";
    }
    public String getOptionMessage(){
        return "Go to Factory.";
    }
}
