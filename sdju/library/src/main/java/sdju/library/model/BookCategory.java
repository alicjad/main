package sdju.library.model;

import java.util.HashMap;
import java.util.Map;

public enum BookCategory {
    textbook(1),
    adventure(2),
    crime_fiction(3),
    romance(4);

    public int getValue() {
        return value;
    }

    private int value;
    private static Map map = new HashMap<>();

    private BookCategory(int value){
        this.value = value;
    }

    static {
        for (BookCategory bc : BookCategory.values()) {
            map.put(bc.value, bc);
        }
    }

    public static BookCategory valueOf(int bookCategory){
        return (BookCategory)map.get(bookCategory);
    }
}
