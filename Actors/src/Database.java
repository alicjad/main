import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Calendar;

public class Database {
    public static String [] [] names = new String[][]{
            {"Arnold Schwarzenegger", "67"},
            {"Justin Timberlake", "35"},
            {"John Travolta", "70"},
            {"Helen Cecilia Burke", "56"}
    };
    public static List<actor> actorList = new ArrayList<actor>();

    public static void main(String[] args){
    //populate with 4 actors
        for (int i=0; i< names.length; i++){
            actorList.add(new actor(names[i][0], Integer.parseInt(names[i][1])));
        }
        actorList.get(0).setGender("male");
        actorList.get(1).setGender("male");
        actorList.get(2).setGender("male");
        actorList.get(3).setGender("female");
        menu();
    }

    public static void displayMenu(){
        System.out.println("Welcome to actors' database!");
        System.out.println("-------- MENU --------");
        System.out.println("1. Display data for chosen actor.");
        System.out.println("2. Display actors' data.");
        System.out.println("3. Search for actor by name and get hers/his index (on this list).");
        System.out.println("4. Search for actor by age and get hers/his name!");
        System.out.println("5. Show all female actors.");
        System.out.println("6. Show all male actors.");
        System.out.println("7. Display statistics about actors' age.");
        System.out.println("8. Create new actor.");
        System.out.println("9. Modify an actor.");
        System.out.println("10. Delete an actor.");
        System.out.println("11. Exit the program.");
    }

    public static void menu(){
        controller controller = new controller();
        while (true) {
            displayMenu();
            int choice = takeNumberFromUser();
            switch (choice){
                case 1: controller.displayActorData();
                    break;
                case 2: controller.displayAllActorsData();
                    break;
                case 3: controller.searchByName();
                    break;
                case 4: controller.searchByAge();
                    break;
                case 5: controller.printActorsOfParticularGender("female");
                    break;
                case 6: controller.printActorsOfParticularGender("male");
                    break;
                case 7: controller.printAllStatisticsAboutAge(0,18,19,30,31, 50, 51);
                    break;
                case 8: controller.addNewActor();
                    break;
                case 9: controller.updateActor();
                    break;
                case 10: controller.removeChosenActor();
                    break;
                case 11:
                    System.out.println("Okay, bye!");
                    System.out.println("Hope you like our database.");
                    return;
                default:
                    System.out.println("Please choose option number from 1 to 11");
            }
            pressEnterToContinue();
        }
    }

    public static void pressEnterToContinue(){
        System.out.println();
        System.out.println("Press Enter to continue");
        Scanner k = new Scanner(System.in);
        k.nextLine();
    }

    public static void temporaryPlanB(){
        String message = "This option is not covered yet, sorry.";
        printLine(message);
    }

    public static int takeNumberFromUser(){
        while(true) {
            try {
                Scanner in = new Scanner(System.in);
                int userNumber = in.nextInt();
                if (userNumber>=0) {
                    return userNumber;
                }
                else {
                    System.out.println("Number must be positive");
                }
            } catch (InputMismatchException ex) {
                System.out.println("This is not a number");
                System.out.println("Try again");
            }
        }
    }

    public static String takeLineFromUser(){
        Scanner a = new Scanner(System.in);
        String answer = a.nextLine();
        return answer;
    }

    public static void printLine(String toPrint){
        System.out.println(toPrint);
    }
    public static void printInt(int toPrint){
        System.out.print(toPrint);
    }
}

class controller{

    public actor addNewActor(){
        Database.printLine("Type name here: ");
        String name = Database.takeLineFromUser();
        Database.printLine("Type age here: ");
        int age = Database.takeNumberFromUser();
        actor newActor = new actor(name, age);
        Database.actorList.add(newActor);
        Database.printLine("New actor has been created.");
        return newActor;
    }

    public void removeChosenActor(){
        while (true) {
            Database.printLine("Do you know index of actor that you want to delete?");
            Database.printLine("type \"yes\" or \"no\".");
            Database.printLine("type \"q\" to quit.");
            String answer = Database.takeLineFromUser();
            if (answer.equals("yes")) {
                Database.printLine("Which actor would you like to delete? (index)");
                Database.printLine("ps. index equals 0 or more.");
                Database.actorList.remove(getActorFromUserInput());
                Database.printLine("Actor has been deleted.");
                break;
            }
            if (answer.equals("no")) {
                searchByName();
                Database.printLine("Which actor would you like to delete? (index)");
                Database.actorList.remove(getActorFromUserInput());
                Database.printLine("Actor has been deleted.");
                break;
            }
            if (answer.equals("q")){
                Database.printLine("No changes has been made.");
                break;
            }
            else {
                Database.printLine("Try again");
                Database.pressEnterToContinue();
            }
        }
    }

