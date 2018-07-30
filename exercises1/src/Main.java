public class Main {

    public static void main(String[] args){
        double startTime = System.currentTimeMillis();
        SingleLinkedList linkedList = new SingleLinkedList();
        for (int i=0; i<10000000; i++){
            linkedList.insertStart(i);
        }
        double endTime = System.currentTimeMillis();
        double time = endTime - startTime;
        System.out.println("time1: " + time);
        double startTime2 = System.currentTimeMillis();
        linkedList.insertAt(1, 9990000);
        double endTime2 = System.currentTimeMillis();
        double time2 = endTime2 - startTime2;
        System.out.println("time2: " + time2);
    }
}
