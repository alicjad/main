package com.example.baked.Repositories;

import com.example.baked.Model.Item;

import java.util.ArrayList;

public interface IItemRepository {

    Item read(int id);
    void update(Item item);
    void delete(int id);
    ArrayList<Item> readAll();
}
