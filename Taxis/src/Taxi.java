import java.lang.Math;
/**
 * This Class contains data about taxis' and it is responsible for all taxis' functions
 */
public class Taxi {

    int number;
    TaxiStatusEnum status;
    long startTime;

    /**
     * Creates new instance of the class Taxi.
     * @param number of taxi
     */
    public Taxi(int number){
        this.number = number;
        this.status = TaxiStatusEnum.Free;
    }

    /**
     * This method shows information about taxi; it's number and current status
     */
    public void showTaxiDetails(){
        System.out.println("Taxi number " + number);
        System.out.println("current status: " + status);
        if ((this.status == TaxiStatusEnum.Taken) || (this.status == TaxiStatusEnum.Paused)){
            this.checkTime();
        }
    }

    /**
     * Starts taxi (and time of the ride) or informs user if taxi can't be started
     * Changes taxi's status
     */
    public void start(){
        if (this.status == TaxiStatusEnum.Taken || (this.status == TaxiStatusEnum.FreeRide)){ //covers unexpected scenario
            System.out.println("This taxi is already taken,");
            System.out.println("try to start another one");
        }
        if (this.status == TaxiStatusEnum.Free){
            this.status = TaxiStatusEnum.Taken;
            startTime = System.currentTimeMillis(); //starts measuring ride time
            System.out.println("Started!");
        }
        if (this.status == TaxiStatusEnum.Paused){
            this.status = TaxiStatusEnum.Taken; //restarts taxi
        }
    }
    /**
     * Stops taxi (and time of the ride) or informs user if taxi can't be stopped
     * Changes taxi's status
     */
    public void stop(){
        if (this.status == TaxiStatusEnum.Taken){
            this.status = TaxiStatusEnum.Free;
        }
        else if (this.status == TaxiStatusEnum.Free){ //covers unexpected scenario
            System.out.println("This taxi hasn't been taken.");
            System.out.println("It's free.");
        }
        else if (this.status == TaxiStatusEnum.FreeRide){
            this.status = TaxiStatusEnum.Free;
        }
        else if (this.status == TaxiStatusEnum.Paused){
            this.status = TaxiStatusEnum.Free;
        }
    }

    /**
     * Pauses the ride but it doesn't stop the timer.
     * Changes taxi's status
     */
    public void pause(){
        if (this.status == TaxiStatusEnum.Free){
            System.out.println("This taxi is free.");
            System.out.println("It can't be paused.");
        }
        else{
            this.status = TaxiStatusEnum.Paused;
            System.out.println("Paused!");
        }
    }
    /**
     * Starts free ride.
     * Changes taxi's status.
     */
    public void rideForFree(){
        if (this.status == TaxiStatusEnum.Free){
            this.status = TaxiStatusEnum.FreeRide;
            System.out.println("Free ride!");
        }
        //two other scenarios if taxi can not start free ride:
        else if ((this.status == TaxiStatusEnum.Taken) || (this.status == TaxiStatusEnum.Paused)){
            System.out.println("This taxi is on a paid ride now");
            System.out.println("It has to end this ride to start free ride.");
        }
        else {
            System.out.println("This taxi is already on a free ride");
        }

    }
    /**
     * Checks the status of chosen taxi and shows time of the ride.
     * If it is not possible - gives proper explanation.
     */
    public void checkTime(){
        if (this.status == TaxiStatusEnum.Free){
            System.out.println("No time. This taxi is free");
        }
        if (this.status == TaxiStatusEnum.Taken || (this.status == TaxiStatusEnum.Paused)) {
            double currentRideTime = getCurrentRideTime(); // in seconds
            System.out.printf("Time: %.2f seconds\n" , currentRideTime );
        }
        if (this.status == TaxiStatusEnum.FreeRide){
            System.out.println("This taxi is riding for free now");
            System.out.println("We are not measuring time of this ride.");
        }
    }
    /**
     * This function gives current ride time.
     * @return time of the ride measured in seconds with two decimal.
     */
    public double getCurrentRideTime(){
        if (this.status == TaxiStatusEnum.Taken || (this.status == TaxiStatusEnum.Paused)) {
            double measuredTime = ((System.currentTimeMillis()) - startTime) / 10.0; // to separate unnecessary number
            double currentRideTime = Math.round(measuredTime); //rounds to the nearest integer
            return (currentRideTime/100.0); //to get two decimal places
        }
        throw new IllegalStateException(); //when the function can't measure the time
    }
}
