public class DoublyLinkedList {

    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;


    public DoublyLinkedListNode getTail() {
        return tail;
    }

    public void setTail(DoublyLinkedListNode tail) {
        this.tail = tail;
    }

    public DoublyLinkedListNode getHead() {
        return head;
    }

    public void setHead(DoublyLinkedListNode head) {
        this.head = head;
    }

    public void insertStart(int data){
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(null, data, null);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            newNode.setNextNode(this.head);
            this.head.setPreviousNode(newNode);
            this.setHead(newNode);
        }
    }

    public void insertEnd(int data){
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(null, data, null);
        if (this.head != null){
            newNode.setPreviousNode(this.tail);
            this.tail.setNextNode(newNode);
            this.setTail(newNode);
        }
        else {
            this.setHead(newNode);
            this.setTail(newNode);
        }
    }

    public void insertAt(int data, int position){
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(null, data, null);
        DoublyLinkedListNode rightNode = this.getNodeAt(position);
        if (rightNode == this.tail){
            this.insertEnd(data);
        }
        else if (rightNode == this.head){
            this.insertStart(data);
        }
        else {
            DoublyLinkedListNode leftNode = rightNode.getPreviousNode();
            leftNode.setNextNode(newNode);
            newNode.setPreviousNode(leftNode);
            newNode.setNextNode(rightNode);
            rightNode.setPreviousNode(newNode);
        }
    }

    public DoublyLinkedListNode getNodeAt(int position){
        DoublyLinkedListNode currentNode = this.head;
        int counter = 0;
        while (currentNode.getNextNode() != null && counter != position){
           currentNode = currentNode.getNextNode();
           counter++;
        }
        return currentNode;
    }

    public void printList(){
        if (this.head == null){
            System.out.println("This list is empty");
        }
        else {
            DoublyLinkedListNode currentNode = this.head;
            while (currentNode != null){
                System.out.println(currentNode.nodeData);
                currentNode = currentNode.getNextNode();
            }
        }
    }
    
    public void printListES(){
        if (this.head == null){
            System.out.println("This list is empty");
        }
        else {
            DoublyLinkedListNode currentNode = this.head;
            boolean shouldPrint = true;
            while (currentNode != null){
                if (shouldPrint)
                    System.out.println(currentNode.nodeData);
                shouldPrint = !shouldPrint;
                currentNode = currentNode.getNextNode();
            }
        }
    }

    public void printReverse(){
        if (this.tail == null){
            System.out.println("Empty");
        }
        else {
            DoublyLinkedListNode currentNode = this.tail;
            while (currentNode != null){
                System.out.println(currentNode.nodeData);
                currentNode = currentNode.getPreviousNode();
            }
        }
    }

    public void printEverySecondNode(){
        if (this.head == null){
            System.out.println("List is empty");
        }
        else {
            DoublyLinkedListNode currentNode = this.head;
            while (currentNode != null) {
                System.out.println(currentNode.nodeData);
                if (currentNode.getNextNode() == null || currentNode.getNextNode().getNextNode() == null){
                    break;
                }
                currentNode = currentNode.getNextNode().getNextNode();
            }
        }
    }

}
