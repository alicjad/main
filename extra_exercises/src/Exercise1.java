import java.util.Random;

public class Exercise1 {
    static long startTime;

    public static void main(String[]args){
        int size = 10000000;
        int[] array = new int[size];
        fillOutArray(array);
        int biggestNumber = getBiggestElement(array);
        System.out.print(biggestNumber);
    }

    public static void fillOutArray(int[] arrayToFillOut){
        Random random = new Random(100);
        for(int i=0; i<arrayToFillOut.length; i++){
            arrayToFillOut[i] = random.nextInt();
        }
    }

    public static void printArray(int[] arrayToPrint){
        System.out.print("array: ");
        for(int i=0; i<arrayToPrint.length; i++){
            if (i == arrayToPrint.length-1){
                System.out.print(arrayToPrint[i]);
                System.out.println();
            }
            else {
                System.out.println(arrayToPrint[i]+ ", ");
            }
        }
    }

    public static int getBiggestElement(int[] chosenArray){
        startTimer();
        int biggestElement = chosenArray[0];
        for (int i=0; i<chosenArray.length;i++){
            if (chosenArray[i]>biggestElement){
                biggestElement=chosenArray[i];
            }
        }
        System.out.println("Time: " + stopTimer());
        return biggestElement;
    }

    public static long startTimer(){
        startTime = System.nanoTime();
        return startTime;
    }

    public static long stopTimer(){
        long stopTime = System.nanoTime();
        long currentTime = stopTime - startTime;
        return currentTime;
    }
}
