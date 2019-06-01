package sdju.library.model;

import java.util.HashMap;
import java.util.Map;

public enum BookStatus {
    unavailable(0),
    available(1),
    borrowed(2),
    reserved(3);

    public int getValue() {
        return value;
    }

    private int value;
    private static Map map = new HashMap<>();

    private BookStatus(int value){
        this.value = value;
    }

    static {
        for (BookStatus bs : BookStatus.values()) {
            map.put(bs.value, bs);
        }
    }

    public static BookStatus valueOf(int bookStatus){
        return (BookStatus) map.get(bookStatus);
    }
}
