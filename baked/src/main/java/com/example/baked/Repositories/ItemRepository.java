package com.example.baked.Repositories;

import com.example.baked.Model.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemRepository implements IItemRepository{

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ItemRepository(){

    }

    @Override
    public Item read(int id) {
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
        return null;
    }
}
