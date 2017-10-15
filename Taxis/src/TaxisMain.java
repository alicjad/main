import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class TaxisMain is the main class of the program. It is responsible for displaying the menu and handling the user input.
 */
public class TaxisMain {
    final static double PRICE_PER_SECOND = 2.25;
    static TaxiCollection taxis = new TaxiCollection();
    /**
     * Main shows user company's menu and takes the input
     */
    public static void main(String [] args){
        menu();
    }

    /**
     * Shows current status of every taxi
     */
    private static void showAvailability() {
        for(int i=1; i<= taxis.getTotalNumberOfTaxis(); i++){
            taxis.getTaxi(i).showTaxiDetails();
        }
    }

    /**
     * prints the menu for the user
     */
    public static void printMenu() {
        System.out.println();
        System.out.println("Welcome to DAMN FAST TAXIS");
        System.out.println();
        System.out.println("0 --> SHOW OUR TAXIS' AVAILABILITY");
        System.out.println("1 --> START A TAXI");
        System.out.println("2 --> STOP A TAXI");
        System.out.println("3 --> PAUSE A TAXI");
        System.out.println("4 --> ASK FOR PRICE");
        System.out.println("5 --> FREE RIDE");
        System.out.println("6 --> CHECK DURATION OF THE RIDE");
        System.out.println("7 --> QUIT");
        System.out.println();
        System.out.println("*price per second: "+ PRICE_PER_SECOND +"$");
        System.out.println();
        System.out.println("Choose a --> number <-- and hit 'enter'");
    }

    /**
     * This function recognizes user's input and connects it with options from menu
     */
    public static void menu(){
        while (true) {
            printMenu();
            int choice = getIntFromUser();
            switch (choice){
                case 0: showAvailability();
                        break;
                case 1: startTaxi();
                        break;
                case 2: stopTaxi();
                        break;
                case 3: pauseTaxi();
                        break;
                case 4: askForPrice();
                        break;
                case 5: freeRide();
                        break;
                case 6: checkDurationOfTheRide();
                        break;
                case 7:
                    System.out.println("Thank you for choosing Damn Fast Taxis!");
                    System.out.println("We hope that you are pleased with our service");
                    System.out.println("and we are looking forward to drive for you again!");
                    return;
                default:
                    System.out.println("Please choose option number from 0 to 7");
            }
            pressEnterToContinue();
        }
    }

    /**
     * Waits for user to hit Enter.
     */
    public static void pressEnterToContinue(){
        System.out.println("Press Enter to continue");
        Scanner k = new Scanner(System.in);
        k.nextLine();
    }
    /**
     * Asks the user in which taxi he/she is interested in
     * @return number of taxi user wants to use
     */
    public static int askForTaxiNumber(){
        System.out.println("Which taxi?");
        System.out.println("-> choose the number");
        return getIntFromUser();
    }

    /**
     * Gets integer form user.
     * @return integer from user.
     */
    public static int getIntFromUser(){
        while(true){
            try {
                Scanner a = new Scanner(System.in);
                int answer = a.nextInt();
                return answer;
            } catch (InputMismatchException ex) {
                System.out.println("This is not a number");
                System.out.println("Try again");
            }
        }
    }

    /**
     * Gets a taxi from user's input
     * @return taxi with specified number
     */
    public static Taxi getTaxiFromUserInput(){
        while(true) {
            int taxiNumber = askForTaxiNumber();
            try {
                Taxi taxi = taxis.getTaxi(taxiNumber);
                return taxi;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("There is no taxi with such number.");
                System.out.println("Choose another number.");
            }
        }
    }

    /**
     * Starts chosen taxi
     */
    public static void startTaxi(){
        Taxi taxi = getTaxiFromUserInput();
        taxi.start();
    }

    /**
     * Stops chosen taxi
     */
    public static void stopTaxi(){
        Taxi taxi = askForPrice();
        taxi.stop();
    }
    /**
     * Pauses chosen taxi
     */
    public static void pauseTaxi(){
        Taxi taxi = getTaxiFromUserInput();
        taxi.pause();
    }
    /**
     * Makes chosen taxi riding for free
     */
    public static void freeRide(){
        Taxi taxi = getTaxiFromUserInput();
        taxi.rideForFree();
    }

    /**
     * Checks ride time of chosen taxi
     */
    public static void checkDurationOfTheRide(){
        Taxi taxi = getTaxiFromUserInput();
        taxi.checkTime();
    }
    /**
     * Checks time of the ride for chosen taxi, calculates price and prints the bill
     * @return chosen taxi
     */
    public static Taxi askForPrice(){ //type is taxi because we need access to Taxi class
        Taxi taxi = getTaxiFromUserInput();
        try{ //if everything goes right as it should
            double rideTime = taxi.getCurrentRideTime();
            System.out.println("DAMN FAST TAXIS");
            System.out.println("------------------");
            taxi.checkTime();
            System.out.println("Price per second: " + PRICE_PER_SECOND + "$");
            System.out.printf("Total price: %.2f$\n", (rideTime * PRICE_PER_SECOND));
        } // if something goes wrong this option covers the exception
        catch (IllegalStateException ex){
            System.out.println("We are not measuring time for this taxi");
        }
        return taxi;
    }
}
