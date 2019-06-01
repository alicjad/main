package sdju.library.model;

import java.util.HashMap;
import java.util.Map;

public enum RentalPaymentStatus {
    no_charge(0),
    unpaid(1),
    paid(2);

    public int getValue() {
        return value;
    }

    private int value;
    private static Map map = new HashMap<>();

    private RentalPaymentStatus(int value){
        this.value = value;
    }

    static {
        for (RentalPaymentStatus rs : RentalPaymentStatus.values()) {
            map.put(rs.value, rs);
        }
    }

    public static RentalPaymentStatus valueOf(int rentalPaymentStatus){
        return (RentalPaymentStatus) map.get(rentalPaymentStatus);
    }
}
