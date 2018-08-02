public class Main {

    public static void main(String[] args){
        /*
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
        */
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertStart(10);
        doublyLinkedList.insertStart(20);
        doublyLinkedList.insertEnd(5);
        doublyLinkedList.printList();
        System.out.println("====");
        doublyLinkedList.insertAt(15, 1);
        doublyLinkedList.printList();
        doublyLinkedList.printReverse();
        doublyLinkedList.insertAt(44, 3);
        doublyLinkedList.printList();
        doublyLinkedList.printReverse();
        doublyLinkedList.insertAt(99, 90);
        doublyLinkedList.printReverse();
        doublyLinkedList.insertAt(28, 0);
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        doublyLinkedList.printList();
        System.out.println("______________________________________");
        doublyLinkedList.printEverySecondNode();
        doublyLinkedList.insertStart(79);
        doublyLinkedList.printList();
        System.out.println("---------------");
        doublyLinkedList.printEverySecondNode();
    }
}