    public void displayAllActorsData(){
        for (int i=0; i< Database.actorList.size();i++){
            actor actorToPrint = getActor(i);
            printActorData(actorToPrint);
        }
    }

    public void displayActorData(){
        System.out.print("Type actor's index here: ");
        printActorData(getActorFromUserInput());
    }

    public void printActorData(actor actorToBePrinted){
        System.out.println("--------------ACTOR'S INFO----------------");
        System.out.println("Name: " + actorToBePrinted.getName() );
        System.out.println("Gender: " + actorToBePrinted.getGender() );
        System.out.println("Height: " + actorToBePrinted.getHeight());
        System.out.print("Age: " + actorToBePrinted.getAge() + " ---> " );
        System.out.println("born in: " + actorToBePrinted.getBornYear() );
        System.out.println("Birth place: " + actorToBePrinted.getBornHospital() + ", " + actorToBePrinted.getBornCity() );
        System.out.println("Number of participated movies: " + actorToBePrinted.getFilmsParticipated());
        System.out.println("          ---> Starred in <---            ");
        System.out.println(actorToBePrinted.getMoviesAttended());
        System.out.println("Number of nominations: " + actorToBePrinted.getNominations());
        System.out.println("-------------------------------------------");
    }

    public void showModifyOptions(){
        System.out.println("Choose: ");
        System.out.println("1. name");
        System.out.println("2. age");
        System.out.println("3. height");
        System.out.println("4. born city");
        System.out.println("5. born hospital");
        System.out.println("6. born year");
        System.out.println("7. add movies attended");
        System.out.println("8. nominations");
        System.out.println("9. to quit");
    }

    public actor modifyActor(actor modifyThisActor){
        String message = "Actor has been modified.";
        while (true) {
            showModifyOptions();
            int option = Database.takeNumberFromUser();
            switch (option){
                case 1: System.out.print("Type new name here: ");
                        String newName = Database.takeLineFromUser();
                        modifyThisActor.setName(newName);
                        Database.printLine(message);
                        return modifyThisActor;
                case 2: System.out.print("Type new age here: ");
                        int newAge = Database.takeNumberFromUser();
                        modifyThisActor.setAge(newAge);
                        return modifyThisActor;
                case 3: System.out.print("Type new height here: ");
                        int newHeight = Database.takeNumberFromUser();
                        modifyThisActor.setHeight(newHeight);
                        Database.printLine(message);
                        return modifyThisActor;
                case 4: System.out.print("Type new born city here: ");
                        String newBornCity = Database.takeLineFromUser();
                        modifyThisActor.setBornCity(newBornCity);
                        Database.printLine(message);
                        return modifyThisActor;
                case 5: System.out.print("Type new born hospital name here: ");
                        String newBornHospital = Database.takeLineFromUser();
                        modifyThisActor.setBornHospital(newBornHospital);
                        Database.printLine(message);
                        return modifyThisActor;
                case 6: System.out.print("Type new born year here: ");
                        int newBornYear = Database.takeNumberFromUser();
                        modifyThisActor.setBornYear(newBornYear);
                        Database.printLine(message);
                        return modifyThisActor;
                case 7: System.out.print("Type title of new movie here: ");
                        String newMovie = Database.takeLineFromUser();
                        modifyThisActor.addMovieAttended(newMovie);
                        Database.printLine(message);
                        return modifyThisActor;
                case 8: while (true) {
                            System.out.println("Would you like to 1.add nomination or 2.set nominations?");
                            System.out.println("ps. choose 0 if you want to quit.");
                            int newNumber = Database.takeNumberFromUser();
                            if (newNumber == 1) {
                                System.out.print("Type here how many nominations: ");
                                modifyThisActor.addNomination(Database.takeNumberFromUser());
                            }
                            if (newNumber == 2) {
                                System.out.print("Type number of nominations to set here: ");
                                modifyThisActor.setNominations(Database.takeNumberFromUser());

                            }
                            if (newNumber==0){
                                System.out.println("No changes have been made for nominations.");
                            }
                            else{
                                Database.printLine("Sorry, you have to choose 1, 2 or 0 (quit)");
                            }
                            Database.printLine(message);
                            return modifyThisActor;
                        }
                case 9: Database.printLine("No changes has been made.");
                        return modifyThisActor;
                default:
                    System.out.println("Please choose option number from 1 to 9");
            }
            Database.pressEnterToContinue();
        }
    }

