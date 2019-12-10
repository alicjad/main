package sdju.library.model;

import java.util.HashMap;
import java.util.Map;

public enum CustomerGrade {
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

    private CustomerGrade(int value){
        this.value = value;
    }

    static {
        for (CustomerGrade cg : CustomerGrade.values()) {
            map.put(cg.value, cg);
        }
    }

    public static CustomerGrade valueOf(int customerGrade){
        return (CustomerGrade) map.get(customerGrade);
    }
}
