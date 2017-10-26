package Buildings;

import Game.GameObject;
import java.util.ArrayList;
import java.util.List;

public class City extends GameObject {
    private String name;

    public City (String cityName){
        this.name = cityName;
    }
    public List<GameObject> getAccessibleObjects() {
        List<GameObject> list = new ArrayList<GameObject>();

        list.add(new University("University", this));
        list.add(new Factory("FACTORY", this));
        list.add(new EmploymentOffice("Job centre", this));
        list.add(new Bank("Goliat Bank",this));
        list.add(new RentOffice("Hygge houses",this));
        list.add(new PawnShop("City Pawn Shop", this));
        list.add(new Restaurant("Burger Palace", this));
        list.add(new Home("Home", this));

        return list;
    }

    public String getWelcomeMessage() {
        return "You are on the Wasteland.";
    }
    public String getOptionMessage(){
        return "Go back to "+name;
    }
}
