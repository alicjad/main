package Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputHandle {

    public void pressEnterToContinue(){
        System.out.println("Press Enter to continue");
        Scanner k = new Scanner(System.in);
        k.nextLine();
    }

    public int getIntFromUser(){
        while(true){
            try {
                Scanner a = new Scanner(System.in);
                int answer = a.nextInt();
                pressEnterToContinue();
                return answer;
            } catch (InputMismatchException ex) {
                System.out.println("This is not a number");
                System.out.println("Try again");
            }
        }
    }

    public String getLineFromUser(){
        Scanner l = new Scanner(System.in);
        String line = l.nextLine();
        return line;
    }

    public int askForGameObjectNumber(){
        System.out.println("Type your number: ");
        return getIntFromUser();
    }
}
