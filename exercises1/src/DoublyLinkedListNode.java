public class DoublyLinkedListNode {

    public DoublyLinkedListNode previousNode;
    public int nodeData;
    public DoublyLinkedListNode nextNode;

    public DoublyLinkedListNode(DoublyLinkedListNode previousNode, int data,DoublyLinkedListNode nextNode){
        this.previousNode = previousNode;
        this.nodeData = data;
        this.nextNode = nextNode;
    }

    public int getNodeData() {
        return nodeData;
    }

    public void setNodeData(int nodeData) {
        this.nodeData = nodeData;
    }

    public DoublyLinkedListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoublyLinkedListNode nextNode) {
        this.nextNode = nextNode;
    }

    public DoublyLinkedListNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoublyLinkedListNode previousNode) {
        this.previousNode = previousNode;
    }
}
