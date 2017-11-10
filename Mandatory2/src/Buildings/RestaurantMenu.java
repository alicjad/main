package Buildings;

import Game.GameObject;
import Game.State;

/**
 * This method contains the list of food you can buy in the Restaurant.
 */
public class RestaurantMenu extends GameObject {
    /**
     * This constructor creates Restaurant's menu by adding food to accessibleObjectList to RestaurantMenu object.
     */
    public RestaurantMenu(Restaurant chosenRestaurant) {

        this.addAccessibleObject(new Burger("Bacon", 120, 5, 5, this));
        this.addAccessibleObject(new Burger("Cheese", 110, 4, 5, this));
        this.addAccessibleObject(new Burger("Chicken", 110, 4, 5, this));
        this.addAccessibleObject(new Burger("Butter", 110, 4, 5, this));
        this.addAccessibleObject(new Burger("Veggie", 100, 4, 5, this));
        this.addAccessibleObject(new Drink("Coca-cola", 70, 2, 3, this));
        this.addAccessibleObject(new Drink("Faxe Kondi", 70, 2, 3, this));
        this.addAccessibleObject(new Drink("water", 40, 1, 3, this));
        this.addAccessibleObject(new Drink("orange juice", 60, 2, 3, this));
        this.addAccessibleObject(new Drink("apple juice", 60, 2, 3, this));
        this.addAccessibleObject(new Extra("Classic fries", 80, 3, 3, this));
        this.addAccessibleObject(new Extra("Curly fries", 80, 3, 3, this));
        this.addAccessibleObject(new Extra("Onion Rings", 70, 3, 3, this));
        this.addAccessibleObject(new Extra("Salad", 50, 2, 3, this));
        this.addAccessibleObject(chosenRestaurant);
    }

    @Override
    public Boolean canExecute(State state) {
        return true;
    }

    public String getWelcomeMessage() {
        return "MENU: ";
    }

    public String getOptionMessage() {
        return "See MENU";
    }
}
