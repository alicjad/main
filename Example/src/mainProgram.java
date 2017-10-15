import java.util.Scanner;

public class mainProgram {
    public static void main(String[] args){

        String sentence = "fuck duck fuck damn";

        String censor = sentence.toLowerCase().replace("fuck","flowers");

        System.out.println(censor);

        double age = 20.015232323;
        System.out.printf("My age is %.0f", age);
    }
}
