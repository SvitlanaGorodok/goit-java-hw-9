package HW9;

public class ListOfNodes<K,T> {
    private Node firstElement;
    private Node lastElement;
    private int listSize = 0;

    private class Node{
        Node next;
        K key;
        T value;

        public Node(K key, T value){
            this.next = null;
            this.key = key;
            this.value = value;
        }
    }
        private boolean isElementExist(K key){
            Node temp = firstElement;
            for (int i=0; i<listSize;i++){
                if(temp.key == key ){
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }

        public void putElement(K key, T value) {
        if (!isElementExist(key)) {
                Node newNode = new Node(key, value);
                if (listSize == 0) {
                    firstElement = newNode;
                } else {
                    lastElement.next = newNode;
                }
                lastElement = newNode;
                listSize++;
            } else {
                Node temp = firstElement;
                for (int i = 0; i < listSize; i++) {
                    if (temp.key == key) {
                        temp.value = value;
                        return;
                    }
                    temp = temp.next;
                }
            }
        }

    private int keyToIndex(K key){
        Node temp = firstElement;
        for(int i = 0; i < listSize; i++){
            if(temp.key == key){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void removeElement(K key){
        int index = keyToIndex(key);
        if (index>0 && index<listSize) {
            Node temp = firstElement;
            Node tempPrevious = null;
            for (int i = 0; i < index; i++) {
                tempPrevious = temp;
                temp = temp.next;
            }
            tempPrevious.next = temp.next;
            listSize--;
        } else if (index == 0) {
            firstElement = firstElement.next;
            listSize--;
        } else {
            System.out.println("Incorrect key. Element wasn't removed.");
        }
    }

    public int sizeOfList(){
        return listSize;
    }

    public T getElement(K key){
        int index = keyToIndex(key);
        Node temp = firstElement;
        for(int i = 0; i < listSize; i++){
            if (i == index){
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }
    @Override
    public String toString(){
        String print = "";
        Node temp = firstElement;
        for(int i = 0; i < listSize; i++){
            print += temp.value + " ";
            temp = temp.next;
        }
        return print.trim();
    }
}
