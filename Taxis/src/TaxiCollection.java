/**
 * This class is a collection of taxis
 */
public class TaxiCollection {
    Taxi taxi1 = new Taxi(1);
    Taxi taxi2 = new Taxi(2);
    Taxi taxi3 = new Taxi(3);
    Taxi taxi4 = new Taxi(4);
    Taxi taxi5 = new Taxi(5);
    Taxi taxi6 = new Taxi(6);
    Taxi taxi7 = new Taxi(7);
    Taxi taxi8 = new Taxi(8);
    Taxi taxi9 = new Taxi(9);
    Taxi taxi10 = new Taxi(10);

    /**
     * Gets taxi with specified number.
     * @param number number of the taxi.
     * @return Taxi with the specified number.
     */
    public Taxi getTaxi (int number){
        switch (number){
            case 1: return taxi1;
            case 2: return taxi2;
            case 3: return taxi3;
            case 4: return taxi4;
            case 5: return taxi5;
            case 6: return taxi6;
            case 7: return taxi7;
            case 8: return taxi8;
            case 9: return taxi9;
            case 10: return taxi10;
            default:
                throw new IndexOutOfBoundsException();//when user tries to call non-existent taxi number

        }
    }

    /**
     * Gets total number of taxis.
     * @return total number of taxis
     */
    public int getTotalNumberOfTaxis(){
        return 10;
    }

}
