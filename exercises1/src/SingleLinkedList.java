public class SingleLinkedList {

    SingleLinkedListElement head;

    public void printElements(){
        SingleLinkedListElement currentElement = this.head;
        while (currentElement != null){
            System.out.println(currentElement.getData());
            currentElement = currentElement.getNextElement();
        }
    }

    public void insertStart(int data){
        SingleLinkedListElement newElement = new SingleLinkedListElement();
        newElement.setData(data);
        newElement.setNextElement(this.head);
        this.head = newElement;
    }

    public void insertEnd(int data){
        SingleLinkedListElement newLastElement = new SingleLinkedListElement();
        newLastElement.setData(data);
        this.getLastElement().setNextElement(newLastElement);

    }

    public SingleLinkedListElement getLastElement(){
        SingleLinkedListElement currentElement = this.head;
        while (currentElement.getNextElement() != null){
            currentElement = currentElement.getNextElement();
        }
        return currentElement;
    }

    public SingleLinkedListElement getElementAt(int position) {
        int counter = 0;
        SingleLinkedListElement currentElement = this.head;
        while (currentElement.getNextElement() != null && counter != position){
            currentElement = currentElement.getNextElement();
            counter++;
        }
        return currentElement;
    }

    public void printElementAt(int position){
        System.out.println(this.getElementAt(position).getData());
    }

    public SingleLinkedListElement insertAt(int data, int position){
        SingleLinkedListElement newElement = new SingleLinkedListElement();
        if (position != 0){
            SingleLinkedListElement leftElement = this.getElementAt(position-1);
            if(leftElement == null){
                this.insertEnd(data);
            }
            else {
                newElement.setData(data);
                leftElement.setNextElement(newElement);
                SingleLinkedListElement rightElement = leftElement.getNextElement();
                newElement.setNextElement(rightElement);
            }
        }
        else {
            this.insertStart(data);
        }
        return newElement;
    }
}
