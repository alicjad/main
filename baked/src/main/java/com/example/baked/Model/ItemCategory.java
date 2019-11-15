package com.example.baked.Model;

import java.util.HashMap;
import java.util.Map;

public enum ItemCategory {

    breadstuff(1),
    cake(2),
    other(3);

    public int getValue() {
        return value;
    }

    private int value;
    private static Map map = new HashMap<>();

    private ItemCategory(int value){
        this.value = value;
    }

    static {
        for (ItemCategory bc : ItemCategory.values()) {
            map.put(bc.value, bc);
        }
    }

    public static ItemCategory valueOf(int bookCategory){
        return (ItemCategory) map.get(bookCategory);
    }
}