    public void updateActor() {
        while (true) {
            Database.printLine("Do you know the index of actor that you want to modify?");
            Database.printLine("type \"yes\" or \"no\".");
            Database.printLine("ps. Type \"q\" to quit.");
            String choice = Database.takeLineFromUser();
            if (choice.equals("q")) {
                //user doesn't modify anything and see main menu again
                Database.printLine("No changes have been made");
                break;
            }
            if (choice.equals("yes")) {
                //modify an actor
                System.out.print("Type the index here: ");
                actor actorToModify = getActorFromUserInput();
                System.out.println("What would you like to modify?");
                //new menu pops out now
                modifyActor(actorToModify);
                break;
            }
            if (choice.equals("no")) {
                //choose method to get needed index
                Database.printLine("How would you like to find the right actor, by name or age?");
                Database.printLine("type \"name\" or \"age\".");
                Database.printLine("type \"q\" to quit");
                String answer = Database.takeLineFromUser();
                if (answer.equals("q")) {
                    //goes back to the main menu
                    break;
                }
                if (answer.equals("name")) {
                    while (true) {
                        Database.printLine("Type actor's full name here: ");
                        Database.printLine("type \"q\" to quit");
                        String userLine = Database.takeLineFromUser();
                        if (userLine.equals("q")) {
                            //user quits only searching by name option - still can choose to search the index
                            break;
                        }
                        //searching by actor's name
                        int index = search(userLine);
                        if (index != -1) {
                            Database.actorList.set(index, this.modifyActor(Database.actorList.get(index)));
                            Database.printLine("Actor has been modified.");
                            break;
                        } else {
                            //unsuccessful scenario gives the index = -1
                            Database.printLine("There is no actor with such name in our database.");
                            Database.printLine("Try again.");
                            Database.pressEnterToContinue();
                        }
                    }

                }
                if (answer.equals("age")) {
                    while (true) {
                        Database.printLine("Type actor's age here: ");
                        Database.printLine("type 0 to quit.");
                        int userNumber = Database.takeNumberFromUser();
                        int index = search(userNumber);
                        if (userNumber == 0) {
                            //user still can choose how to search for the index (name or age)
                            break;
                        }
                        if (index != -1) {
                            //success
                            Database.actorList.set(index, this.modifyActor(Database.actorList.get(index)));
                            Database.printLine("Actor has been modified.");
                            break;
                        } else {
                            Database.printLine("There is no actor with such age in our database.");
                            Database.printLine("Try again.");
                            Database.pressEnterToContinue();
                        }
                    }
                }
            } else {
                //after that updateActor loop goes again
                Database.printLine("Sorry, you should answer this question with \"yes\" or \"no\"");
                Database.printLine("ps. Type \"q\" to quit.");
                System.out.println("Try again");
                Database.pressEnterToContinue();
            }
        }
    }

    public actor getActorFromUserInput(){
        while(true) {
            int actorIndex = Database.takeNumberFromUser();
            try {
                actor actor = Database.actorList.get(actorIndex);
                return actor;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("There is no actor with such index.");
                System.out.println("Try another index.");
            }
        }
    }

    public actor getActor(int index){
        actor actor = Database.actorList.get(index);
        return actor;
    }

    public int search(int age){
        for (int i=0; i<Database.actorList.size(); i++ ){
            if (Database.actorList.get(i).getAge()== age){
                return i;
            }
        }
        return -1;
    }

