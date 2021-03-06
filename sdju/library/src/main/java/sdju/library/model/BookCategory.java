package sdju.library.model;

import java.util.HashMap;
import java.util.Map;

public enum BookCategory {
    first(1),
    second(2),
    third(3),
    fourth(4),
    fifth(5),
    middleSchool(6);

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
