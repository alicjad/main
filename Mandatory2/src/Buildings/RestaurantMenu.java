package Buildings;

import Game.GameObject;
import Game.State;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenu extends Building {
    @Override
    public List<GameObject> getAccessibleObjects() {

        List<GameObject> menu = new ArrayList<GameObject>();
        menu.add(new Burger("Bacon Burger", 120));
        menu.add(new Burger("Cheese Burger", 110));
        menu.add(new Burger("Chicken Burger", 110));
        menu.add(new Burger("Butter Burger", 110));
        menu.add(new Burger("Veggie Burger", 100));
        menu.add(new Drink("Coca-cola", 70));
        menu.add(new Drink("Faxe Kondi", 70));
        menu.add(new Drink("water", 40));
        menu.add(new Drink("orange juice", 60));
        menu.add(new Drink("apple juice", 60));
        menu.add(new Extra("Classic fries", 80));
        menu.add(new Extra("Curly fries", 80));
        menu.add(new Extra("Onion Rings", 70));
        menu.add(new Extra("Salad", 50));
        menu.add(new Restaurant());
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