    public int search(String name){
        for (int i=0; i<Database.actorList.size(); i++){
            if (Database.actorList.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public void searchByName(){
        while (true) {
            System.out.print("Type name here: ");
            String input = Database.takeLineFromUser();
            if (input.equals("q")){
                break;
            }
            int index = search(input);
            if (index == -1){
                Database.printLine("Sorry, actor not found, try again");
                Database.printLine("ps. type \"q\" to quit");
            }
            else {
                Database.printInt(index);
                break;
            }
        }
    }

    public void searchByAge(){
        while(true) {
            System.out.print("Type age here: ");
            int input = Database.takeNumberFromUser();
            int index = search(input);
            if (index != -1){
                String output = Database.actorList.get(index).getName();
                Database.printLine(output);
                break;
            }
            else{
                Database.printLine("Sorry, actor not found, do you want to try again");
                Database.printLine("Type: \"q\" to quit, hit enter to continue");
                String a = Database.takeLineFromUser();
                if (a.equals("q")){
                    break;
                }
            }
        }
    }

    public void printActorsOfParticularGender(String gender){
        for (int i=0; i<Database.actorList.size(); i++){
            if ((Database.actorList.get(i).getGender().equals(gender))){
                Database.printLine(Database.actorList.get(i).getName());
            }
        }
    }

    public double calculateStatisticsAboutAge(int minRange, int maxRange){
        int counter=0;
        for (int i=0; i<Database.actorList.size(); i++){
            if (Database.actorList.get(i).getAge()>minRange && Database.actorList.get(i).getAge()<maxRange){
                counter++;
            }
        }
        double percentage = ((double) counter/(Database.actorList.size()));
        percentage= percentage*100;
        return percentage;
    }

    public double calculateLastAgeRangeStatistics(int minRageOnly){
        return calculateStatisticsAboutAge(minRageOnly, Integer.MAX_VALUE);
    }

    public void printPercentageOfActorsAge(int minAge, int maxAge){
        System.out.println("Percentage of actors within "+ minAge+" - "+maxAge+" years equals "+ calculateStatisticsAboutAge(minAge, maxAge)+"%");
    }

    public void printPercentageOfActorsLastAgeRage(int minRageOnly){
        System.out.println("Percentage of actors within "+ minRageOnly+ "+ years equals "+ calculateLastAgeRangeStatistics(minRageOnly)+ "%");
    }

    public void printAllStatisticsAboutAge(int minAge1, int maxAge1, int minAge2, int maxAge2, int minAge3, int maxAge3, int minAgeOnly){
        printPercentageOfActorsAge(minAge1, maxAge1);
        printPercentageOfActorsAge(minAge2, maxAge2);
        printPercentageOfActorsAge(minAge3, maxAge3);
        printPercentageOfActorsLastAgeRage(minAgeOnly);
        System.out.println();
        printTheOldestActor();
    }

    public actor findTheOldestActor(){
        actor theOldestActor=null;
        for (int i=0; i<Database.actorList .size(); i++){
            actor current = Database.actorList.get(i);
            if (theOldestActor==null || theOldestActor.getAge()<current.getAge()) {
                theOldestActor = current;
            }
        }
        return theOldestActor;
    }

    public void printTheOldestActor(){
        System.out.println("The oldest actor from this list: "+ findTheOldestActor().getName());
    }

}

class actor{

    private String name;
    private int age;
    private String gender;
    private int bornYear;
    private String bornHospital;
    private String bornCity;
    private int height;
    private int nominations;
    private int filmsParticipated;

    private List<String> moviesAttended = new ArrayList<String>();

    public void addMovieAttended(String movie){
        this.moviesAttended.add(movie);
        this.filmsParticipated++;
    }

    public void addNomination(int nomination){
        this.nominations += nomination;
    }

    actor(String actorName, int actorAge){
        this.name = actorName;
        setAge(actorAge);
        this.filmsParticipated = 0;
    }
    actor(){
        this.filmsParticipated = 0;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
        this.bornYear = Calendar.getInstance().get(Calendar.YEAR) - age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setMoviesAttended(List<String> moviesAttended) {
        this.moviesAttended = moviesAttended;
    }

    public List<String> getMoviesAttended() {
        return moviesAttended;
    }

    public void setBornYear(int bornYear){
        this.bornYear = bornYear;
        this.age = Calendar.getInstance().get(Calendar.YEAR) - bornYear;
    }

    public int getBornYear(){
        return bornYear;
    }

    public void setBornHospital(String bornHospital) {
        this.bornHospital = bornHospital;
    }

    public String getBornHospital() {
        return bornHospital;
    }

    public void setBornCity(String bornCity) {
        this.bornCity = bornCity;
    }

    public String getBornCity() {
        return bornCity;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setNominations(int nominations) {
        this.nominations = nominations;
    }

    public int getNominations() {
        return nominations;
    }

    //todo: ask if we can return list length? instead of duplicating filmsParticipated
    public void setFilmsParticipated(int filmsParticipated) {
        this.filmsParticipated = filmsParticipated;
    }

    public int getFilmsParticipated() {
        return filmsParticipated;
    }

}