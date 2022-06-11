package HW9;

public class MyLinkedList <T> implements MyList<T>{
    private int listSize = 0;
    private Node firstElement;
    private Node lastElement;

    private class Node{
        Node previous;
        Node next;
        T value;

        public Node(Node previous, T value){
            this.previous = previous;
            this.next = null;
            this.value = value;
        }
    }

    @Override
    public void add(T element){
        Node newNode = new Node(lastElement, element);
        if (listSize == 0){
            firstElement = newNode;
        } else {
        lastElement.next = newNode;
        }
        lastElement = newNode;
        listSize ++;
    }

    @Override
    public void remove(int index){
        if (index>0 && index<listSize) {
            Node temp = firstElement;
            Node tempPrevious = null;
            Node tempNext = null;
            for (int i = 0; i <= index; i++) {
                tempPrevious = temp.previous;
                tempNext = temp.next;
                temp = tempNext;
            }
            try {
                tempNext.previous = tempPrevious;
                tempPrevious.next = tempNext;
            } catch (NullPointerException e){
                 tempPrevious.next = null;
            }
            listSize--;
        } else if (index == 0) {
            firstElement = firstElement.next;
            listSize--;
        } else {
            System.out.println("Incorrect index to remove. Element wasn't removed.");
        }
    }

    @Override
    public void clear(){
        listSize = 0;
        firstElement = null;
        lastElement = null;
    }

    @Override
    public int size(){
        return listSize;
    }

    @Override
    public T get(int index){
        if (index>=0 && index<listSize) {
            Node temp = firstElement;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.value;
        } else {
                System.out.println("Incorrect index to get.");
        }
        return null;
    }

    @Override
    public String toString(){
        String print = "[";
        Node temp = firstElement;
        for(int i=0; i<listSize; i++){
            print += temp.value + " ";
            temp = temp.next;
        }
        return print.trim() + "]";
    }

}
