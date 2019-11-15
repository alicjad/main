package com.example.baked.Repositories;

import com.example.baked.Model.Item;
import com.example.baked.Model.ItemCategory;
import com.example.baked.Repositories.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemRepository implements IItemRepository{

    private PreparedStatement preparedStatement;
    private ResultSet result;

    public ItemRepository(){

    }

    @Override
    public Item read(int id) {
        try {
            Connection conn = DbConnection.getConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM item where item_id=?");
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();

            if (result.next()) {
                return new Item(result.getInt("item_id"),
                        result.getString("title"),
                        result.getString("ingredients"),
                        result.getString("description"),
                        result.getInt("time"),
                        result.getString("image"),
                        ItemCategory.valueOf(result.getInt("category"))
                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    @Override
    public void update(Item item) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public ArrayList<Item> readAll() {
        ArrayList<Item> items = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DbConnection.getConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM item");
            result = preparedStatement.executeQuery();

            while(result.next()){

                items.add(new Item(result.getInt("item_id"),
                        result.getString("title"),
                        result.getString("ingredients"),
                        result.getString("description"),
                        result.getInt("time"),
                        result.getString("image"),
                        ItemCategory.valueOf(result.getInt("category"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }

        return items;
    }

    public ArrayList<Item> readAllBreadstuff(ArrayList<Item> items){
        ArrayList<Item> breadstuff = new ArrayList<>();

        for (int i=0; i< items.size(); i++){
            if (items.get(i).getCategory() == ItemCategory.breadstuff){
                breadstuff.add(items.get(i));
            }
        }
        return breadstuff;
    }

    public ArrayList<Item> readAllCakes(ArrayList<Item> items){
        ArrayList<Item> cakes = new ArrayList<>();

        for (int i=0; i< items.size(); i++){
            if (items.get(i).getCategory() == ItemCategory.cake){
                cakes.add(items.get(i));
            }
        }
        return cakes;
    }
}
