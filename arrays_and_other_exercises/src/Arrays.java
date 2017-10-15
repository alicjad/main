import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        String[] inputs = new String[3];
        int firstAvailableIndex = 0;
        while (true) {
            Scanner in = new Scanner(System.in);
            for (int i = firstAvailableIndex; i < inputs.length; i++) {
                String input = in.nextLine();
                inputs[i] = input;
            }
            String[] inputs2 = new String[inputs.length * 2];
            for (int i = 0; i < inputs.length; i++) {
                inputs2[i] = inputs[i];
            }
            firstAvailableIndex = inputs.length;
            inputs = inputs2;
        }
    }
}
