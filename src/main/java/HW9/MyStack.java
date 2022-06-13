package HW9;

public class MyStack<T> implements MyCollection <T>{
    private int stackSize = 0;
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

    public void push(T element){
        Node newNode = new Node(element);
        if (stackSize == 0){
            firstElement = newNode;
        } else {
            lastElement.next = newNode;
        }
        lastElement = newNode;
        stackSize++;
    }

    public T pop() {
        T result = lastElement.value;
        remove(stackSize-1);
        Node temp = firstElement;
        for(int i = 0; i < stackSize-1; i++){
            temp = temp.next;
        }
        lastElement = temp;
        return result;
    }

    @Override
    public void remove(int index) {
        if (index>0 && index<stackSize) {
            Node temp = firstElement;
            Node tempPrevious = null;
            for (int i = 0; i < index; i++) {
                tempPrevious = temp;
                temp = temp.next;
            }
            tempPrevious.next = temp.next;
            stackSize--;
        } else if (index == 0) {
            firstElement = firstElement.next;
            stackSize--;
        } else {
            System.out.println("Incorrect index to remove. Element wasn't removed.");
        }
    }

    @Override
    public void clear() {
        stackSize = 0;
        firstElement =null;
    }

    @Override
    public int size() {
        return stackSize;
    }

    @Override
    public T peek() {
        return lastElement.value;
    }

    @Override
    public String toString(){
        String print = "[";
        Node temp = firstElement;
        for(int i = 0; i < stackSize; i++){
            print += temp.value + " ";
            temp = temp.next;
        }
        return print.trim() + "]";
    }
}
