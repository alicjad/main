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

        list.add(new Restaurant("McDonalds", this));
        list.add(new Restaurant("burgerKing", this));

        return list;
    }

    public String getWelcomeMessage() {
        return "You are on the Wasteland.";
    }
    public String getOptionMessage(){
        return "Go back to "+name;
    }
}
