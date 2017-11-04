package Buildings;

import Game.GameObject;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenu extends Building {
    public Restaurant parent;

    RestaurantMenu(Restaurant chosenRestaurant){
        this.parent = chosenRestaurant;
    }

    @Override
    public List<GameObject> getAccessibleObjects() {

        List<GameObject> menu = new ArrayList<GameObject>();
        menu.add(new Burger("Bacon", 120, 5, 5, this));
        menu.add(new Burger("Cheese", 110, 4, 5,this));
        menu.add(new Burger("Chicken", 110, 4, 5, this));
        menu.add(new Burger("Butter", 110, 4, 5, this));
        menu.add(new Burger("Veggie", 100, 4, 5, this));
        menu.add(new Drink("Coca-cola", 70, 2, 3, this));
        menu.add(new Drink("Faxe Kondi", 70, 2, 3, this));
        menu.add(new Drink("water", 40, 1, 3, this));
        menu.add(new Drink("orange juice", 60, 2, 3, this));
        menu.add(new Drink("apple juice", 60, 2, 3, this));
        menu.add(new Extra("Classic fries", 80, 3, 3, this));
        menu.add(new Extra("Curly fries", 80, 3, 3, this));
        menu.add(new Extra("Onion Rings", 70, 3, 3, this));
        menu.add(new Extra("Salad", 50, 2, 3, this));
        menu.add(parent);
        //when we choose to come back to the restaurant it does have only go to menu option. WHY???

        return menu;
    }
    //to not take user's steps for choosing option: see menu
    @Override
    protected int getNumberOfSteps() {
        return 0;
    }

    public String getWelcomeMessage()
    {
        return "MENU: ";
    }
    public String getOptionMessage(){
        return "See MENU";
    }
}
