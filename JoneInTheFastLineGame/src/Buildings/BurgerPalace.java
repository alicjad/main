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
        System.out.println("4. TAKE BILL AND PAY");
        System.out.println("0. EXIT");
    }

    private String getChosenProduct(String[] chosenArray){
        while (true) {
            System.out.println("hint: choose \"0\" to quit.");
            System.out.print("Type your number here: ");
            int number = controller.getIntFromUser();
            if (number == 0){
                break;
            }
            if (number <= chosenArray.length) {
                return chosenArray[number - 1];
            } else {
                System.out.println("Sorry, you should type the number of desired product");
            }
        }
        return "no chosen product";
    }
    private int getPriceOfOrderedBurger(String chosenProduct){
        int priceOfChosenProduct = 0;
        if (chosenProduct.equals("no chosen product")){
            return priceOfChosenProduct;
        }
        if (chosenProduct.equals("Bacon burger,  120")){
            priceOfChosenProduct = 120;
        }
        if (chosenProduct.equals("Butter burger, 110")){
            priceOfChosenProduct = 110;
        }
        if (chosenProduct.equals("Cheese burger, 120")){
            priceOfChosenProduct = 120;
        }
        if (chosenProduct.equals("Chicken burger,110")){
            priceOfChosenProduct = 110;
        }
        if (chosenProduct.equals("Fish burger,   120")){
            priceOfChosenProduct = 120;
        }
        if (chosenProduct.equals("Veggie burger, 110")){
            priceOfChosenProduct = 110;
        }
        return priceOfChosenProduct;
    }
    private int getPriceOfOrderedDrink(String chosenProduct){
        int priceOfChosenProduct = 0;
        if (chosenProduct.equals("no chosen product")){
            return priceOfChosenProduct;
        }
        if (chosenProduct.equals("Coca-cola,      80")){
            priceOfChosenProduct = 80;
        }
        if (chosenProduct.equals("Faxe Kondi,     70")){
            priceOfChosenProduct = 70;
        }
        if (chosenProduct.equals("water,          40")){
            priceOfChosenProduct = 40;
        }
        if (chosenProduct.equals("orange juice,   80")){
            priceOfChosenProduct = 80;
        }
        if (chosenProduct.equals("apple juice,   70")){
            priceOfChosenProduct = 70;
        }
        return priceOfChosenProduct;
    }
    private int getPriceOfOrderedExtra(String chosenProduct){
        int priceOfChosenProduct = 0;
        if (chosenProduct.equals("no chosen product")){
            return priceOfChosenProduct;
        }
        if (chosenProduct.equals("Classic fries,  60")){
            priceOfChosenProduct = 60;
        }
        if (chosenProduct.equals("Curly fries,    60")){
            priceOfChosenProduct = 60;
        }
        if (chosenProduct.equals("Onion rings,    50")){
            priceOfChosenProduct = 50;
        }
        if (chosenProduct.equals("Salad,          50")){
            priceOfChosenProduct = 50;
        }
        return priceOfChosenProduct;
    }

    private void printBill(){
        System.out.println("    BURGER PALACE   ");
        System.out.println("------------------------");
        System.out.println();
    }

    private void menu(){
        printMenu();
        String paymentStatus = "0";
        int choice = controller.getIntFromUser();
        switch(choice){
            case 0: break;
            case 1: printArray(getBurgers());
                    String orderedBurger = getChosenProduct(getBurgers());
                    getPriceOfOrderedBurger(orderedBurger);
            case 2: printArray(getDrinks());
                    String orderedDrink = getChosenProduct(getDrinks());
                    getPriceOfOrderedDrink(orderedDrink);
            case 3: printArray(getExtras());
                    String orderedExtra = getChosenProduct(getExtras());
                    getPriceOfOrderedExtra(orderedExtra);
            case 4:
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
        burgers[0]= "Bacon burger,  120";
        burgers[1]= "Cheese burger, 120";
        burgers[2]= "Butter burger, 110";
        burgers[3]= "Chicken burger,110";
        burgers[4]= "Fish burger,   120";
        burgers[5]= "Veggie burger, 110";
    return burgers;
    }

    private String[] getDrinks(){
    String[] drinks = new String[5];
        drinks[0]= "Coca-cola,      80";
        drinks[1]= "Faxe Kondi,     70";
        drinks[2]= "water,          40";
        drinks[3]= "orange juice,   80";
        drinks[4]= "apple juice,    70";
    return drinks;
    }

    private String[] getExtras(){
    String[] extras = new String[4];
        extras[0] = "Classic fries,  60";
        extras[1] = "Curly fries,    60";
        extras[2] = "Onion rings,    50";
        extras[3] = "Salad,          50";
    return extras;
    }
}
