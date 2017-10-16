import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise1 {
    static long startTime;

    public static void main(String[]args){
        for (int j=0; j<1; j++) {
            int[] optionsArray = {15};
            for (int i = 0; i < optionsArray.length; i++) {
                System.out.print(optionsArray[i]);
                int size = optionsArray[i];
                int[] array = new int[size];
                fillOutArray(array);
                printArray(array);
                printArray(selectionSort(array));
                System.out.print(" " + stopTimer() + " ");
                System.out.println();
            }
        }
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

    public static int getIndexOfMaxElement(int[] chosenArray, int upperIndexLimit){
        int maxElement = chosenArray[0];
        int maxIndex = 0;
        for (int i=0; i<upperIndexLimit;i++){
            if (chosenArray[i]>maxElement){
                maxElement=chosenArray[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int[] selectionSort(int[] arrayToSort){
        for (int i=0; i<arrayToSort.length; i++){
            int indexOfMaxElement = getIndexOfMaxElement(arrayToSort, arrayToSort.length - i);
            swapElements(arrayToSort, arrayToSort.length - i-1, indexOfMaxElement);
        }
        return arrayToSort;
    }

    private static void swapElements(int[] arrayToSort, int i, int indexOfMaxElement) {
        int temp = arrayToSort[i];
        arrayToSort[i] = arrayToSort[indexOfMaxElement];
        arrayToSort[indexOfMaxElement] = temp;
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
