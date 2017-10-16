import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise1forList {

    static long startTime;

    public static void main(String[]args){
        for (int j=0; j<1; j++) {
            int[] optionsArray = {5};
            for (int i = 0; i < optionsArray.length; i++) {
                System.out.print(optionsArray[i]);
                int size = optionsArray[i];
                List<Integer> list = new ArrayList<>();
                fillOutList(list, size);
                int biggestNumber = getBiggestElement(list);
                System.out.print(biggestNumber);
                printList(list);
                printList(selectionSort(list));
                System.out.print(" " + stopTimer() + " ");
                System.out.println();
            }
        }
    }

    public static void fillOutList(List<Integer> listToFillOut, int size){
        Random random = new Random(100);
        for(int i=0; i<size; i++){
            listToFillOut.add(random.nextInt());
        }
    }

    public static void printList(List<Integer> listToPrint){
        System.out.print("list: ");
        for(int i=0; i<listToPrint.size(); i++){
            if (i == listToPrint.size()-1){
                System.out.print(listToPrint.get(i));
                System.out.println();
            }
            else {
                System.out.println(listToPrint.get(i)+ ", ");
            }
        }
    }

    public static int getBiggestElement(List<Integer> chosenList){
        startTimer();
        int biggestElement = chosenList.get(chosenList.size()-1);
        int index = chosenList.size()-1;
        for (int i=chosenList.size()-1; i>=0 ;i--){
            if (chosenList.get(i)>biggestElement){
                biggestElement=chosenList.get(i);
                index = i;
            }
        }
        chosenList.remove(index);
        return biggestElement;
    }

    public static List<Integer> selectionSort(List<Integer> listToSort){
        List <Integer> sortedList = new ArrayList<>();
        while (listToSort.size()!=0){
            int biggestElement = getBiggestElement(listToSort);
            sortedList.add(biggestElement);
        }
        return sortedList;
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
