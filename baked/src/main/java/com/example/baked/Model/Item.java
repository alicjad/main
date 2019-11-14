package com.example.baked.Model;

public class Item {

    private int id;
    private String title;
    private String ingredients;
    private String description;
    private int time;
    private String image;
    private ItemCategory category;

    public Item(){

    }

    public Item(int id, String title, String ingredients, String description, int time,
                String image, ItemCategory category){
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
        this.description = description;
        this.time = time;
        this.image = image;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }
}
