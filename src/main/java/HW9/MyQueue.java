package HW9;

public class MyQueue <T> implements MyCollection <T> {
    private int queueSize = 0;
    private Node firstElement;
    private Node lastElement;

    private class Node{
        Node next;
        T value;

        public Node(T value){
            this.next = null;
            this.value = value;
        }
    }

    public void add(T element){
        Node newNode = new Node(element);
        if (queueSize == 0){
            firstElement = newNode;
        } else {
            lastElement.next = newNode;
        }
        lastElement = newNode;
        queueSize++;
    }

    public T poll() {
        T temp = firstElement.value;
        firstElement = firstElement.next;
        queueSize--;
        return temp;
    }
    @Override
    public void remove(int index) {
        if (index>0 && index<queueSize) {
            Node temp = firstElement;
            Node tempPrevious = null;
            for (int i = 0; i < index; i++) {
                tempPrevious = temp;
                temp = temp.next;
            }
            tempPrevious.next = temp.next;
            queueSize--;
        } else if (index == 0) {
            firstElement = firstElement.next;
            queueSize--;
        } else {
            System.out.println("Incorrect index to remove. Element wasn't removed.");
        }
    }

    @Override
    public void clear() {
        queueSize = 0;
        firstElement =null;
    }

    @Override
    public int size() {
        return queueSize;
    }

    @Override
    public T peek() {
        return firstElement.value;
    }

    @Override
    public String toString(){
        String print = "[";
        Node temp = firstElement;
        for(int i = 0; i < queueSize; i++){
            print += temp.value + " ";
            temp = temp.next;
        }
        return print.trim() + "]";
    }

}
