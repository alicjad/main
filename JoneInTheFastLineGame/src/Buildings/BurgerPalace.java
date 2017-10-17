package Buildings;
import Game.Controller;

public class BurgerPalace {
    Controller controller = new Controller();

    private void printMenu(){
        System.out.println("Welcome to Burger Palace!");
        System.out.println("-------------- MENU --------------");
        System.out.println("1. BURGERS: ");
        System.out.println("2. DRINKS: ");
        System.out.println("3. EXTRAS: ");
        System.out.println("0. EXIT");
    }

    private String getChosenProduct(String[] chosenArray){
        int number = controller.getIntFromUser();
        if (number==1){
            return chosenArray[0+1];
        }

    }
    private void menu(){
        printMenu();
        int choice = controller.getIntFromUser();
        switch(choice){
            case 0: break;
            case 1: printArray(getBurgers());
            case 2: printArray(getDrinks());
            case 3: printArray(getExtras());
        }
    }

    private void printArray(String[] chosenArray){
        for (int i=0; i<chosenArray.length; i++){
            System.out.print(i+1 + ". ");
            System.out.println(chosenArray[i+1]);
        }
    }

    private String[] getBurgers(){
    String[] burgers = new String[6];
        burgers[0]= "Bacon burger";
        burgers[1]= "Cheese burger";
        burgers[2]= "Butter burger";
        burgers[3]= "Chicken burger";
        burgers[4]= "Fish burger";
        burgers[5]= "Veggie burger";
    return burgers;
    }

    private String[] getDrinks(){
    String[] drinks = new String[5];
        drinks[0]= "Coca-cola";
        drinks[1]= "Faxe Kondi";
        drinks[2]= "water";
        drinks[3]= "orange juice";
        drinks[4]= "apple juice";
    return drinks;
    }

    private String[] getExtras(){
    String[] extras = new String[4];
        extras[0] = "Classic fries";
        extras[1] = "Curly fries";
        extras[2] = "Onion rings";
        extras[3] = "Salad";
    return extras;
    }
}
